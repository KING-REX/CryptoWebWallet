package repository;

import entity.Token;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author King Shadow
 */
public class TokenRepository 
{
    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("CryptoWebWalletPU");
    public static final EntityManager ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();
    
    public static List<Token> getAllNativeTokens()
    {
        List<Token> allNativeTokens = new ArrayList<>();
        BlockchainRepository.getAllBlockchains().forEach((blockchain) -> {allNativeTokens.add(blockchain.getNativeToken());});
        return allNativeTokens;
    }

    public static void updateToken(Token token)
    {
        ENTITY_MANAGER.getTransaction().begin();
        ENTITY_MANAGER.merge(token);
        ENTITY_MANAGER.getTransaction().commit();
    }

    public static double getTokenBalanceInUSD(Token token, double tokenBalance)
    {
        return token.getValueInUSD() * tokenBalance;
    }

    public static Token getTokenById(Long id)
    {
        TypedQuery<Token> tokenQuery = ENTITY_MANAGER.createNamedQuery("Token.findTokenById", Token.class);
        tokenQuery.setParameter("id", id);
        
        return tokenQuery.getSingleResult();
    }
}