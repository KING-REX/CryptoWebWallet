package resources;

import entity.Address;
import entity.Token;
import java.io.File;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import repository.AddressRepository;
import repository.TokenRepository;

/**
 *
 * @author King Shadow
 */
public class TokenDemo 
{
    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("CryptoWebWalletPU");
    public static final EntityManager ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();
    
    public static void main(String[] args)
    {
//        for(Token token : TokenRepository.getAllNativeTokens())
//        {
//            String imagePath = "images/" + token.getParentChain().getChain().name() + ".png";
//            System.out.println("Image path: " + imagePath);
//            System.out.println("Image exists: " + new File("web/" + imagePath).exists());
//            token.setImagePath(imagePath);
//            System.out.println();
//        }
        
        Address address = ENTITY_MANAGER.find(Address.class, 2L);
        
        address.getTokenBalances().put(ENTITY_MANAGER.find(Token.class, 2L), 27.735);
        AddressRepository.updateAddress(address);
    }
}