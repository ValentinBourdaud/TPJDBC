package org.diginamic.pizzeria;

import static org.junit.Assert.*;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class testPizzaMemDao{

@org.junit.Test
	public void testUpdatePizza(){
    	PizzaMemDao pizza = new PizzaMemDao();
    	Pizza p = new Pizza("CAR", "La Carbonara", 12.00);
    	pizza.updatePizza("FRO", p);
    	assertTrue(pizza.findAllPizzas().contains(p));
    	
    }
@org.junit.Test

    public void testDeletePizza(){
    	PizzaMemDao pizza = new PizzaMemDao();
    	pizza.deletePizza("FRO");
    	assertTrue(pizza.findAllPizzas().size()==7);
    	
    }
@org.junit.Test

    public void testFindAllPizzas(){
    	PizzaMemDao pizza = new PizzaMemDao();
    	
    	assertTrue(pizza.findAllPizzas().size()==8);

    }

@org.junit.Test

public void testSaveNewPizza(){
	PizzaMemDao pizza = new PizzaMemDao();
	Pizza p = new Pizza("CAR","La Carbonara", 12.00);
	pizza.saveNewPizza(p);
	assertTrue(pizza.findAllPizzas().size()==9);


}
}
  