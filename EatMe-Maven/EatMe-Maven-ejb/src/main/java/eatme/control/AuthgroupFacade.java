package eatme.control;

import eatme.entity.Authgroup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Admin
 */
@Stateless
public class AuthgroupFacade extends AbstractFacade<Authgroup> {
    @PersistenceContext(unitName = "EatMe-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuthgroupFacade() {
        super(Authgroup.class);
    }
    
}
