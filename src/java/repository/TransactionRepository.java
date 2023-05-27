package repository;

import entity.Address;
import entity.Transaction;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author King Shadow
 */
public class TransactionRepository 
{
    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("CryptoWebWalletPU");
    public static final EntityManager ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();
    
    public static boolean hashExists(String hash)
    {
        TypedQuery<Transaction> query = ENTITY_MANAGER.createQuery("SELECT t FROM Transaction t", Transaction.class);
        
        return query.getResultList().stream().anyMatch((transaction) -> (transaction.getTxHash().equals(hash)));
    }
    
    public static List<Transaction> getAllTransactions()
    {
        TypedQuery<Transaction> query = ENTITY_MANAGER.createQuery("SELECT t FROM Transaction t", Transaction.class);
        
        return query.getResultList();
    }
    
    public static List<Transaction> getAllTransactionsByAddress(Address address)
    {
        List<Transaction> filteredTransactions = new ArrayList<>();
        
        for(Transaction transaction : getAllTransactions())
        {
            if((transaction.getFrom().equals(address) || transaction.getTo().equals(address)) && transaction.getBlockChain().equals(address.getParentChain()))
                filteredTransactions.add(transaction);
        }
        System.out.println("Filtered transactions: " + filteredTransactions);
        return filteredTransactions;
    }
    
    public static List<Transaction> getTransactionsByDate(Date date)
    {
        TypedQuery<Transaction> query = ENTITY_MANAGER.createQuery("SELECT t FROM Transaction t", Transaction.class);
        
        List<Transaction> filteredByDate = new ArrayList<>();
        
        query.getResultList().forEach((transaction) -> {
            if(transaction.getDate().equals(date))
                filteredByDate.add(transaction);
        });
        
        return filteredByDate;
    }
    
    public static Transaction getTransactionByHash(String hash)
    {
        TypedQuery<Transaction> query = ENTITY_MANAGER.createQuery("SELECT t FROM Transaction t", Transaction.class);
        
        for(Transaction transaction : query.getResultList())
            if(transaction.getTxHash().equals(hash))
                return transaction;
        
        return null;
    }

    public static void addTransactionToBlockChain(Transaction transaction)
    {
        ENTITY_MANAGER.getTransaction().begin();
        ENTITY_MANAGER.persist(transaction);
        ENTITY_MANAGER.getTransaction().commit();
        System.out.println("Transaction successfully persisted!!");
    }
}