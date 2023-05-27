package resources;

import entity.Blockchain;
import entity.Token;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author King Shadow
 */
public class BlockchainDemo 
{
    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("CryptoWebWalletPU");
    public static final EntityManager ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();
    
    public static void main(String[] args)
    {    
        Scanner scanner = new Scanner(System.in);
        
        for(Blockchain.Chain chain : Blockchain.Chain.values())
        {
//            if(chain == Blockchain.Chain.ALGORAND)
//                continue;
            Blockchain blockchain = new Blockchain();
            Token nativeToken = new Token();
            
            blockchain.setChain(chain);
            
            nativeToken.setParentChain(blockchain);
            System.out.print("Enter " + blockchain.getChain().getName() + "'s native token's symbol: ");
            nativeToken.setSymbol(scanner.nextLine());
            nativeToken.setImagePath("images/" + blockchain.getChain().name() + ".png");
            System.out.print("Enter " + blockchain.getChain().getName() + "'s native token's value in USD: ");
            nativeToken.setValueInUSD(Double.parseDouble(scanner.nextLine()));
            
            blockchain.setNativeToken(nativeToken);
            
            ENTITY_MANAGER.getTransaction().begin();
            ENTITY_MANAGER.persist(blockchain);
            ENTITY_MANAGER.getTransaction().commit();
            
            System.out.println(blockchain.getChain().getName() + " successfully persisted to the database.");
            System.out.println();
        }
    }
}