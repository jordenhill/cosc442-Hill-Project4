package edu.towson.cis.cosc442.project4.coffeemaker;

import junit.framework.TestCase;

/**
 *
 */
public class CoffeeMakerTest extends TestCase {
	private CoffeeMaker cm;
	private Inventory i;
	private Recipe r1;

	public void setUp() {
		cm = new CoffeeMaker();
		i = cm.checkInventory();

		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
	}

	public void testAddRecipe1() {
		assertTrue(cm.addRecipe(r1));
	}
	
	public void testAddRecipe2() {
		cm.addRecipe(r1);
		assertFalse(cm.addRecipe(r1));
	}

	public void testDeleteRecipe1() {
		cm.addRecipe(r1);
		assertTrue(cm.deleteRecipe(r1));
	}
	
	public void testDeleteRecipe2() {
		assertFalse(cm.deleteRecipe(null));
	}
	
	public void testEditRecipe1() {
		cm.addRecipe(r1);
		Recipe newRecipe = new Recipe();
		newRecipe = r1;
		newRecipe.setAmtSugar(2);
		assertTrue(cm.editRecipe(r1, newRecipe));
	}
	
	public void testAddInventory1() {
		boolean addedInv = cm.addInventory(3, 1, 2, 1);
		assertTrue("Could not add inventory", addedInv);
	}
	
	public void testAddInventory2() {
		cm.addInventory(3, 1, 2, 1);
		cm.addRecipe(r1);
		cm.deleteRecipe(r1);
		assertEquals("Inventory changed", 18, cm.checkInventory().getCoffee());
	}
	
	public void testAddInventory3() {
		cm.addInventory(3, 1, 2, 1);
		assertEquals("Inventory changed", 16, cm.checkInventory().getMilk());
	}
	
	public void testAddInventory4() {
		cm.addInventory(3, 1, 2, 1);
		assertEquals("Inventory changed", 17, cm.checkInventory().getSugar());
	}
	
	public void testAddInventory5() {
		cm.addInventory(3, 1, 2, 1);
		assertEquals("Inventory changed", 16, cm.checkInventory().getChocolate());
	}
	
	public void testAddNegativeCoffee() {
		cm.addInventory(-1, 1, 2, 1);
		assertEquals("Added negative amount of coffee", 15, cm.checkInventory().getCoffee());
	}
	
	public void testAddNegativeMilk() {
		cm.addInventory(3, -1, 2, 1);
		assertEquals("Added negative amount of milk", 15, cm.checkInventory().getMilk());
	}
	
	public void testAddNegativeSugar() {
		cm.addInventory(3, 1, -1, 1);
		assertEquals("Added negative amount of chocolate", 15, cm.checkInventory().getSugar());
	}
	
	public void testAddNegativeChocolate() {
		cm.addInventory(3, 1, 2, -1);
		assertEquals("Added negative amount of chocolate", 15, cm.checkInventory().getChocolate());
	}
	
	public void testCheckInventory1() {
		assertNotNull("Could not check inventory", cm.checkInventory());
	}
	
	public void testMakePurchase1() {
		cm.addRecipe(r1);
		assertEquals("Did not get correct amount of change", 25, cm.makeCoffee(r1, 75));
	}
	
	public void testMakePurchase2() {
		cm.addRecipe(r1);
		assertEquals("Did not get amount paid back", 40, cm.makeCoffee(r1, 40));
	}
	
	public void testInsufficientInventory() {
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(16);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
		cm.addRecipe(r1);
		assertEquals("Made coffee without enough ingredients", 50, cm.makeCoffee(r1, 50));
	}
	
	public void testCoffeeAmountAlteration() {
		cm.addRecipe(r1);
		cm.makeCoffee(r1, 50);
		assertEquals("Incorrect coffee", 9, cm.checkInventory().getCoffee());
	}
	
	public void testMilkAmountAlteration() {
		cm.addRecipe(r1);
		cm.makeCoffee(r1, 50);
		assertEquals("Incorrect milk amount", 14, cm.checkInventory().getMilk());
	}
	
	public void testSugarAmountAlteration() {
		cm.addRecipe(r1);
		cm.makeCoffee(r1, 50);
		assertEquals("Incorrect coffee", 14, cm.checkInventory().getSugar());
	}
	
	public void testChocolateAmountAlteration() {
		r1.setAmtChocolate(1);
		cm.addRecipe(r1);
		cm.makeCoffee(r1, 50);
		assertEquals("Incorrect coffee", 14, cm.checkInventory().getChocolate());
	}
	
	public void testGetRecipeForName() {
		cm.addRecipe(r1);
		assertEquals("Got incorrect recipe", "Coffee", cm.getRecipeForName("Coffee").getName());
	}
}