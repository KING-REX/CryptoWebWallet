package repository;

import entity.Address;
import entity.SingleChainWallet;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author King Shadow
 */
public class SeedWordsRepository 
{
    private static final SecureRandom random = new SecureRandom();
    
    public static void main(String[] args)
    {
//        String[] seedWords = generateSeedWords(12);
        String[] seedWords = {"law", "arm", "laugh", "slush", "auto", "balance", "student", "burden", "stay", "inform", "bridge", "spray"};
        String privateKey = generatePrivateKey(toPhrase(seedWords));
        
        System.out.println("Seed words: " + Arrays.toString(seedWords));
        System.out.println("Seed phrase: |" + toPhrase(seedWords) + "|");
        System.out.println("Private key: " + privateKey);
    }
    
    public static String[] generateSeedWords(int length)
    {
        if(length != 12 && length != 24)
            throw new IllegalArgumentException("Length should be 12 or 24 words");
        
        List<String> allWords = new ArrayList<>();
        String[] seedWords = new String[length];
        
        try
        {
            File file = new File("C:/Users/USER/Documents/NetBeansProjects/CryptoWebWallet/src/java/resources/seedwords.txt");
//            File file = new File("resources/seedwords.txt");
            Scanner reader;
            reader = new Scanner(file);
            while(reader.hasNextLine())
            {
                allWords.add(reader.nextLine());
            }
        }
        catch(FileNotFoundException ex)
        {
            throw new IllegalArgumentException("File exists: " + new File("images/").exists() + "\nFile not found!\nCurrent file path: " + new File("images/").getAbsolutePath());
        }
            
        
        
        for(int i = 0; i < length; i++)
        {
            try
            {
                int randomWord = random.nextInt(allWords.size());
                seedWords[i] = allWords.get(randomWord);
            }
            catch(IllegalArgumentException e)
            {
                System.err.println("An error occurred: " + e.getMessage() + "\nCurrent file path: " + new File("").getAbsolutePath());
            }
        }
        
        return seedWords;
    }
    
    public static String generatePrivateKey(SingleChainWallet wallet)
    {
        return generatePrivateKey(wallet.getAddress());
    }
    
    public static String generatePrivateKey(Address address)
    {
        return generatePrivateKey(address.getSeedWords());
    }
    
    public static String generatePrivateKey(String[] seedWords)
    {
        return generatePrivateKey(toPhrase(seedWords));
    }

    public static String generatePrivateKey(String seedPhrase)
    {
        StringBuilder hash = new StringBuilder();
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(seedPhrase.getBytes());
            byte[] bytesHash = digest.digest();
            for(byte byteHash : bytesHash)
                hash.append(Integer.toHexString(0xFF & byteHash));
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.err.println("An error occurred: " + ex.getMessage());
        }
        
        return hash.toString();
    }

    public static String toPhrase(String[] seedWords)
    {
        if(seedWords == null)
            throw new IllegalArgumentException("Seed words array is empty.");
        
        StringBuilder seedPhrase = new StringBuilder();
        
        for(int i = 0; i < seedWords.length; i++)
        {
            if(i == seedWords.length - 1)
                seedPhrase.append(seedWords[i]);
            else
                seedPhrase.append(seedWords[i]).append(" ");
        }
        
        return seedPhrase.toString();
    }
}