package entity;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import repository.TransactionRepository;

/**
 *
 * @author King Shadow
 */
public class TxHash 
{
    public String txHash;
    
    public static String generateTransactionId(long id)
    {
        System.out.println("Id passed to generateTransactionId is: " + id);
        String txHash = generateNewHash(new BigInteger(String.valueOf(id)));
        
        while(TransactionRepository.hashExists(txHash))                     //Should never return true but in the 0.01% chance that it returns true... 
        {                                                                   //concatenate all the digits in the newly derived hash and hash again
            String newId = "";
            
            for(char character : txHash.toCharArray())
            {
                if(Character.isDigit(character))
                    newId = newId.concat(Character.toString(character));
            }
//            System.out.println("NewId: " + newId);
            BigInteger digit1 = new BigInteger(newId);
//            System.out.println("BigInteger: " + digit1);
//            System.out.println("BigInteger byte array: " + Arrays.toString(digit1.toByteArray()));
            txHash = generateNewHash(digit1);
        }
        
        return txHash;
    }
    
    private static String generateNewHash(BigInteger id)
    {
        String hash = "";
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.update(id.toByteArray());
            byte[] hashedBytes = digest.digest();
            for(byte bit : hashedBytes)
            {
                hash = hash.concat(Integer.toHexString(0xff & bit));
            }
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.err.println("An error occurred: " + ex.getMessage());
        }
        
        return hash;
    }
    
/*  
    public static void main(String[] args)
    {
        String hash = "";
        String message = "opera eyebrow cheap radio affair couple mirror nut urban dog gain bread";
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-512/256");
            digest.update(message.getBytes());
            
            long counter = 0;
            
            while(counter < Long.parseLong("65536"))
            {
                digest.update(hash.getBytes());
                byte[] hashedBytes = digest.digest();
                hash = "";
                for(byte bit : hashedBytes)
                {
                    hash = hash.concat(Integer.toHexString(0xff & bit));
                }
                
                System.out.println(counter + ": " + hash);
                
                if(hash.equals("8859c10797234e972947026ae4602378d3108a5170dbace038349381729c90cf"))
                    break;
                counter++;
            }
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.err.println("An error occurred: " + ex.getMessage());
        }
        
        System.out.println("Hash: " + hash);
    }
*/
}