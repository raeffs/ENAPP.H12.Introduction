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
@Table(name = "dishes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dish.findAll", query = "SELECT d FROM Dish d"),
    @NamedQuery(name = "Dish.findByIddishes", query = "SELECT d FROM Dish d WHERE d.iddishes = :iddishes"),
    @NamedQuery(name = "Dish.findByName", query = "SELECT d FROM Dish d WHERE d.name = :name"),
    @NamedQuery(name = "Dish.findByDescription", query = "SELECT d FROM Dish d WHERE d.description = :description"),
    @NamedQuery(name = "Dish.findByValidOn", query = "SELECT d FROM Dish d WHERE d.validOn = :validOn")})
public class Dish implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddishes")
    private Integer iddishes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 320)
    @Column(name = "description")
    private String description;
    @Column(name = "validOn")
    @Temporal(TemporalType.DATE)
    private Date validOn;
    @JoinColumn(name = "location", referencedColumnName = "idlocations")
    @ManyToOne
    private Location location;

    public Dish() {
    }

    public Dish(Integer iddishes) {
        this.iddishes = iddishes;
    }

    public Dish(Integer iddishes, String name) {
        this.iddishes = iddishes;
        this.name = name;
    }

    public Integer getIddishes() {
        return iddishes;
    }

    public void setIddishes(Integer iddishes) {
        this.iddishes = iddishes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getValidOn() {
        return validOn;
    }

    public void setValidOn(Date validOn) {
        this.validOn = validOn;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddishes != null ? iddishes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dish)) {
            return false;
        }
        Dish other = (Dish) object;
        if ((this.iddishes == null && other.iddishes != null) || (this.iddishes != null && !this.iddishes.equals(other.iddishes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eatme.entity.Dish[ iddishes=" + iddishes + " ]";
    }
    
}
