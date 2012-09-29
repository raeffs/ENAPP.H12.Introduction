package eatme.entity;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "locations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
    @NamedQuery(name = "Location.findByIdlocations", query = "SELECT l FROM Location l WHERE l.idlocations = :idlocations"),
    @NamedQuery(name = "Location.findByName", query = "SELECT l FROM Location l WHERE l.name = :name"),
    @NamedQuery(name = "Location.findByAddress", query = "SELECT l FROM Location l WHERE l.address = :address")})
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlocations")
    private Integer idlocations;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "address")
    private String address;
    @JoinColumn(name = "chef", referencedColumnName = "idusers")
    @ManyToOne(optional = false)
    private User chef;
    @OneToMany(mappedBy = "location")
    private List<Dish> dishList;

    public Location() {
    }

    public Location(Integer idlocations) {
        this.idlocations = idlocations;
    }

    public Location(Integer idlocations, String name, String address) {
        this.idlocations = idlocations;
        this.name = name;
        this.address = address;
    }

    public Integer getIdlocations() {
        return idlocations;
    }

    public void setIdlocations(Integer idlocations) {
        this.idlocations = idlocations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getChef() {
        return chef;
    }

    public void setChef(User chef) {
        this.chef = chef;
    }

    @XmlTransient
    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlocations != null ? idlocations.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.idlocations == null && other.idlocations != null) || (this.idlocations != null && !this.idlocations.equals(other.idlocations))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eatme.entity.Location[ idlocations=" + idlocations + " ]";
    }
    
}
