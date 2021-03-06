package reto2desktopclient.model;

import java.io.Serializable;
import java.net.URL;

/**
 * Stores a social network of an Artist.
 * @see Artist
 * @author Aitor Fidalgo
 */
public class SocialNetwork implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private URL socialNetwork;
    private Artist artist;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public URL getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(URL socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SocialNetwork)) {
            return false;
        }
        SocialNetwork other = (SocialNetwork) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "entity.SocialNetwork[ id=" + id + " ]";
    }
    
}
