package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author King Shadow
 */
@Entity
@Table(name="Address_TokenBalances")
public class AddressTokenBalance implements Serializable 
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private Address address;
    
    @ManyToOne
    private Token token;
    
    @Column(name = "TokenBalances", nullable = false, columnDefinition = "Double DEFAULT 0.00")
    private double balance;

    public AddressTokenBalance()
    {
    }

    public AddressTokenBalance(Address address, Token token, double balance)
    {
        this.address = address;
        this.token = token;
        this.balance = balance;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public Token getToken()
    {
        return token;
    }

    public void setToken(Token token)
    {
        this.token = token;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if(!(object instanceof AddressTokenBalance))
        {
            return false;
        }
        AddressTokenBalance other = (AddressTokenBalance) object;
        if((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entity.AddressTokenBalance[ id=" + id + " ]";
    }
    
}
