package entity;

import java.io.IOException;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author King Shadow
 */
public class CryptoSeedWords
{
    private static final List<String> SEED_WORDS_LIST = new ArrayList<>();
    private static final SecureRandom RANDOM = new SecureRandom();
    
    static
    {
        populateWordList("src/cryptowallet/seedwords.txt");
    }
    
    public static List<String> populateWordList(String filePath)
    {
        try
        {
            Scanner fileReader = new Scanner(Paths.get(filePath));
            while(fileReader.hasNextLine())
            {
                SEED_WORDS_LIST.add(fileReader.nextLine());
            }
        }
        catch(IOException e)
        {
            throw new IllegalAccessError("Internal Server Error: Couldn't retrieve seed words. Try again later.");
        }
        
        
        return SEED_WORDS_LIST;
    }
    
    public static String[] generateSeedWords(int phraseLength)
    {
        if(phraseLength != 12 && phraseLength != 24)
            throw new IllegalArgumentException("Seed phrase must be 12 or 24 words.");
        
        String[] generatedSeedPhrase = new String[phraseLength];
        
        for(int i = 0; i < phraseLength; i++)
        {
            String newPhrase = SEED_WORDS_LIST.get(RANDOM.nextInt(SEED_WORDS_LIST.size()));
            if(Arrays.asList(generatedSeedPhrase).contains(newPhrase))
            {
                i--;
                continue;
            }
            generatedSeedPhrase[i] = newPhrase;
            System.out.println(Arrays.toString(generatedSeedPhrase));
        }
        
        return generatedSeedPhrase;
        
        // DON'T FORGET TO ADD THE FUNCTION THAT WILL RETRIEVE ALL THE EXISTING SEED PHRASES FROM THE DATABASE AND COMPARE IT WITH THE NEWLY GENERATED SEED PHRASE, TO MAKE SURE THAT NO TWO ADDRESSES HAVE THE SAME SET OF SEED PHRASES
    }
    
    public static String generatePrivateKey()
    {
        String privateKey = "";
        for(int i = 0; i < 42; i++)
        {
//            char nextChar = RANDOM.nexte
        }
        
        return null;
    }
    
    public static void main(String[] args)
    {
        String[] seedPhrase = generateSeedWords(12);
        System.out.println("Seed phrase: " + Arrays.toString(seedPhrase));
    }
}