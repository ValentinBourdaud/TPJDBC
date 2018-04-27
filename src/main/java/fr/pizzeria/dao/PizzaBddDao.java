package fr.pizzeria.dao;

import java.sql.*;
import java.util.List;

import fr.pizzeria.model.Pizza;

public class PizzaBddDao implements IPizzaDao {
	{
	 try {
	      Class.forName("com.mysql.jdbc.Drvier");
	    } catch (ClassNotFoundException e) {
	      System.out.println("Impossible de charger le pilote jdbc");
	    }
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bdd_pizzeria, «root», «»");
	
	PreparedStatement insertPizza = con.prepareStatement("INSERT PIZZA WHERE CODE=? AND NAME=? AND PRICE=?");
	

	insertPizza.setString(1, );
	insertPizza.setString(1, );
	
	insertPizza.setDouble(1, );

	public List<Pizza> findAllPizzas() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveNewPizza(Pizza pizza) {
		// TODO Auto-generated method stub

	}

	public void updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub

	}

	public void deletePizza(String codePizza) {
		// TODO Auto-generated method stub

	}

	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

}
