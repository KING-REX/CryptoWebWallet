package entity;

import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.*;
import repository.TransactionRepository;

/**
 *
 * @author King Shadow
 */
@Entity
@Table(name = "Transactions")
public class Transaction implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "TransactionHash", nullable = false, unique = true)
    private String txHash;
    
    @ManyToOne
    @JoinColumn(name = "SourceAddress", nullable = false, referencedColumnName = "ID")
    private Address from;
    
    @ManyToOne
    @JoinColumn(name = "DestinationAddress", nullable = false, referencedColumnName = "ID")
    private Address to;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TransactionDate", nullable = false)
    private Date date;
    
    @OneToOne
    @JoinColumn(name = "TokenTransferred", nullable = false)
    private Token tokenTransferred;
    
    @ManyToOne
    @JoinColumn(name = "BlockchainUtilized", nullable = false, referencedColumnName = "ID")
    private Blockchain blockChain;
    
    @Column(name = "AmountTransferred", nullable = false)
    private double amountTransferred;
    
    public Transaction()
    {
    }
    
    public Transaction(Address from, Address to, Token tokenTransferred, double amountTransferred)
    {
        this.from = from;
        this.to = to;
        this.tokenTransferred = tokenTransferred;
        this.blockChain = tokenTransferred.getParentChain();
        this.amountTransferred = amountTransferred;
        System.out.println("This transaction's id is: " + this.id);
        this.txHash = TxHash.generateTransactionId(this.id);
        this.date = Timestamp.valueOf(LocalDateTime.now());
        persistNewTransaction();
    }
    
    public static void main(String[] args)
    {
        System.out.println("Current dateTime: " + Timestamp.valueOf(LocalDateTime.now()));
        LocalDateTime.now();
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Address getFrom()
    {
        return from;
    }

    public void setFrom(Address from)
    {
        this.from = from;
    }

    public Address getTo()
    {
        return to;
    }

    public void setTo(Address to)
    {
        this.to = to;
    }

    public String getTxHash()
    {
        return txHash;
    }

    public void setTxHash(String txHash)
    {
        this.txHash = txHash;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Token getTokenTransferred()
    {
        return tokenTransferred;
    }

    public void setTokenTransferred(Token tokenTransferred)
    {
        this.tokenTransferred = tokenTransferred;
    }

    public Blockchain getBlockChain()
    {
        return blockChain;
    }

    public void setBlockChain(Blockchain blockChain)
    {
        this.blockChain = blockChain;
    }

    public double getAmountTransferred()
    {
        return amountTransferred;
    }

    public void setAmountTransferred(double amountTransferred)
    {
        this.amountTransferred = amountTransferred;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return this == null;
        
        if(!(obj instanceof Transaction))
            return false;
        
        Transaction otherTransaction = (Transaction) obj;
        return this.txHash.equals(otherTransaction.txHash) && this.id == otherTransaction.id;
    }

    private void persistNewTransaction()
    {
        TransactionRepository.addTransactionToBlockChain(this);
    }

    @Override
    public String toString()
    {
        return "Transaction{" + "id=" + id + ", txHash=" + txHash + ", from=" + from + ", to=" + to + ", date=" + date + ", tokenTransferred=" + tokenTransferred + ", blockChain=" + blockChain + ", amountTransferred=" + amountTransferred + '}';
    }
}
