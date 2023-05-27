package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import repository.BlockchainRepository;

/**
 *
 * @author King Shadow
 */
@Entity
@Table(name = "Blockchains")
public class Blockchain implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "Name", nullable = false)
    private Chain chain;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NativeTokenID", referencedColumnName = "ID")
    private Token nativeToken;
    
    @OneToMany(mappedBy = "parentChain", cascade = CascadeType.ALL)
    private final List<Token> tokensHosted;
    
    @OneToMany(mappedBy = "blockChain", cascade = CascadeType.ALL)
    private final List<Transaction> transactions;
    
    @OneToMany(mappedBy = "parentChain")
    private final List<Address> addresses;
    
    public static enum Chain
    {
        ALGORAND("[A-Z0-9]{58}", "Algorand"), BINANCESMARTCHAIN("0x[a-f0-9]{40}", "Binance Smart Chain"), BITCOIN("bc1[aq][a-zA-Z0-9]{38}", "Bitcoin"), 
        ETHEREUM("0x[a-f0-9]{40}", "Ethereum"), FANTOM("0x[a-f0-9]{40}", "Fantom"), IOTEX("", "Iotex"), POLYGON("0x[a-f0-9]{40}", "Polygon"), 
        SOLANA("[A-Z][0-9][a-zA-Z0-9]{42}", "Solana"), TRON("T[a-zA-Z0-9]{33}", "Tron");
        
        private final String addressFormat;
        private final String name;
        private boolean isSupported = false;
        
        Chain(String addressFormat, String name) {
            this.addressFormat = addressFormat;
            this.isSupported = !addressFormat.equals("");
            this.name = name;
        }

        public String getAddressFormat()
        {
            return addressFormat;
        }
        
        public String getName()
        {
            return name;
        }
        
        public boolean isSupported()
        {
            isSupported = !addressFormat.equals("");
            return isSupported;
        }
        
        public List<Chain> getSupportedChains()
        {
            List<Chain> supportedChains = new ArrayList<>();
            for(Chain chain : values())
            {
                if(!chain.getAddressFormat().equals(""))
                    supportedChains.add(chain);
            }
            
            return supportedChains;
        }
        
        @Override        
        public String toString()
        {
            return this.name();
        }
    }

    public Blockchain()
    {
        this.tokensHosted = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.addresses = new ArrayList<>();
    }

    public Blockchain(Token nativeToken, Chain chain)
    {
        this.nativeToken = nativeToken;
        this.tokensHosted = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.chain = chain;
        
        this.tokensHosted.add(nativeToken);
        
        this.addresses = new ArrayList<>();
    }

    public long getId()
    {
        return id;
    }

    public String getAddressFormat()
    {
        return chain.getAddressFormat();
    }

    public Token getNativeToken()
    {
        return nativeToken;
    }

    public void setNativeToken(Token nativeToken)
    {
        this.nativeToken = nativeToken;
        
        if(!tokensHosted.contains(nativeToken))
            tokensHosted.add(nativeToken);
        
//        BlockchainRepository.updateBlockchain(this);
    }

    /**
     * Returns a list of all the tokens hosted on this blockchain.
     * @return a list of all the tokens hosted on this blockchain.
     */
    public List<Token> getTokensHosted()
    {
        return tokensHosted;
    }
    
    /**
     * Returns a list of all transactions carried out on this blockchain.
     * @return a list of all transactions carried out on this blockchain.
     */
    public List<Transaction> getTransactions()
    {
        return this.transactions;
    }
    
    /**
     * Returns a list of all addresses existing on this blockchain.
     * @return a list of all addresses existing on this blockchain.
     */
    public List<Address> getAddresses()
    {
        return this.addresses;
    }

    public Chain getChain()
    {
        return chain;
    }

    public void setChain(Chain chain)
    {
        this.chain = chain;
        
//        BlockchainRepository.updateBlockchain(this);
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return this == null;
        
        if(!(obj instanceof Blockchain))
            return false;
        
        Blockchain otherBlockchain = (Blockchain) obj;
        return this.id == otherBlockchain.id;
    }

    @Override
    public String toString()
    {
        return "Blockchain{" + "id=" + id + ", nativeToken=" + nativeToken + ", chain=" + chain + '}';
    }
}