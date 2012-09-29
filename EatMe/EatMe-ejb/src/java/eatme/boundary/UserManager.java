package eatme.boundary;

import eatme.boundary.dto.User;
import eatme.control.UserFacade;
import eatme.control.exception.UsernameExistsException;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Admin
 */
@Stateless
@LocalBean
public class UserManager {
    
    @Inject
    private UserFacade userFacade;

    public boolean checkPasswordForUsername(String username, String password) {
        List<eatme.entity.User> users = userFacade.findAll();
        for (eatme.entity.User user : users) {
            if (username.equals(user.getUsername())) {
                return password.equals(user.getPassword());
            }
        }
        return false;
    }
    
    public int addUser(User user) {
        eatme.entity.User newUser = mapDtoToEntity(user);
        try {
            newUser.setUsername(user.getEmail());
            userFacade.createUser(newUser);
            return newUser.getIdusers();
        } catch (UsernameExistsException e) {
            return -1;
        }
    }
    
    private eatme.entity.User mapDtoToEntity(User dto) {
        eatme.entity.User entity = new eatme.entity.User(dto.getIdusers());
        entity.setEmail(dto.getEmail());
        entity.setFirstname(dto.getFirstname());
        entity.setIsChef(dto.getIsChef());
        entity.setLastname(dto.getLastname());
        entity.setPassword(dto.getPassword());
        return entity;
    }

}
