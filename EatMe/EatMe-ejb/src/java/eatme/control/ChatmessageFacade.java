package eatme.control;

import eatme.entity.Chatmessage;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Admin
 */
@Stateless
public class ChatmessageFacade extends AbstractFacade<Chatmessage> {
    @PersistenceContext(unitName = "EatMe-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ChatmessageFacade() {
        super(Chatmessage.class);
    }
    
}
