package eatme.boundary.dto;

/**
 *
 * @author Admin
 */
public class User {

    private Integer idusers;
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private Boolean isChef;

    public Integer getIdusers() {
        return idusers;
    }

    public void setIdusers(Integer idusers) {
        this.idusers = idusers;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsChef() {
        return isChef;
    }

    public void setIsChef(Boolean isChef) {
        this.isChef = isChef;
    }
}
