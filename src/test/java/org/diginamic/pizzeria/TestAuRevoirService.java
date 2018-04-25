package org.diginamic.pizzeria;

import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.services.AjouterPizzaService;
import fr.pizzeria.services.AuRevoirService;

public class TestAuRevoirService {
	@Rule
	public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Test 
	public void AuRevoirServiceTest (){
		PizzaMemDao pizzas = new PizzaMemDao();
		AuRevoirService auRevoirService= new AuRevoirService();
		auRevoirService.executeUC(new Scanner(System.in), pizzas);
		assertTrue( systemOutRule.getLog().equals("Au revoir\r\n")); 
		
		
	}
	

		
	}

