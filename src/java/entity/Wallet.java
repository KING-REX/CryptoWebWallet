package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import resources.Hash;

/**
 *
 * @author King Shadow
 */

@MappedSuperclass
public class Wallet implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "Name", nullable = false)
    private String name;
    
    @Column(name = "Password", nullable = false)
    private String hashedPassword;
    
    @Transient
    private String password;
    
    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "ID", nullable = false)
    private User owner;

    public Wallet()
    {
    }
    
    public Wallet(String name, String password, User owner)
    {
        this.name = name;
        this.password = password;
        this.hashedPassword = Hash.MD5_String(password);
        this.owner = owner;
    }

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getHashedPassword()
    {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword)
    {
        this.hashedPassword = hashedPassword;
    }

    public User getOwner()
    {
        return owner;
    }

    public void setOwner(User owner)
    {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return this == null;
        
        if(!(obj instanceof Wallet))
            return false;
        
        Wallet otherWallet = (Wallet) obj;
        return this.id == otherWallet.id;
    }

//    @Override
//    public int hashCode()
//    {
//        int hash = 3;
//        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
//        hash = 71 * hash + Objects.hashCode(this.name);
//        hash = 71 * hash + Objects.hashCode(this.hashedPassword);
//        hash = 71 * hash + Objects.hashCode(this.password);
//        hash = 71 * hash + Objects.hashCode(this.owner);
//        return hash;
//    }

    @Override
    public String toString()
    {
        return "Wallet{" + "id=" + id + ", name=" + name + ", password=" + hashedPassword + ", owner=" + owner + '}';
    }   
}