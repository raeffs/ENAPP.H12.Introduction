package eatme.control;

import eatme.entity.Dish;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Admin
 */
@Stateless
public class DishFacade extends AbstractFacade<Dish> {

    @PersistenceContext(unitName = "EatMe-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DishFacade() {
        super(Dish.class);
    }

    public List<Dish> getAllDishesForDate(Date validOn) {
        return em.createNamedQuery("Dishes.findByValidOn", Dish.class).setParameter("validOn", validOn).getResultList();
    }
}
