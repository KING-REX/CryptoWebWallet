package repository;

import entity.Blockchain;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.util.encoders.Base32;
import resources.Base58;
import resources.Hash;

/**
 *
 * @author King Shadow
 */
public class BlockchainRepository 
{
    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("CryptoWebWalletPU");
    public static final EntityManager ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();

    public static List<Blockchain> getAllSupportedBlockchains()
    {
        List<Blockchain> supportedChains = new ArrayList<>();
        getAllBlockchains().forEach((blockchain) -> {
            if(blockchain.getChain().isSupported())
                supportedChains.add(blockchain);
        });
        
        return supportedChains;
    }
    
    public static List<Blockchain> getAllBlockchains()
    {
        TypedQuery<Blockchain> query = ENTITY_MANAGER.createQuery("SELECT b FROM Blockchain b", Blockchain.class);
        
        return query.getResultList();
    }
    
    public static Blockchain getBlockchainByName(String blockchainName)
    {
        for(Blockchain chain : getAllBlockchains())
        {
            if(chain.getChain().getName().equals(blockchainName) || chain.getChain().name().equals(blockchainName))
                return chain;
        }
        
        return null;
    }
    
    public static void addBlockchain(Blockchain chain)
    {
        if(chainExists(chain))
            throw new IllegalArgumentException("Chain already exists");
        
        ENTITY_MANAGER.getTransaction().begin();
        ENTITY_MANAGER.persist(chain);
        ENTITY_MANAGER.getTransaction().commit();
    }
    
    public static void updateBlockchain(Blockchain chain)
    {
        ENTITY_MANAGER.getTransaction().begin();
        ENTITY_MANAGER.merge(chain);
        ENTITY_MANAGER.getTransaction().commit();
    }
    
    public static boolean chainExists(Blockchain chain)
    {
        return ENTITY_MANAGER.find(Blockchain.class, chain.getId()) != null;
    }
    
    public static boolean isValidAddress(String address, Blockchain chain)
    {
        if(chain.getAddressFormat().equals(""))
            throw new UnsupportedOperationException(String.format("%s Blockchain not supported yet.", chain.getChain().toString()));
        return address.matches(chain.getAddressFormat());
    }
    
    public static boolean isValidAddress(String address, Blockchain.Chain chain)
    {
        if(chain.getAddressFormat().equals(""))
            throw new UnsupportedOperationException(String.format("%s Blockchain not supported yet.", chain.toString()));
        return address.matches(chain.getAddressFormat());
    }
    
    public static String generateNewAddress(Blockchain chain, String seedPhrase)
    {
        switch(chain.getChain())
        {
            case ALGORAND:
                return generateAlgorandAddress(seedPhrase);
            
            case BINANCESMARTCHAIN:
                return generateBSCAddress(seedPhrase);
            
            case BITCOIN:
                return generateBitcoinAddress(seedPhrase);
            
            case ETHEREUM:
                return generateEthereumAddress(seedPhrase);
                
            case FANTOM:
                return generateFantomAddress(seedPhrase);
            
            case POLYGON:
                return generatePolygonAddress(seedPhrase);
                
            case SOLANA:
                return generateSolanaAddress(seedPhrase);
                
            case TRON:
                return generateTronAddress(seedPhrase);
                
            default:
                throw new UnsupportedOperationException("Specified blockchain not supported yet.");
        }
    }
    
    public static void main(String[] args)
    {
        String algoAddress = generateAlgorandAddress(SeedWordsRepository.toPhrase(SeedWordsRepository.generateSeedWords(12)));
        String btcAddress = generateBitcoinAddress(SeedWordsRepository.toPhrase(SeedWordsRepository.generateSeedWords(12)));
        String ethAddress = generateEthereumAddress(SeedWordsRepository.toPhrase(SeedWordsRepository.generateSeedWords(12)));
        String solAddress = generateSolanaAddress(SeedWordsRepository.toPhrase(SeedWordsRepository.generateSeedWords(12)));
        String trxAddress = generateTronAddress(SeedWordsRepository.toPhrase(SeedWordsRepository.generateSeedWords(12)));
        String iotxAddress = "iotx93jIs83uIsjSYH7382938r47r88H792XHA8sD8Fjiq9PZMNbH";
        
        System.out.printf("ALGO address: %s%n", isValidAddress(algoAddress, Blockchain.Chain.ALGORAND) ? algoAddress : "Invalid address");
        System.out.printf("BTC address: %s%n", isValidAddress(btcAddress, Blockchain.Chain.BITCOIN) ? btcAddress : "Invalid address");
        System.out.printf("ETH address: %s%n", isValidAddress(ethAddress, Blockchain.Chain.ETHEREUM) ? ethAddress : "Invalid address");
        System.out.printf("SOL address: %s%n", isValidAddress(solAddress, Blockchain.Chain.SOLANA) ? solAddress : "Invalid address");
        System.out.printf("TRX address: %s%n", isValidAddress(trxAddress, Blockchain.Chain.TRON) ? trxAddress : "Invalid address");
        System.out.printf("TRX address: %s%n", isValidAddress(iotxAddress, Blockchain.Chain.IOTEX) ? iotxAddress : "Invalid address");
    }
    
