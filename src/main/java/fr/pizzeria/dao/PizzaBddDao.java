package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.model.Pizza;

public class PizzaBddDao implements IPizzaDao {

	private static final Logger LOG = LoggerFactory.getLogger(PizzaBddDao.class);

	private Connection con;

	public PizzaBddDao() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdd_pizzeria", "root", "");

		} catch (ClassNotFoundException e) {
			LOG.error("Impossible de charger le pilote jdbc");
		} catch (SQLException e) {
			LOG.error("SQL Exception");
		}
	}

	public List<Pizza> findAllPizzas() {

		List<Pizza> listpizzas = new ArrayList<Pizza>();

		try {

			PreparedStatement insertPizza = con.prepareStatement("SELECT * FROM pizzas");

			ResultSet resultats = insertPizza.executeQuery();

			while (resultats.next())
				listpizzas.add(new Pizza(resultats.getInt("ID"), resultats.getString("CODE"),
						resultats.getString("NAME"), resultats.getDouble("PRICE")));
			resultats.close();

		} catch (SQLException e) {
			LOG.error("SQL Exception");
		}
		return listpizzas;

	}

	public void saveNewPizza(Pizza pizza) {

		try {

			PreparedStatement saveNewPizza = con.prepareStatement("INSERT INTO pizzas VALUES  (?, ?, ?, ?)");

			saveNewPizza.setInt(1, pizza.getId());
			saveNewPizza.setString(2, pizza.getCode());
			saveNewPizza.setString(3, pizza.getLibelle());
			saveNewPizza.setDouble(4, pizza.getPrix());

			saveNewPizza.executeUpdate();

			saveNewPizza.close();

		} catch (SQLException e) {
			LOG.error("SQL Exception");
		}
	}

	public void updatePizza(String codePizza, Pizza pizza) {
		try {

			PreparedStatement updatePizza = con
					.prepareStatement("UPDATE pizzas SET CODE=?, NAME=?, PRICE=? WHERE CODE =?");

			
			updatePizza.setString(1, pizza.getCode());
			updatePizza.setString(2, pizza.getLibelle());
			updatePizza.setDouble(3, pizza.getPrix());
			updatePizza.setString(4, codePizza);


			updatePizza.executeUpdate();

			updatePizza.close();

		} catch (SQLException e) {
			LOG.error("SQL Exception");
		}
	}

	public void deletePizza(String codePizza) {
		try {

			PreparedStatement deletePizza = con.prepareStatement("DELETE pizzas WHERE CODE = ?");

			deletePizza.setString(1, codePizza);
			deletePizza.executeUpdate();
			deletePizza.close();

		} catch (SQLException e) {
			LOG.error("SQL Exception");
		}
	}

	public Pizza findPizzaByCode(String codePizza) {

		Pizza piz = null;

		try {

			PreparedStatement findPizzaByCode = con.prepareStatement("SELECT * FROM PIZZAS WHERE CODE = ?");

			ResultSet resultats = findPizzaByCode.executeQuery();

			findPizzaByCode.setString(1, codePizza);
			piz = new Pizza(resultats.getInt("ID"), resultats.getString("CODE"), resultats.getString("NAME"),
					resultats.getDouble("PRICE"));

			findPizzaByCode.executeQuery();
			findPizzaByCode.close();

		} catch (SQLException e) {
			LOG.error("SQL Exception");
		}

		return piz;
	}

	public boolean pizzaExists(String codePizza) {

		boolean pizEx = false;

		try {

			PreparedStatement pizzaExists = con.prepareStatement("SELECT * FROM PIZZAS WHERE CODE = ?");

			ResultSet resultats = pizzaExists.executeQuery();

			pizzaExists.setString(1, codePizza);
			pizEx = !resultats.wasNull();

			pizzaExists.close();

		} catch (SQLException e) {
			LOG.error("SQL Exception");
		}

		return pizEx;
	}

}
