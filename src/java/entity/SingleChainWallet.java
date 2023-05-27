package entity;

import java.io.Serializable;
import javax.persistence.*;
import repository.AddressRepository;
import repository.BlockchainRepository;
import resources.Hash;

/**
 *
 * @author King Shadow
 */
@Entity
@Table(name = "SingleChainWallets")
@NamedQueries({
    @NamedQuery(name = "Wallet.findSCWalletByAddress", query = "SELECT w FROM SingleChainWallet w WHERE w.address = :address"),
    @NamedQuery(name = "Wallet.findSCWalletById", query = "SELECT w FROM SingleChainWallet w WHERE w.id = :id")
})
public class SingleChainWallet extends Wallet implements Serializable
{
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AddressID", referencedColumnName = "ID")
    private Address address;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BlockchainID", nullable = false, referencedColumnName = "id")
    private Blockchain chain;

    public SingleChainWallet()
    {
    }
    
    public SingleChainWallet(String name, String password, Blockchain chain, boolean fromMultiChain, User owner)
    {
        super(name, password, owner);
        this.chain = chain;
        this.address = new Address(chain);
        generateNewWallet(fromMultiChain, chain);
    }
    
    public void setAddress(String address)
    {
        if(BlockchainRepository.isValidAddress(address, chain))
            this.getAddress().setAddress(address);
        else
            throw new IllegalArgumentException("Invalid address");
    }

    public Blockchain getChain()
    {
        return chain;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }
    
    public Transaction sendTokens(Token token, double amountTransferred, SingleChainWallet recipient, String password)
    {
        if(!Hash.MD5_String(password).equals(getHashedPassword()))
            throw new IllegalArgumentException("Invalid Password");
        
        return address.sendTokens(token, amountTransferred, recipient.getAddress());
    }
    
    private void generateNewWallet(boolean fromMultiChain, Blockchain chain)
    {
        if(!fromMultiChain)
        {
            AddressRepository.generatePrivateKeys(this.getAddress(), chain);
            this.getAddress().setAddress(AddressRepository.generateNewAddress(chain, this.getAddress().getSeedPhrase()));
        }
    }

    @Override
    public String toString()
    {
        return "SingleChainWallet{" + "name=" + getName() + ", seedPhrase=" + getAddress().getHashedSeedPhrase() + ", privateKey=" + getAddress().getHashedPrivateKey() + ", address=" + address + ", chain=" + chain + '}';
    }
}