    public static String generateAlgorandAddress(String seedPhrase)
    {
        byte[] hashBytes = Hash.SHA_224(seedPhrase);
        StringBuilder address = new StringBuilder();
        for(int i = 0; i < hashBytes.length; i++)
        {
            String temp = Integer.toString(Byte.toUnsignedInt(hashBytes[i]), 36);
            if(temp.length() < 2)
            {
                temp = "1" + temp;
//                if(Character.isDigit(temp.charAt(0)) && )
            }
                
            address.append(temp);
        }
        
        address.append(address.charAt(0)).append(address.charAt(1));
        
        return address.toString().toUpperCase();
    }
    
    public static String generateBSCAddress(String seedPhrase)
    {
        return generateEthereumAddress(seedPhrase);
    }
    
    public static String generateBitcoinAddress(String seedPhrase)
    {
        byte[] byteArr = Base32.encode(seedPhrase.getBytes());
        byte[] hashedBytes = Hash.SHA_256(Base32.toBase32String(byteArr));
        
        RIPEMD160Digest digest = new RIPEMD160Digest();
        digest.update(hashedBytes, 0, hashedBytes.length);
        
        byte[] doubleHashedBytes = new byte[digest.getDigestSize()];
        digest.doFinal(doubleHashedBytes, 0);
        
        StringBuilder address = new StringBuilder();
        
        for(byte bit : doubleHashedBytes)
        {
            String temp = Integer.toHexString(0xFF & bit);
            if(temp.length() < 2)
                temp = "0" + temp;
            address.append(temp);
        }
        
        return new SecureRandom().nextInt(2) == 0 ? "bc" + "1" + "a" + address.substring(2) : "bc" + "1" + "q" + address.substring(2);
    }
    
    public static String generateEthereumAddress(String seedPhrase)
    {
        byte[] hashBytes = skipTill12(Hash.SHA_256(seedPhrase));
        StringBuilder address = new StringBuilder();
        
        for(byte bit : hashBytes)
        {
            String temp = Integer.toHexString(0xFF & bit);
            if(temp.length() < 2)
                temp = "0" + temp;
            address.append(temp);
        }
        
        return "0x" + address.toString();
    }
    
    public static String generateFantomAddress(String seedPhrase)
    {
        return generateEthereumAddress(seedPhrase);
    }
    
    public static String generatePolygonAddress(String seedPhrase)
    {
        return generateEthereumAddress(seedPhrase);
    }
    
    public static String generateSolanaAddress(String seedPhrase)
    {
        byte[] hashedBytes = Hash.SHA_256(seedPhrase);
        String address = Base58.encode(hashedBytes);
        
        while(!Character.isUpperCase(address.charAt(0)) || !Character.isDigit(address.charAt(1)))
        {
            hashedBytes = Hash.SHA_256(address);
            address = Base58.encode(hashedBytes);
        }
        
        return address;
    }
    
    public static String generateTronAddress(String seedPhrase)
    {
        byte[] hashedBytes = Hash.SHA_256(seedPhrase);
        byte[] addressBytes = new byte[25];
        addressBytes[0] = 0x41;
        
        System.arraycopy(hashedBytes, 8, addressBytes, 1, addressBytes.length - 1);
        String address = Base58.encode(addressBytes);
        
        return address;
    }
    
    public static byte[] skipTill12(byte[] byteArr)
    {
        return Arrays.copyOfRange(byteArr, 12, byteArr.length);
    }
}