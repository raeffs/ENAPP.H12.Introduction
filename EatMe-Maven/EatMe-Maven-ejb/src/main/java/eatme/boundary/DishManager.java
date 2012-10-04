package eatme.boundary;

import eatme.boundary.dto.Dish;
import eatme.control.DishFacade;
import java.util.ArrayList;
import java.util.Date;
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
public class DishManager {

    @Inject
    DishFacade dishFacade;

    public List<Dish> getDishesForDate(Date validOn) {
        return mapEntitesToDtos(dishFacade.getAllDishesForDate(validOn));
    }

    private List<Dish> mapEntitesToDtos(List<eatme.entity.Dish> entities){
        List<Dish> dtos = new ArrayList<Dish>();
        for (eatme.entity.Dish entity : entities){
            Dish dto = new Dish();
            dto.setName(entity.getName());
            dto.setDescription(entity.getDescription());
            dto.setLocation(entity.getLocation().getName() + ", " + entity.getLocation().getAddress());
            dto.setValidOn(entity.getValidOn());
            dtos.add(dto);
        }
        return dtos;
    }
}
