package eatme.control;

import eatme.control.exception.UsernameExistsException;
import eatme.entity.User;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author Admin
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UserFacade extends AbstractFacade<User> {
    @PersistenceContext(unitName = "EatMe-ejbPU")
    private EntityManager em;
    
    @Resource
    private UserTransaction tx;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
    public void createUser(User entity) throws UsernameExistsException {
        try{
            try {
                tx.begin();
                super.create(entity);
                em.flush();
                em.merge(entity);
            } finally {
                tx.commit();
            }
        } catch (Exception e){
            throw new UsernameExistsException(e);
        }
    }

    public User getUserWithId(int userId){
        return em.createNamedQuery("Users.findByIdusers", User.class).setParameter("idusers", userId).getSingleResult();
    }
}
