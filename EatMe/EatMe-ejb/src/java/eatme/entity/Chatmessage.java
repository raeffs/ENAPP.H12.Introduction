package eatme.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "chatmessages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chatmessage.findAll", query = "SELECT c FROM Chatmessage c"),
    @NamedQuery(name = "Chatmessage.findByIdchatmessages", query = "SELECT c FROM Chatmessage c WHERE c.idchatmessages = :idchatmessages"),
    @NamedQuery(name = "Chatmessage.findByMessage", query = "SELECT c FROM Chatmessage c WHERE c.message = :message"),
    @NamedQuery(name = "Chatmessage.findByEnteredat", query = "SELECT c FROM Chatmessage c WHERE c.enteredat = :enteredat")})
public class Chatmessage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idchatmessages")
    private Integer idchatmessages;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 160)
    @Column(name = "message")
    private String message;
    @Column(name = "enteredat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enteredat;
    @JoinColumn(name = "user", referencedColumnName = "idusers")
    @ManyToOne(optional = false)
    private User user;

    public Chatmessage() {
    }

    public Chatmessage(Integer idchatmessages) {
        this.idchatmessages = idchatmessages;
    }

    public Chatmessage(Integer idchatmessages, String message) {
        this.idchatmessages = idchatmessages;
        this.message = message;
    }

    public Integer getIdchatmessages() {
        return idchatmessages;
    }

    public void setIdchatmessages(Integer idchatmessages) {
        this.idchatmessages = idchatmessages;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getEnteredat() {
        return enteredat;
    }

    public void setEnteredat(Date enteredat) {
        this.enteredat = enteredat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idchatmessages != null ? idchatmessages.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chatmessage)) {
            return false;
        }
        Chatmessage other = (Chatmessage) object;
        if ((this.idchatmessages == null && other.idchatmessages != null) || (this.idchatmessages != null && !this.idchatmessages.equals(other.idchatmessages))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eatme.entity.Chatmessage[ idchatmessages=" + idchatmessages + " ]";
    }
    
}
