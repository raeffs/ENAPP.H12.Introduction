package eatme.boundary;

import eatme.control.UserFacade;
import eatme.entity.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Admin
 */
public class UserManagerTest {
    
    @Mock
    private UserFacade userFacade;
    
    private UserManager sut;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        setUpUserFacade();
        sut = new UserManager(userFacade);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void checkPasswordForUsername_UserDoesNotExist_ReturnsFalse() {
        boolean actual = sut.checkPasswordForUsername("unknownuser", "123456");
        assertFalse(actual);
    }
    
    @Test
    public void checkPasswordForUsername_PasswordMatches_ReturnsTrue() {
        boolean actual = sut.checkPasswordForUsername("tafleisc", "123456");
        assertTrue(actual);
    }
    
    @Test
    public void checkPasswordForUsername_PasswordDoesNotMatch_ReturnsFalse() {
        boolean actual = sut.checkPasswordForUsername("tafleisc", "wrongpw");
        assertFalse(actual);
    }

    private void setUpUserFacade() {
        List<User> users = new ArrayList<User>();
        
        User user = new User(1);
        user.setUsername("tafleisc");
        user.setPassword("123456");
        
        users.add(user);
        
        when(userFacade.findAll()).thenReturn(users);
    }
}
