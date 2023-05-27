package repository;

import entity.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import resources.Hash;

/**
 *
 * @author King Shadow
 */
public class AddressRepository 
{
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("CryptoWebWalletPU");
    private static final EntityManager ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();
    
    /**
     * Returns all existing addresses. Might have a whole lot of records.
     * @return all existing addresses
     */
    public static List<Address> getAllAddresses()
    {
        TypedQuery<Address> query = ENTITY_MANAGER.createQuery("SELECT a FROM Address a", Address.class);
        
        return query.getResultList();
    }
    
    /**
     * Filters and returns the first address that match this address string. Will be later improved to filter the addresses based on the parent chain to improve performance.
     * @param address
     * @return the first that match this address string.
     */
    public static Address getAddressByAddressStr(String address)
    {
        for(Address add : getAllAddresses())
        {
            if(add.getAddress().equals(address))
                return add;
        }
        
        return null;
    }
    
    /**
     * Returns an AddressTokenBalance object that matches the specified parameters from the list of addressTokenBalances belonging to the address passed in the parameter.
     * @param address
     * @param token
     * @return an AddressTokenBalance object that matches the specified parameters
     */
    public static AddressTokenBalance getAddressTokenBalance(Address address, Token token)
    {
        for(AddressTokenBalance addressTokenBalance : address.getTokenBalances())
            if(addressTokenBalance.getToken().equals(token))
                return addressTokenBalance;
        return null;
    }    
    
    
    public static String generateNewAddress(Blockchain chain, String seedPhrase)
    {
        return BlockchainRepository.generateNewAddress(chain, seedPhrase);
    }

    public static void generatePrivateKeys(Address address, Blockchain chain)
    {
        if(address.getSeedWords() != null)
            return;
        
        generatePrivateKeys(address);
        
        while(addressExistsByHashedSeedPhrase(address.getHashedSeedPhrase(), chain))
            generatePrivateKeys(address);
    }
    
    private static void generatePrivateKeys(Address address)
    {
        address.setSeedWords(SeedWordsRepository.generateSeedWords(12));
        address.setSeedPhrase(SeedWordsRepository.toPhrase(address.getSeedWords()));
        address.setPrivateKey(generatePrivateKey(address));
        address.setHashedSeedPhrase(Hash.SHA_256_String(Hash.MD5_String(address.getSeedPhrase())));
        address.setHashedPrivateKey(Hash.SHA_256_String(Hash.MD5_String(address.getPrivateKey())));
    }
    
    public static void generateVoidPrivateKeys(Address address)
    {
        address.setSeedWords(SeedWordsRepository.generateSeedWords(12));
        address.setSeedPhrase(SeedWordsRepository.toPhrase(address.getSeedWords()));
        address.setPrivateKey(generatePrivateKey(address));
        address.setHashedSeedPhrase(Hash.SHA_256_String(Hash.MD5_String(address.getSeedPhrase())));
        address.setHashedPrivateKey(Hash.SHA_256_String(Hash.MD5_String(address.getPrivateKey())));
    }

    public static String generatePrivateKey(Address address)
    {
        return SeedWordsRepository.generatePrivateKey(address);
    }
    
    public static boolean addressExists(Address address, Blockchain chain)
    {
        return addressExistsByHashedSeedPhrase(address.getHashedSeedPhrase(), chain);
    }
    
    public static boolean addressExistsByHashedSeedPhrase(String hashedSeedPhrase, Blockchain chain)
    {
        TypedQuery<Address> addressQuery = ENTITY_MANAGER.createNamedQuery("Address.findAddressBySeedPhrase", Address.class);
        addressQuery.setParameter("seedPhrase", hashedSeedPhrase);
        if(addressQuery.getResultList().isEmpty())
            return false;
        else
            return addressQuery.getResultList().stream().anyMatch((address) -> (address.getHashedSeedPhrase().equals(hashedSeedPhrase) 
                    && address.getParentChain().equals(chain)));
    }
    
    public static boolean addressExistsByHashedPrivateKey(String hashedPrivateKey, Blockchain chain)
    {
        TypedQuery<Address> addressQuery = ENTITY_MANAGER.createNamedQuery("Address.findAddressByPrivateKey", Address.class);
        addressQuery.setParameter("privateKey", hashedPrivateKey);
        
        if(addressQuery.getResultList().isEmpty())
            return false;
        else
            return addressQuery.getResultList().stream().anyMatch((address) -> (address.getHashedPrivateKey().equals(hashedPrivateKey) 
                    && address.getParentChain().equals(chain)));
    }
    
    public static Address getAddressByHashedSeedPhrase(String hashedSeedPhrase, Blockchain chain)
    {
        TypedQuery<Address> addressQuery = ENTITY_MANAGER.createNamedQuery("Address.findAddressBySeedPhrase", Address.class);
        addressQuery.setParameter("seedPhrase", hashedSeedPhrase);
        
        return addressQuery.getSingleResult();
    }
    
