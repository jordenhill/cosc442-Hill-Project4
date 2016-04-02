package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecipeTest {
	Recipe r;
	
	@Before
	public void setUp() throws Exception {
		r = new Recipe();
	}

	@Test
	public void testSetCoffee() {
		r.setAmtCoffee(5);
		assertEquals("Incorrect amount of coffee set", 5, r.getAmtCoffee());
	}

	@Test
	public void testSetNegativeCoffee() {
		r.setAmtCoffee(-5);
		assertEquals("Incorrect amount of coffee set", 0, r.getAmtCoffee());
	}
	
	@Test
	public void testSetMilk() {
		r.setAmtMilk(5);
		assertEquals("Incorrect amount of milk set", 5, r.getAmtMilk());
	}
	
	@Test
	public void testSetnegativeMilk() {
		r.setAmtMilk(-5);
		assertEquals("Incorrect amount of milk set", 0, r.getAmtMilk());
	}
	
	@Test
	public void testSetSugar() {
		r.setAmtSugar(5);
		assertEquals("Incorrect amount of sugar set", 5, r.getAmtSugar());
	}
	
	@Test
	public void testSetNegativeSugar() {
		r.setAmtSugar(-1);
		assertEquals("Incorrect amount of sugar set", 0, r.getAmtSugar());
	}
	
	@Test
	public void testSetChocolate() {
		r.setAmtChocolate(5);
		assertEquals("Incorrect amount of chocolate set", 5, r.getAmtChocolate());
	}
	
	@Test
	public void testSetNegativeChocolate() {
		r.setAmtChocolate(-1);
		assertEquals("Incorrect amount of chocolate set", 0, r.getAmtChocolate());
	}
	
	@Test
	public void testSetNegativePrice() {
		r.setPrice(-1);
		assertEquals("Incorrect price set", 0, r.getPrice());
	}
	
	@Test
	public void testEqualsWithOtherNull() {
		r.setName("Coffee");
		final Recipe r2 = new Recipe();
		assertFalse("Returned that recipes were equal", r.equals(r2));
	}
	
	@Test
	public void testEqualsWithThisNull() {
		final Recipe r2 = new Recipe();
		r2.setName("Latte");
		assertFalse("Returned that recipes were equal", r.equals(r2));
	}
	
	@Test
	public void testEqualsWithDiffName() {
		final Recipe r2 = new Recipe();
		r.setName("Coffee");
		r2.setName("Latte");
		assertFalse("Returned that recipes were equal", r.equals(r2));
	}
	
	@Test
	public void testToString() {
		r.setName("Coffee");
		assertEquals("Incorrect name", "Coffee", r.toString());
	}
	
	@Test
	public void testToString2() {
		r.setName("Coffee");
		assertNotEquals("Incorrect name", "Latte", r.toString());
	}
}
