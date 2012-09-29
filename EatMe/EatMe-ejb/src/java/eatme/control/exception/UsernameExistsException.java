package eatme.control.exception;

import javax.ejb.ApplicationException;

/**
 *
 * @author Admin
 */
@ApplicationException(rollback=false)
public class UsernameExistsException extends RuntimeException{
    
    public UsernameExistsException(Throwable cause){
        super(cause);
    }
}
