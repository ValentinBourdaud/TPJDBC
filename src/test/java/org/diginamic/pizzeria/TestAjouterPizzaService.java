package org.diginamic.pizzeria;

import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.services.AjouterPizzaService;

public class TestAjouterPizzaService {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@org.junit.Test
	public void testExecuteUC(){
		
		AjouterPizzaService aps = new AjouterPizzaService();
		PizzaMemDao pizza = new PizzaMemDao();
		
		systemInMock.provideLines("CAR", "LaCarbonara", "12,00");
		Pizza p = new Pizza("CAR", "LaCarbonara", 12.00);
		aps.executeUC(new Scanner(System.in), pizza);
		assertTrue(pizza.findAllPizzas().contains(p));
		
	}
}
