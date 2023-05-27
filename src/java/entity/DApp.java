package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author King Shadow
 */
@Entity
@Table(name = "DApps")
public class DApp implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "Name", nullable = false)
    private String name;
    
    @Column(name = "Url", nullable = false)
    private String url;
    
    @Column(name = "Image", nullable = false)
    private String imagePath;

    public DApp()
    {
    }

    public DApp(String name, String url, String imagePath)
    {
        this.name = name;
        this.url = url;
        this.imagePath = imagePath;
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

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getImagePath()
    {
        return imagePath;
    }

    public void setImagePath(String imagePath)
    {
        this.imagePath = imagePath;
    }
}