package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import repository.UserRepository;
import resources.Hash;

/**
 *
 * @author King Shadow
 */
@Entity
@Table(name = "Users")
public class User implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "Name", nullable=false)
    private String name;
    
    @Column(name = "Password", nullable = false)
    private String hashedPassword;
    
    @Transient
    private String password;
    
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<SingleChainWallet> singleChainWallets;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<MultiChainWallet> multiChainWallets;

    public User()
    {
    }

    public User(String name, String password)
    {
        this.name = name;
        this.password = password;
        this.hashedPassword = Hash.MD5_String(password);
        this.singleChainWallets = new ArrayList<>();
        this.multiChainWallets = new ArrayList<>();
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
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
        this.hashedPassword = Hash.MD5_String(password);
    }

    public String getHashedPassword()
    {
        return hashedPassword;
    }
    
    public List<SingleChainWallet> getPureSingleChainWallets()
    {
        return UserRepository.getUserSingleChainWallets(this);
    }

    public List<SingleChainWallet> getSingleChainWallets()
    {
        return singleChainWallets;
    }

    public void setSingleChainWallets(List<SingleChainWallet> singleChainWallets)
    {
        this.singleChainWallets = singleChainWallets;
    }

    public List<MultiChainWallet> getMultiChainWallets()
    {
        return multiChainWallets;
    }

    public void setMultiChainWallets(List<MultiChainWallet> multiChainWallets)
    {
        this.multiChainWallets = multiChainWallets;
    }

    @Override
    public String toString()
    {
        return "User{" + "id=" + id + ", name=" + name + ", password=" + hashedPassword + '}';
    }
}