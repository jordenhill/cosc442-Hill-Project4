package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InventoryTest {
	Inventory inventory = new Inventory();
	
	@Before
	public void setUp() {
		inventory = new Inventory();
	}
	
	@Test
	public void testSetCoffee() {
		inventory.setCoffee(1);
		assertEquals("Could not set amount of coffee", 1, inventory.getCoffee());
	}
	
	@Test
	public void testSetMilk() {
		inventory.setMilk(1);
		assertEquals("Set negative amount of milk", 1, inventory.getMilk());
	}
	
	@Test
	public void testSetSugar() {
		inventory.setSugar(1);
		assertEquals("Set negative amount of sugar", 1, inventory.getSugar());
	}
	
	@Test
	public void testSetChocolate() {
		inventory.setChocolate(1);
		assertEquals("Could not set amount of chocolate", 1, inventory.getChocolate());
	}
	
	@Test
	public void testSetCoffee2() {
		inventory.setCoffee(0);
		assertEquals("Amount of coffee didn't change", 0, inventory.getCoffee());
	}
	
	@Test
	public void testSetMilk2() {
		inventory.setMilk(1);
		assertEquals("Amount of milk didn't change", 1, inventory.getMilk());
	}
	
	@Test
	public void testSetSugar2() {
		inventory.setSugar(0);
		assertEquals("Amount of sugar didn't change", 0, inventory.getSugar());
	}
	
	@Test
	public void testSetChocolate2() {
		inventory.setChocolate(0);
		assertEquals("Amount of chocolate didn't change", 0, inventory.getChocolate());
	}
	
	@Test
	public void testSetCoffee3() {
		inventory.setCoffee(0);
		assertNotEquals("Amount of coffee didn't change", 10, inventory.getCoffee());
	}
	
	@Test
	public void testSetMilk3() {
		inventory.setMilk(0);
		assertNotEquals("Amount of milk didn't change", 10, inventory.getMilk());
	}
	
	@Test
	public void testSetSugar3() {
		inventory.setSugar(0);
		assertNotEquals("Amount of sugar didn't change", 10, inventory.getSugar());
	}
	
	@Test
	public void testSetChocolate3() {
		inventory.setChocolate(0);
		assertNotEquals("Amount of chocolate didn't change", 10, inventory.getChocolate());
	}
	
	@Test
	public void setNegativeCoffee() {
		inventory.setCoffee(-1);
		assertEquals("Set negative amount of coffee", 0, inventory.getCoffee());
	}
	
	@Test
	public void setNegativeMilk() {
		inventory.setMilk(-1);
		assertEquals("Set negative amount of milk", 0, inventory.getMilk());
	}
	
	@Test
	public void setNegativeSugar() {
		inventory.setSugar(-1);
		assertEquals("Set negative amount of sugar", 0, inventory.getSugar());
	}
	
	@Test
	public void setNegativeChocolate() {
		inventory.setChocolate(-1);
		assertEquals("Set negative amount of chocolate", 0, inventory.getChocolate());
	}
	
	@Test
	public void setNegativeCoffee2() {
		inventory.setCoffee(-2);
		assertNotEquals("Should not have been able to set negative amount of coffee", -2, inventory.getCoffee());
	}
	
	@Test
	public void setNegativeMilk2() {
		inventory.setMilk(-2);
		assertNotEquals("Should not have been able to set negative amount of milk", -2, inventory.getMilk());
	}
	
	@Test
	public void setNegativeSugar2() {
		inventory.setSugar(-2);
		assertNotEquals("Should not have been able to set negative amount of sugar", -2, inventory.getSugar());
	}
	
	@Test
	public void setNegativeChocolate2() {
		inventory.setChocolate(-2);
		assertNotEquals("Should not have been able to set negative amount of chocolate", -2, inventory.getChocolate());
	}
	
	@Test
	public void testInsufficientCoffee() {
		final Recipe r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(16);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
		assertFalse("Should not have enough coffee for recipe", inventory.enoughIngredients(r1));
	}
	
	@Test
	public void testInsufficientCoffee2() {
		final Recipe r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(15);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
		inventory.enoughIngredients(r1);
		assertTrue("Should have had enough for coffee", inventory.enoughIngredients(r1));
	}
	
	@Test
	public void testInsufficientMilk() {
		final Recipe r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(16);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
		assertFalse("Should not have enough milk for recipe", inventory.enoughIngredients(r1));
	}
	
	@Test
	public void testInsufficientMilk2() {
		final Recipe r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(15);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
		assertTrue("Should have had enough milk for recipe", inventory.enoughIngredients(r1));
	}
	
	@Test
	public void testInsufficientSugar() {
		final Recipe r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(1);
		r1.setAmtSugar(16);
		r1.setAmtChocolate(0);
		assertFalse("Should not have enough sugar for recipe", inventory.enoughIngredients(r1));
	}
	
	@Test
	public void testInsufficientSugar2() {
		final Recipe r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(1);
		r1.setAmtSugar(15);
		r1.setAmtChocolate(0);
		assertTrue("Should have had enough sugar for recipe", inventory.enoughIngredients(r1));
	}
	
	@Test
	public void testInsufficientChocolate() {
		final Recipe r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(16);
		assertFalse("Should not have enough chocolate for recipe", inventory.enoughIngredients(r1));
	}
	
	@Test
	public void testInsufficientChocolate2() {
		final Recipe r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(15);
		assertTrue("Should have had enough chocolate for recipe", inventory.enoughIngredients(r1));
	}
	
	@Test
	public void testToString() {
		final String expectedMessage = "Coffee: " + 15 + System.getProperty("line.separator") +
				"Milk: " + 15 + System.getProperty("line.separator") +
				"Sugar: " + 15 + System.getProperty("line.separator") +
				"Chocolate: " + 15 + System.getProperty("line.separator");
		assertEquals("toString messages not the same", expectedMessage, inventory.toString());
	}
}