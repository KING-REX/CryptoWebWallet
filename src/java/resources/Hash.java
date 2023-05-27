package resources;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author King Shadow
 */
public class Hash 
{
    public static byte[] SHA_1(String message)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(message.getBytes());
            return digest.digest();
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.err.println("An error occurred: " + ex);
        }
        
        return null;
    }
    
    public static String SHA_1_String(String message)
    {
        StringBuilder result = new StringBuilder();
        
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(message.getBytes());
            byte[] hashedBytes = digest.digest();
            for(byte byt : hashedBytes)
                result.append(Integer.toHexString(0xFF & byt));
            
            return result.toString();
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.err.println("An error occurred: " + ex);
        }
        
        return null;
    }
    
    public static byte[] SHA_224(String message)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-224");
            digest.update(message.getBytes());
            return digest.digest();
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.err.println("An error occurred: " + ex);
        }
        
        return null;
    }
    
    public static String SHA_224_String(String message)
    {
        StringBuilder result = new StringBuilder();
        
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-224");
            digest.update(message.getBytes());
            byte[] hashedBytes = digest.digest();
            for(byte byt : hashedBytes)
                result.append(Integer.toHexString(0xFF & byt));
            
            return result.toString();
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.err.println("An error occurred: " + ex);
        }
        
        return null;
    }
    
    public static byte[] SHA_256(String message)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(message.getBytes());
            return digest.digest();
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.err.println("An error occurred: " + ex);
        }
        
        return null;
    }
    
    public static String SHA_256_String(String message)
    {
        StringBuilder result = new StringBuilder();
        
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(message.getBytes());
            byte[] hashedBytes = digest.digest();
            for(byte byt : hashedBytes)
                result.append(Integer.toHexString(0xFF & byt));
            
            return result.toString();
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.err.println("An error occurred: " + ex);
        }
        
        return null;
    }
    
    public static byte[] SHA_384(String message)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-384");
            digest.update(message.getBytes());
            return digest.digest();
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.err.println("An error occurred: " + ex);
        }
        
        return null;
    }
    
    public static String SHA_384_String(String message)
    {
        StringBuilder result = new StringBuilder();
        
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-384");
            digest.update(message.getBytes());
            byte[] hashedBytes = digest.digest();
            for(byte byt : hashedBytes)
                result.append(Integer.toHexString(0xFF & byt));
            
            return result.toString();
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.err.println("An error occurred: " + ex);
        }
        
        return null;
    }
    
    public static byte[] SHA_512(String message)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.update(message.getBytes());
            return digest.digest();
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.err.println("An error occurred: " + ex);
        }
        
        return null;
    }
    
    public static String SHA_512_String(String message)
    {
        StringBuilder result = new StringBuilder();
        
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.update(message.getBytes());
            byte[] hashedBytes = digest.digest();
            for(byte byt : hashedBytes)
                result.append(Integer.toHexString(0xFF & byt));
            
            return result.toString();
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.err.println("An error occurred: " + ex);
        }
        
        return null;
    }
    
    public static byte[] SHA_512_224(String message)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-512/224");
            digest.update(message.getBytes());
            return digest.digest();
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.err.println("An error occurred: " + ex);
        }
        
        return null;
    }
    
    public static String SHA_512_224_String(String message)
    {
        StringBuilder result = new StringBuilder();
        
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-512/224");
            digest.update(message.getBytes());
            byte[] hashedBytes = digest.digest();
            for(byte byt : hashedBytes)
                result.append(Integer.toHexString(0xFF & byt));
            
            return result.toString();
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.err.println("An error occurred: " + ex);
        }
        
        return null;
    }
    
    public static byte[] SHA_512_256(String message)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-512/256");
            digest.update(message.getBytes());
            return digest.digest();
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.err.println("An error occurred: " + ex);
        }
        
        return null;
    }
    
    public static String SHA_512_256_String(String message)
    {
        StringBuilder result = new StringBuilder();
        
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-512/256");
            digest.update(message.getBytes());
            byte[] hashedBytes = digest.digest();
            for(byte byt : hashedBytes)
                result.append(Integer.toHexString(0xFF & byt));
            
            return result.toString();
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.err.println("An error occurred: " + ex);
        }
        
        return null;
    }
    
    public static byte[] MD2(String message)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("MD2");
            digest.update(message.getBytes());
            return digest.digest();
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.err.println("An error occurred: " + ex);
        }
        
        return null;
    }
    
    public static String MD2_String(String message)
    {
        StringBuilder result = new StringBuilder();
        
        try
        {
            MessageDigest digest = MessageDigest.getInstance("MD2");
            digest.update(message.getBytes());
            byte[] hashedBytes = digest.digest();
            for(byte byt : hashedBytes)
                result.append(Integer.toHexString(0xFF & byt));
            
            return result.toString();
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.err.println("An error occurred: " + ex);
        }
        
        return null;
    }
    
    public static byte[] MD5(String message)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(message.getBytes());
            return digest.digest();
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.err.println("An error occurred: " + ex);
        }
        
        return null;
    }
    
    public static String MD5_String(String message)
    {
        StringBuilder result = new StringBuilder();
        
        try
        {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(message.getBytes());
            byte[] hashedBytes = digest.digest();
            for(byte byt : hashedBytes)
                result.append(Integer.toHexString(0xFF & byt));
            
            return result.toString();
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.err.println("An error occurred: " + ex);
        }
        
        return null;
    }
}