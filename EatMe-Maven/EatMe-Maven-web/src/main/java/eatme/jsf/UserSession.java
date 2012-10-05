package eatme.jsf;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

/**
 *
 * @author Admin
 */
@Named(value = "userSession")
@SessionScoped
public class UserSession implements Serializable {

    private String username;

    @PostConstruct
    public void init() {
        this.username = FacesContext.getCurrentInstance()
                .getExternalContext().getUserPrincipal().getName();
    }

    public void logout(ActionEvent evt) throws IOException {
        ExternalContext ec =
                FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        ec.redirect("../index.xhtml");
    }
}
