package resources;

import entity.Blockchain;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author King Shadow
 */

@Converter(autoApply = true)
public class ChainConverter implements AttributeConverter<Blockchain.Chain, String>
{
    @Override
    public String convertToDatabaseColumn(Blockchain.Chain attribute)
    {
        if(attribute == null)
            return null;
        
        return attribute.getName();
    }

    @Override
    public Blockchain.Chain convertToEntityAttribute(String dbData)
    {
        if(dbData == null)
            return null;
        
        for(Blockchain.Chain chain : Blockchain.Chain.values())
        {
            if(dbData.equals(chain.getName()))
                return chain;
        }
        
        return Blockchain.Chain.valueOf(dbData.toUpperCase());
    }
}