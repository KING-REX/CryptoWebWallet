package repository;

import entity.MultiChainWallet;
import entity.SingleChainWallet;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.apache.catalina.tribes.util.Arrays;
import resources.Hash;

/**
 *
 * @author King Shadow
 */
public class UserRepository 
{
    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("CryptoWebWalletPU");
    public static final EntityManager ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();
    
    public static boolean addUser(User user)
    {
        try
        {
            ENTITY_MANAGER.getTransaction().begin();
            ENTITY_MANAGER.persist(user);
            ENTITY_MANAGER.getTransaction().commit();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public static List<User> getAllUsers()
    {
        TypedQuery<User> query = ENTITY_MANAGER.createQuery("SELECT u FROM User u", User.class);
        
        return query.getResultList();
    }
    
    public static User verifyUser(String name, String password)
    {
        for(User user : getAllUsers())
        {
            String hashedPassword = Hash.MD5_String(password);
            if(name.equals(user.getName()) && hashedPassword.equals(user.getHashedPassword()))
                return user;
        }
        
        return null;
    }

    public static void updateUserInfo(User user)
    {
        ENTITY_MANAGER.getTransaction().begin();
        ENTITY_MANAGER.merge(user);
        ENTITY_MANAGER.getTransaction().commit();
    }

    public static boolean walletExists(User user, String walletName)
    {
        boolean mcWalletExists = user.getMultiChainWallets().stream().anyMatch((multichainWallet) -> (multichainWallet.getName().equals(walletName)));
        boolean scWalletExists = user.getSingleChainWallets().stream().anyMatch((singleChainWallet) -> (singleChainWallet.getName().equals(walletName)));
        
        for(MultiChainWallet mcWallet : user.getMultiChainWallets())
            if(mcWallet.getName().equals(walletName))
                mcWalletExists = true;
        
        for(SingleChainWallet scWallet : user.getSingleChainWallets())
            if(scWallet.getName().equals(walletName))
                scWalletExists = true;
        
        return mcWalletExists || scWalletExists;
    }

    public static boolean userExists(String username)
    {
        return getAllUsers().stream().anyMatch((user) -> (user.getName().equals(username)));
    }

    public static List<SingleChainWallet> getUserSingleChainWallets(User user)
    {        
        user = ENTITY_MANAGER.find(User.class, user.getId());
        List<SingleChainWallet> pureSingleChainWallets = new ArrayList<>();
        
        user.getSingleChainWallets().size();                                    //To prevent ValidationException caused when an entity with an uninstantiated LAZY relationship is traversed after serialization.

        for(SingleChainWallet singleChainWallet : user.getSingleChainWallets())
        {
            if(!fromUserMultiWallet(user, singleChainWallet))
                pureSingleChainWallets.add(singleChainWallet);
        }
        
        return pureSingleChainWallets;
    }
    
    public static boolean fromUserMultiWallet(User user, SingleChainWallet singleChainWallet)
    {
        if(user.getMultiChainWallets().isEmpty())
            return false;
        
        for(MultiChainWallet multiChainWallet : user.getMultiChainWallets())
            if(singleChainWallet.getName().equals(multiChainWallet.getName()) && singleChainWallet.getHashedPassword().equals(multiChainWallet.getHashedPassword()))
                return true;
        return false;
    }
    
    public static void main(String[] args)
    {
        User user = ENTITY_MANAGER.find(User.class, 1L);
        
//        System.out.println("User exists: " + userExists(user.getName()));
//        System.out.println("User's multichain wallets: " + Arrays.toString(user.getMultiChainWallets().toArray()));
//        System.out.println("User's singlechain wallets: " + Arrays.toString(user.getSingleChainWallets().toArray()));
//        System.out.println("User's pure singlechain wallets: " + Arrays.toString(user.getPureSingleChainWallets().toArray()));

        for(MultiChainWallet wallet : user.getMultiChainWallets())
        {
            System.out.println("Wallet: " + wallet);
        }
        System.out.println("Wallet exists: " + walletExists(user, "Wallet1"));
    }
}