package org.diginamic.pizzeria;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.services.AjouterPizzaService;

public class TestAuRevoirService {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@org.junit.Test
	public void testExecuteUC(){
		AjouterPizzaService aps = new AjouterPizzaService();
		PizzaMemDao pizza = new PizzaMemDao();
		
		systemInMock.provideLines("Au revoir");
		

		
	}
}
