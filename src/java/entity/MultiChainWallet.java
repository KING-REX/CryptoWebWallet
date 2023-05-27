package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import repository.AddressRepository;
import repository.BlockchainRepository;

/**
 *
 * @author King Shadow
 */
@Entity 
@Table(name = "MultiChainWallets")
@NamedQueries({
    @NamedQuery(name = "Wallet.findMCWalletById", query = "SELECT w FROM MultiChainWallet w WHERE w.id = :id")
})
public class MultiChainWallet extends Wallet implements Serializable 
{
    @OneToMany(cascade = CascadeType.ALL)
    private List<SingleChainWallet> wallets;

    @Transient
    private Address addressContainer;
    
    public MultiChainWallet()
    {
    }
    
    public MultiChainWallet(String name, String password, User owner)
    {
        super(name, password, owner);
        
        this.addressContainer = new Address();
        this.wallets = new ArrayList<>();
        
        for(Blockchain chain : BlockchainRepository.getAllSupportedBlockchains())
        {
            wallets.add(new SingleChainWallet(name, password, chain, true, owner));
        }
        this.generatePrivateKeysAndAddress();
    }
    
    public Address getAddress(Blockchain blockchain)
    {
        for(SingleChainWallet wallet : wallets)
        {
            if(wallet.getChain().equals(blockchain))
                return wallet.getAddress();
        }
        return null;
    }
    
    public void setAddress(String address, Blockchain chain)
    {
        for(SingleChainWallet wallet : wallets)
        {
            if(wallet.getChain().equals(chain))
            {
                wallet.setAddress(address);
            }
            break;
        }
    }
    
    public Address getAddressContainer()
    {
        return this.addressContainer;
    }

    public void setAddressContainer(Address addressContainer)
    {
        this.addressContainer = addressContainer;
    }

    public List<SingleChainWallet> getWallets()
    {
        return wallets;
    }

    public void setWallets(List<SingleChainWallet> wallets)
    {
        this.wallets = wallets;
    }
    
    private void generatePrivateKeysAndAddress()
    {
        AddressRepository.generateVoidPrivateKeys(this.getAddressContainer());
        
        for(SingleChainWallet wallet : wallets)
        {
            wallet.getAddress().setSeedWords(this.getAddressContainer().getSeedWords());
            wallet.getAddress().setSeedPhrase(this.getAddressContainer().getSeedPhrase());
            wallet.getAddress().setPrivateKey(this.getAddressContainer().getPrivateKey());
            wallet.getAddress().setHashedPrivateKey(this.getAddressContainer().getHashedPrivateKey());
            wallet.getAddress().setHashedSeedPhrase(this.getAddressContainer().getHashedSeedPhrase());
            wallet.getAddress().setAddress(AddressRepository.generateNewAddress(wallet.getChain(), wallet.getAddress().getSeedPhrase()));
        }
    }
    
    public static void main(String[] args)
    {
        MultiChainWallet multiChainWallet = new MultiChainWallet("Walletre", "Okayyy", new User("User1", "123123"));
        for(SingleChainWallet wallet : multiChainWallet.getWallets())
        {
            System.out.println("Wallet: " + wallet);
        }
    }
}