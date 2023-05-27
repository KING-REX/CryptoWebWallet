package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.persistence.*;
import repository.AddressRepository;
import repository.BlockchainRepository;
import repository.TokenRepository;

/**
 *
 * @author King Shadow
 */
@Entity
@Table(name = "Addresses")
@NamedQueries({
    @NamedQuery(name = "Address.findAddressBySeedPhrase", query = "SELECT a FROM Address a WHERE a.hashedSeedPhrase = :seedPhrase"),
    @NamedQuery(name = "Address.findAddressByPrivateKey", query = "SELECT a FROM Address a WHERE a.hashedPrivateKey = :privateKey")
})
public class Address implements Serializable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "Address", nullable = false)
    private String address;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Parent_Blockchain", nullable = false, referencedColumnName = "ID")
    private Blockchain parentChain;
    
    @Transient
    private String[] seedWords;
    
    @Transient
    private String seedPhrase;
    
    @Column(name = "SeedPhrase", nullable = false)
    private String hashedSeedPhrase;
    
    @Transient
    private String privateKey;
    
    @Column(name = "PrivateKey", nullable = false)
    private String hashedPrivateKey;
    
    @OneToMany(mappedBy = "from")
    private List<Transaction> fromTransactions;
    
    @OneToMany(mappedBy = "to")
    private List<Transaction> toTransactions;
    
    @OneToMany(mappedBy = "ID", cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "ID", name = "TokenBalanceID")
    private List<AddressTokenBalance> tokenBalances;
    
    public Address()
    {
    }
    
    public Address(Blockchain chain)
    {
        if(addressExists())
            throw new IllegalArgumentException("Address already exists");
        if(chain == null)
            throw new IllegalArgumentException("The chain of your address is null oh!!!");
        
        
        this.tokenBalances = new ArrayList<>();
        this.parentChain = chain;
        this.generatePrivateKeys();
        this.address = BlockchainRepository.generateNewAddress(chain, this.seedPhrase);
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Blockchain getParentChain()
    {
        return parentChain;
    }

    public void setParentChain(Blockchain parentChain)
    {
        this.parentChain = parentChain;
    }

    public String[] getSeedWords()
    {
        return seedWords;
    }

    public void setSeedWords(String[] seedWords)
    {
        this.seedWords = seedWords;
    }

    public String getSeedPhrase()
    {
        return seedPhrase;
    }

    public void setSeedPhrase(String seedPhrase)
    {
        this.seedPhrase = seedPhrase;
    }

    public String getHashedSeedPhrase()
    {
        return hashedSeedPhrase;
    }

    public void setHashedSeedPhrase(String hashedSeedPhrase)
    {
        this.hashedSeedPhrase = hashedSeedPhrase;
    }

    public String getPrivateKey()
    {
        return privateKey;
    }

    public void setPrivateKey(String privateKey)
    {
        this.privateKey = privateKey;
    }

    public String getHashedPrivateKey()
    {
        return hashedPrivateKey;
    }

    public void setHashedPrivateKey(String hashedPrivateKey)
    {
        this.hashedPrivateKey = hashedPrivateKey;
    }

    public List<Transaction> getFromTransactions()
    {
        return fromTransactions;
    }

    public void setFromTransactions(List<Transaction> fromTransactions)
    {
        this.fromTransactions = fromTransactions;
    }

    public List<Transaction> getToTransactions()
    {
        return toTransactions;
    }

    public void setToTransactions(List<Transaction> toTransactions)
    {
        this.toTransactions = toTransactions;
    }

    public List<AddressTokenBalance> getTokenBalances()
    {
        return tokenBalances;
    }

    public void setTokenBalances(List<AddressTokenBalance> tokenBalances)
    {
        this.tokenBalances = tokenBalances;
    }
    
    
    private void generatePrivateKeys()
    {
        AddressRepository.generatePrivateKeys(this, this.parentChain);
    }
    
    private void resetTokenBalances()
    {
        for(Token token : TokenRepository.getAllNativeTokens())
        {
            if(this.parentChain == token.getParentChain())
                tokenBalances.add(new AddressTokenBalance(this, token, 0.00));
        }
//        TokenRepository.getAllNativeTokens().forEach((token) -> {tokenBalances.put(token, new Double(0));});
    }
    
    private boolean addressExists()
    {
        return AddressRepository.addressExists(this, this.parentChain);
    }

    public Transaction sendTokens(Token token, double amountTransferred, Address recipient)
    {
        return AddressRepository.sendTokens(this, token, amountTransferred, recipient);
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
        if(!(object instanceof Address))
            return false;
        Address other = (Address) object;
        return ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString()
    {
        return getAddress();
    }    
}
