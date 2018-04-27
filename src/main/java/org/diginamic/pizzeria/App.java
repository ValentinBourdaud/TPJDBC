package org.diginamic.pizzeria;

import fr.pizzeria.dao.PizzaBddDao;
import fr.pizzeria.model.Pizza;

public class App 
{
    public static void main( String[] args )
    {
        PizzaBddDao pizzaBddDao = new PizzaBddDao();
        Pizza piz = new Pizza(1, "CAR", "La Carbonara", 12.0);  
        pizzaBddDao.saveNewPizza(piz);
    	
        Pizza piz2 = new Pizza(2, "PEP", "Peperoni", 12.5);  
        pizzaBddDao.saveNewPizza(piz2);
        
        Pizza piz3 = new Pizza(3, "MAR", "Margherita", 14.0);  
        pizzaBddDao.saveNewPizza(piz3);
        
        Pizza piz4 = new Pizza(4, "REIN", "La Reine",11.5);  
        pizzaBddDao.saveNewPizza(piz4);
        
        Pizza piz5 = new Pizza(5, "FRO", "La 4 Fromages", 12.0);  
        pizzaBddDao.saveNewPizza(piz5);
        
        Pizza piz6 = new Pizza(6, "CAN", "La Cannibale", 12.5);  
        pizzaBddDao.saveNewPizza(piz6);
        
        Pizza piz7 = new Pizza(7, "SAV", "La Savoyarde", 13.0);  
        pizzaBddDao.saveNewPizza(piz7);
        
        Pizza piz8 = new Pizza(8, "ORI", "L'orientale", 13.5);  
        pizzaBddDao.saveNewPizza(piz8);
        
        Pizza piz9 = new Pizza(9, "IND", "L'indienne", 14.0);  
        pizzaBddDao.saveNewPizza(piz9);
        
        
    }
}
