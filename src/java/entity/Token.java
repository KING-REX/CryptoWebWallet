package entity;

import java.io.File;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import repository.TokenRepository;

/**
 *
 * @author King Shadow
 */

@Entity
@Table(name = "Tokens")
@NamedQueries({
    @NamedQuery(name = "Token.findTokenById", query = "SELECT t FROM Token t WHERE t.id = :id")
})
public class Token implements Serializable, Comparable<Token>
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ParentChainID", referencedColumnName = "id")
    private Blockchain parentChain;
    
    @Column(name = "Symbol", nullable = false, unique = true)
    private String symbol;
    
    @Column(name = "ValueInUSD", nullable = false)
    private double valueInUSD;
    
    @Column(name = "Image", nullable = false, unique = true)
    private String imagePath;

    public Token()
    {
    }

    public Token(Blockchain parentChain, String symbol, String imagePath, double valueInUSD)
    {
        this.parentChain = parentChain;
        this.symbol = symbol;
        if(!new File("web/" + imagePath).exists())
            throw new IllegalArgumentException("Image doesn't exist");
        this.imagePath = imagePath;
        this.valueInUSD = valueInUSD;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Blockchain getParentChain()
    {
        return parentChain;
    }

    public void setParentChain(Blockchain parentChain)
    {
        this.parentChain = parentChain;
        
//        TokenRepository.updateToken(this);
    }

    public String getSymbol()
    {
        return symbol;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
        
//        TokenRepository.updateToken(this);
    }

    public double getValueInUSD()
    {
        return valueInUSD;
    }

    public void setValueInUSD(double valueInUSD)
    {
        this.valueInUSD = valueInUSD;
        
//        TokenRepository.updateToken(this);
    }

    public String getImagePath()
    {
        return imagePath;
    }

    public void setImagePath(String imagePath)
    {
        if(!new File("web/" + imagePath).exists())
            throw new IllegalArgumentException("Image doesn't exist");
        this.imagePath = imagePath;
        
//        TokenRepository.updateToken(this);
//        System.out.println("Image Path of " + this.getSymbol() + " successfully persisted!!");
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return this == null;
        
        if(!(obj instanceof Token))
            return false;
        
        Token otherToken = (Token) obj;
        return this.id == otherToken.id;
    }

    @Override
    public int compareTo(Token o)
    {
        if(o == null)
            if(this == null)
                return 0;
            else
                throw new NullPointerException("One of the tokens is null!");
        
        if(this.valueInUSD == o.valueInUSD)
            return 0;
        
        return this.valueInUSD > o.valueInUSD ? 1 : -1;
    }

    @Override
    public String toString()
    {
        return "Token{" + "id=" + id + ", symbol=" + symbol + ", valueInUSD=" + valueInUSD + ", imagePath=" + imagePath + '}';
    }
}