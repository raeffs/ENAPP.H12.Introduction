package eatme.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "authgroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Authgroup.findAll", query = "SELECT a FROM Authgroup a"),
    @NamedQuery(name = "Authgroup.findByIdauthgroup", query = "SELECT a FROM Authgroup a WHERE a.idauthgroup = :idauthgroup"),
    @NamedQuery(name = "Authgroup.findByGroupname", query = "SELECT a FROM Authgroup a WHERE a.groupname = :groupname"),
    @NamedQuery(name = "Authgroup.findByUsername", query = "SELECT a FROM Authgroup a WHERE a.username = :username")})
public class Authgroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idauthgroup")
    private Integer idauthgroup;
    @Size(max = 255)
    @Column(name = "groupname")
    private String groupname;
    @Size(max = 255)
    @Column(name = "username")
    private String username;

    public Authgroup() {
    }

    public Authgroup(Integer idauthgroup) {
        this.idauthgroup = idauthgroup;
    }

    public Integer getIdauthgroup() {
        return idauthgroup;
    }

    public void setIdauthgroup(Integer idauthgroup) {
        this.idauthgroup = idauthgroup;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idauthgroup != null ? idauthgroup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Authgroup)) {
            return false;
        }
        Authgroup other = (Authgroup) object;
        if ((this.idauthgroup == null && other.idauthgroup != null) || (this.idauthgroup != null && !this.idauthgroup.equals(other.idauthgroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eatme.entity.Authgroup[ idauthgroup=" + idauthgroup + " ]";
    }
    
}
