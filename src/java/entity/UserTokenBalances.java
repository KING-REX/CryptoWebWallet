package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author King Shadow
 */
@Entity 
public class UserTokenBalances implements Serializable 
{
    @Id
    @JoinColumn(name = "AddressId", referencedColumnName = "ID", nullable = false, unique = true)
    private Long addressId;

    public UserTokenBalances()
    {
    }

    public Long getAddressId()
    {        
        return addressId;
    }

    public void setAddressId(Long addressId)
    {
        this.addressId = addressId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (addressId != null ? addressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the addressId fields are not set
        if(!(object instanceof UserTokenBalances))
        {
            return false;
        }
        UserTokenBalances other = (UserTokenBalances) object;
        if((this.addressId == null && other.addressId != null) || (this.addressId != null && !this.addressId.equals(other.addressId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entity.UserTokenBalances[ id=" + addressId + " ]";
    }
    
}