    public static Address getAddressByHashedPrivateKey(String hashedPrivateKey, Blockchain chain)
    {
        TypedQuery<Address> addressQuery = ENTITY_MANAGER.createNamedQuery("Address.findAddressByPrivateKey", Address.class);
        addressQuery.setParameter("privateKey", hashedPrivateKey);
        
        return addressQuery.getSingleResult();
    }
    
    public static void main(String[] args)
    {
//        Address address = getAddressByAddressStr("1K4V3A274R6P1Y4T5X3H681O4C5O1V1M60143M1H1X203O6N4B5V5I1Y1K");
//        for(AddressTokenBalance addressTokenBalance : address.getTokenBalances())
//        {
//            System.out.println("Token: " + addressTokenBalance.getToken());
//            System.out.println("Balance: " + addressTokenBalance.getBalance());
//            System.out.println();
//        }
        
        System.out.println("Double: " + new Double(null));
    }
    
    /**
     * Sends tokens from an address to another.
     * @param sender The address that will be sending the tokens.
     * @param token The token being sent.
     * @param amountTransferred The amount being transferred. Measured in tokens.
     * @param recipient The address that will be receiving the tokens.
     * @return a Transaction object that contains the details of the transaction.
     */
    public static Transaction sendTokens(Address sender, Token token, double amountTransferred, Address recipient)
    {
        if(amountTransferred <= 0)
            throw new IllegalArgumentException("Amount transferred should be more than zero.");
        
        double tokenBalance = getAddressTokenBalance(sender, token).getBalance();
        
        if(new Double(tokenBalance) == null)
            throw new IllegalArgumentException("Token balance of address could not be derived. Please try again later.");
        
        System.out.println("Sender: " + sender);
        System.out.println("Balance of token sent: " + tokenBalance);
        System.out.println("Token sent: " + token);
        
        if(tokenBalance < amountTransferred)
            throw new IllegalArgumentException("Insufficient funds!!!");
        
        if(!token.getParentChain().equals(recipient.getParentChain()))
        {
            burnTokens(sender, token, amountTransferred);
            return null;
        }
        
        setAddressTokenBalance(sender, token, tokenBalance - amountTransferred);
        
        receiveTokens(recipient, token, amountTransferred);
        
        updateAddress(sender);
        
        return new Transaction(sender, recipient, token, amountTransferred);
    }
    
    public static void receiveTokens(Address receiver, Token token, double amountReceived)
    {
        double tokenBalance = 0;
        boolean containsToken = false;
        
        for(AddressTokenBalance addressTokenBalance : receiver.getTokenBalances())
        {
            if(addressTokenBalance.getToken().equals(token))
            {
                containsToken = true;
                tokenBalance = addressTokenBalance.getBalance();
            }
        }
        
        if(!containsToken)
            receiver.getTokenBalances().add(new AddressTokenBalance(receiver, token, tokenBalance));
        
        setAddressTokenBalance(receiver, token, tokenBalance + amountReceived);
        System.out.println("Amount received: " + amountReceived);
        System.out.println("Receiver amount now: " + getAddressTokenBalance(receiver, token));
        
        updateAddress(receiver);
    }

    private static void burnTokens(Address sender, Token token, double amountBurnt)
    {
        setAddressTokenBalance(sender, token, getAddressTokenBalance(sender, token).getBalance() - amountBurnt);
        updateAddress(sender);
    }

    public static void updateAddress(Address address)
    {
        ENTITY_MANAGER.getTransaction().begin();
        ENTITY_MANAGER.merge(address);
        ENTITY_MANAGER.getTransaction().commit();
    }

    public static double computeTotalBalanceInNT(Address address)
    {
        Token nativeToken = address.getParentChain().getNativeToken();
        double nativeTokenUnitValue = nativeToken.getValueInUSD();
        double totalValue = computeTotalBalanceInUSD(address);
        
        double totalBalanceInNT = totalValue / nativeTokenUnitValue;
        
        return totalBalanceInNT;
    }
    
    /**
     * Computes and returns the total value in USD of all the tokens in the address, using their respective conversion rates.
     * @param address
     * @return the total value of all the tokens in the address in USD.
     */
    public static double computeTotalBalanceInUSD(Address address)
    {
        double totalValue = 0;
        
        for(Token token : getAddressTokens(address))
        {
            for(Token hostedToken : address.getParentChain().getTokensHosted())
            {
                if(getAddressTokenBalance(address, hostedToken) != null)
                {
                    double hostedTokenBalance = getAddressTokenBalance(address, hostedToken).getBalance();
                    totalValue += TokenRepository.getTokenBalanceInUSD(hostedToken, hostedTokenBalance);
                }
            }
        }
        
        return totalValue;
    }
    
    private static void setAddressTokenBalance(Address address, Token token, double newBalance)
    {
        for(AddressTokenBalance addressTokenBalance : address.getTokenBalances())
        {
            if(addressTokenBalance.getToken().equals(token))
                addressTokenBalance.setBalance(newBalance);
        }
    }

    public static List<Token> getAddressTokens(Address address)
    {
        List<Token> addressTokens = new ArrayList<>();
        
        for(AddressTokenBalance addressTokenBalance : address.getTokenBalances())
            addressTokens.add(addressTokenBalance.getToken());
        
        return addressTokens;
    }
}