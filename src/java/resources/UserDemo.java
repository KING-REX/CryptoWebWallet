package resources;

import entity.*;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import repository.TokenRepository;
import repository.UserRepository;

/**
 *
 * @author King Shadow
 */
public class UserDemo 
{
    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("CryptoWebWalletPU");
    public static final EntityManager ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();
    
    public static void main(String[] args)
    {
//        User user = new User("JohnDoe", "ISeeYouComrade");
//        Blockchain algorand = new Blockchain();
//        algorand.setChain(Blockchain.Chain.ALGORAND);
//        Token algo = new Token(algorand, "ALGO", "src/java/resources/images/ALGORAND.png", 2.012);
//        algorand.setNativeToken(algo);
//        SingleChainWallet wallet = new SingleChainWallet("Sekiro", "secret", ENTITY_MANAGER.find(Blockchain.class, 1L), false, user);
//        user.getSingleChainWallets().add(wallet);

        User user = ENTITY_MANAGER.find(User.class, 3L);
        MultiChainWallet wallet2 = new MultiChainWallet("Niggie", "ISeeYouComrade", user);
        user.getMultiChainWallets().add(wallet2);
        UserRepository.updateUserInfo(user);
        
//        for(SingleChainWallet wallet : user.getMultiChainWallets().get(0).getWallets())
//        {
//            System.out.println("Wallet: " + wallet.getAddress());
//            for(Token token : wallet.getAddress().getTokenBalances().keySet())
//            {
//                System.out.println("Token: " + token.getSymbol());
//                System.out.println("Balance for " + token.getParentChain().getChain().getName() + ": " + wallet.getAddress().getTokenBalances().get(ENTITY_MANAGER.find(Token.class, token.getId())));
//            }
//            System.out.println();
//        }
//        SingleChainWallet wallet1 = user.getMultiChainWallets().get(0).getWallets().get(1);
//        Double doubles = wallet1.getAddress().getTokenBalances().put(ENTITY_MANAGER.find(Token.class, wallet1.getAddress().getParentChain().getNativeToken().getId()), 1502.00);
//        System.out.println(wallet1.getAddress().getTokenBalances().get(ENTITY_MANAGER.find(Token.class, wallet1.getAddress().getParentChain().getNativeToken().getId())));
//        System.out.println("Double: " + doubles);

        
//        User user = new User("123456");
        

//        Blockchain bsc = ENTITY_MANAGER.find(Blockchain.class, 5L);
//        Token bscToken = ENTITY_MANAGER.find(Token.class, 5L);
        
//        MultiChainWallet wallet = new MultiChainWallet("Comrade", "HighestComrade", user);
//        user.getMultiChainWallets().add(wallet);
        
//        SingleChainWallet wallet = new SingleChainWallet("Free Wallet", "IKnowYouNot", bsc, false, user);
//        user.getSingleChainWallets().add(wallet);
        
//        MultiChainWallet multiChainWallet = new MultiChainWallet("Okayyy", "abc123",user);
//        user.getMultiChainWallets().add(multiChainWallet);

//        SingleChainWallet W51 = ENTITY_MANAGER.find(SingleChainWallet.class, 3L);
//        SingleChainWallet W205 = ENTITY_MANAGER.find(SingleChainWallet.class, 14L);
//        W51.sendTokens(bscToken, 117.09, W205, "ISeeYouComrade");

//        Blockchain algorand = ENTITY_MANAGER.find(Blockchain.class, 2L);
//        Token algo = ENTITY_MANAGER.find(Token.class, 2L);
//        System.out.println(user.getMultiChainWallets().get(1).getAddress(algorand).getHashedPrivateKey());
//        System.out.println(user.getMultiChainWallets().get(1).getAddress(algorand).getPrivateKey());
//        for(Token token : user.getMultiChainWallets().get(1).getAddress(algorand).getTokenBalances().keySet())
//            System.out.println("Token: " + token);
        
        
//        ENTITY_MANAGER.getTransaction().begin();
//        ENTITY_MANAGER.persist(user);
//        ENTITY_MANAGER.getTransaction().commit();
    }
}