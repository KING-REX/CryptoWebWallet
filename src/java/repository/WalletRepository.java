package repository;

import entity.*;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import resources.Hash;

/**
 *
 * @author King Shadow
 */
public class WalletRepository 
{
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("CryptoWebWalletPU");
    private static final EntityManager ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();
    private static final SecureRandom RANDOM = new SecureRandom();
    
    /**
     * Retrieves the first wallet to which this address belongs.
     * @param address wallet address to be searched for
     * @return the first Wallet that has the address
     */
    public static Wallet getWalletByAddress(String address)
    {
        TypedQuery<Wallet> typedQuery = ENTITY_MANAGER.createNamedQuery("Wallet.findWalletByAddress", Wallet.class);
        typedQuery.setParameter("address", address);
        
        return typedQuery.getSingleResult();
    }
    
    /**
     * Retrieves all multichain wallets from the database
     * @return a list of multichain wallets
     */
    public static List<MultiChainWallet> getAllMCWallets()
    {
        TypedQuery<MultiChainWallet> mcQuery = ENTITY_MANAGER.createQuery("SELECT m FROM MultiChainWallet m", MultiChainWallet.class);
        
        return mcQuery.getResultList();
    }
    
    /**
     * Retrieves all singlechain wallets from the database
     * @return a list of singlechain wallets
     */
    public static List<SingleChainWallet> getAllSCWallets()
    {
        TypedQuery<SingleChainWallet> scQuery = ENTITY_MANAGER.createQuery("SELECT s FROM SingleChainWallet s", SingleChainWallet.class);
        
        return scQuery.getResultList();
    }

    /**
     * Retrieves the multichain wallet with the specified id
     * @param id the id of the multichain wallet
     * @return the multichain wallet with the specified id
     */
    public static MultiChainWallet findMCWalletById(long id)
    {
        TypedQuery<MultiChainWallet> mcQuery = ENTITY_MANAGER.createNamedQuery("Wallet.findMCWalletById", MultiChainWallet.class);
        mcQuery.setParameter("id", id);
        
        return mcQuery.getSingleResult();
    }

    /**
     * Retrieves the singlechain wallet with the specified id
     * @param id the id of the singlechain wallet
     * @return the singlechain wallet with the specified id
     */
    public static SingleChainWallet findSCWalletById(long id)
    {
        TypedQuery<SingleChainWallet> scQuery = ENTITY_MANAGER.createNamedQuery("Wallet.findSCWalletById", SingleChainWallet.class);
        scQuery.setParameter("id", id);
        
        return scQuery.getSingleResult();
    }

    /**
     * Used for importing a singlechain wallet by seed phrase
     * @param seedPhrase 12 or 24 words separated by spaces that uniquely identifies each wallet, used to retrieve the wallet
     * @param chain the parent chain of the singlechain wallet
     * @return the imported wallet, if it exists, null otherwise
     */
    public static SingleChainWallet getSCWalletBySeedPhrase(String seedPhrase, Blockchain chain)
    {
        String hashedSeedPhrase = Hash.SHA_256_String(Hash.MD5_String(seedPhrase));
        
        for(SingleChainWallet singleChainWallet : getAllSCWallets())
        {
            if(singleChainWallet.getAddress().getHashedSeedPhrase().equals(hashedSeedPhrase) && singleChainWallet.getChain().equals(chain))
                return singleChainWallet;
        }
        
        return null;
    }

    /**
     * Used for importing a singlechain wallet by private key
     * @param privateKey a string of alphanumeric characters that uniquely identifies each wallet, used to retrieve the wallet
     * @param chain the parent chain of the singlechain wallet
     * @return the imported wallet, if it exists, null otherwise
     */
    public static SingleChainWallet getSCWalletByPrivateKey(String privateKey, Blockchain chain)
    {
        String hashedPrivateKey = Hash.SHA_256_String(Hash.MD5_String(privateKey));
        
        for(SingleChainWallet singleChainWallet : getAllSCWallets())
        {
            if(singleChainWallet.getAddress().getHashedPrivateKey().equals(hashedPrivateKey) && singleChainWallet.getChain().equals(chain))
                return singleChainWallet;
        }
        
        return null;
    }

    /**
     * Used for importing a multichain wallet by seed phrase
     * @param seedPhrase 12 or 24 words separated by spaces that uniquely identifies each wallet, used to retrieve the wallet
     * @return the imported wallet, if it exists, null otherwise
     */
    public static MultiChainWallet getMCWalletBySeedPhrase(String seedPhrase)
    {
        String hashedSeedPhrase = Hash.SHA_256_String(Hash.MD5_String(seedPhrase));
        
        for(MultiChainWallet multiChainWallet : getAllMCWallets())
        {
            if(multiChainWallet.getWallets().get(0).getAddress().getHashedSeedPhrase().equals(hashedSeedPhrase))
                return multiChainWallet;
        }
        
        return null;
    }

    /**
     * Used for importing a multichain wallet by seed phrase
     * @param privateKey a string of alphanumeric characters that uniquely identifies each wallet, used to retrieve the wallet
     * @return the imported wallet, if it exists, null otherwise
     */
    public static MultiChainWallet getMCWalletByPrivateKey(String privateKey)
    {
        String hashedPrivateKey = Hash.SHA_256_String(Hash.MD5_String(privateKey));
        
        for(MultiChainWallet multiChainWallet : getAllMCWallets())
        {
            if(multiChainWallet.getWallets().get(0).getAddress().getHashedPrivateKey().equals(hashedPrivateKey))
                return multiChainWallet;
        }
        
        return null;
    }

    /**
     * Computes the total value in USD of all the singlechain wallets in the multichain wallet. Used for 
     * @param multiChainWallet the multichain wallet whose total value should be computed
     * @return the total value in USD of the multichain wallet
     */
    public static double computeTotalMCValue(MultiChainWallet multiChainWallet)
    {
        double totalValue = 0;
        for(SingleChainWallet singleChainWallet : multiChainWallet.getWallets())
        {
            totalValue += computeTotalSCValue(singleChainWallet);
        }
        
        return totalValue;
    }
    
    /**
     * Computes the total value in USD of all the tokens in the singlechain wallet
     * @param singleChainWallet the singlechain wallet whose total value should be computed
     * @return the total value in USD of the singlechain wallet
     */
    public static double computeTotalSCValue(SingleChainWallet singleChainWallet)
    {
        double totalValue = 0;
        
        totalValue = AddressRepository.computeTotalBalanceInUSD(singleChainWallet.getAddress());
        
        return totalValue;
    }

    /**
     * Computes the total value of the singlechain wallet in the Native Token's currency. The native token is the major token of the parent blockchain.
     * @param singleChainWallet the singlechain wallet whose total value should be computed
     * @return the total value of the singlechain wallet in the Native Token's currency
     */
    public static double computeTotalBalanceInNativeToken(SingleChainWallet singleChainWallet)
    {
        Token nativeToken = singleChainWallet.getChain().getNativeToken();
        double nativeTokenUnitValue = nativeToken.getValueInUSD();
        double totalValue = computeTotalSCValue(singleChainWallet);
        
        double totalBalanceInNT = totalValue / nativeTokenUnitValue;
        
        return totalBalanceInNT;
    }
    
//    public static void main(String[] args)
//    {
//        SingleChainWallet wallet = ENTITY_MANAGER.find(SingleChainWallet.class, 2L);
//        
//        System.out.println("Total balance in " + wallet.getChain().getNativeToken().getSymbol() + " : " + computeTotalBalanceInNativeToken(wallet));
//    }
}