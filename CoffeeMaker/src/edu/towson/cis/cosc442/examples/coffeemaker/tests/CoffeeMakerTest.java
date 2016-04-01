/**
 * 
 */
package edu.towson.cis.cosc442.examples.coffeemaker.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.towson.cis.cosc442.examples.coffeemaker.*;

/**
 * @author jhill19
 *
 */
public class CoffeeMakerTest {

	CoffeeMaker myCoffeeMaker;
	Recipe myRecipe1;
	Recipe myRecipe2;
	Recipe myRecipe3;
	Recipe myRecipe4;
	Recipe myRecipe5;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		//Construct CoffeeMaker
		myCoffeeMaker = new CoffeeMaker();
		
		//Construct Recipes
		myRecipe1 = new Recipe();
		myRecipe2 = new Recipe();
		myRecipe3 = new Recipe();
		myRecipe4 = new Recipe();
		myRecipe5 = new Recipe();
		
		//Set myRecipe1 parameters
		myRecipe1.setName("Coffee");
		myRecipe1.setPrice(50);
		myRecipe1.setAmtCoffee(3);
		myRecipe1.setAmtMilk(1);
		myRecipe1.setAmtSugar(1);
		myRecipe1.setAmtChocolate(0);
		
		//Set myRecipe2 parameters
		myRecipe2.setName("Mocha");
		myRecipe2.setPrice(50);
		myRecipe2.setAmtCoffee(3);
		myRecipe2.setAmtMilk(1);
		myRecipe2.setAmtSugar(2);
		myRecipe2.setAmtChocolate(3);
		
		//Set myRecipe3 parameters
		myRecipe3.setName("Latte");
		myRecipe3.setPrice(70);
		myRecipe3.setAmtCoffee(2);
		myRecipe3.setAmtMilk(2);
		myRecipe3.setAmtSugar(4);
		myRecipe3.setAmtChocolate(2);
		
		//Set myRecipe4 parameters
		myRecipe4.setName("Capuccino");
		myRecipe4.setPrice(40);
		myRecipe4.setAmtCoffee(2);
		myRecipe4.setAmtMilk(3);
		myRecipe4.setAmtSugar(2);
		myRecipe4.setAmtChocolate(1);
		
		//Set myRecipe5 parameters
		myRecipe4.setName("Espresso");
		myRecipe4.setPrice(40);
		myRecipe4.setAmtCoffee(4);
		myRecipe4.setAmtMilk(2);
		myRecipe4.setAmtSugar(3);
		myRecipe4.setAmtChocolate(0);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		myCoffeeMaker = null;
		System.gc();
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.examples.coffeemaker.CoffeeMaker#CoffeeMaker()}.
	 */
	@Test
	public final void testCoffeeMaker() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.examples.coffeemaker.CoffeeMaker#addRecipe(edu.towson.cis.cosc442.examples.coffeemaker.Recipe)}.
	 * Testing for successfully adding a recipe a la acceptance test addRecipe1
	 */
	@Test
	public final void testAddRecipe() {
		//Can you add a recipe?
		boolean successfullyAdded = myCoffeeMaker.addRecipe(myRecipe1);
		assertTrue("Successfully added recipe", successfullyAdded);
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc442.examples.coffeemaker.CoffeeMaker#addRecipe(edu.towson.cis.cosc442.examples.coffeemaker.Recipe)}.
	 * Testing for unsuccessfully adding a recipe with an exact copy
	 */
	@Test
	public final void testAddSameRecipe() {
		//Can you not add the same recipe again?
		boolean successfullyAdded = myCoffeeMaker.addRecipe(myRecipe1);
		boolean unsuccessfullyAdded = myCoffeeMaker.addRecipe(myRecipe1);
		assertFalse("Unsuccessfully added recipe", unsuccessfullyAdded);
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc442.examples.coffeemaker.CoffeeMaker#addRecipe(edu.towson.cis.cosc442.examples.coffeemaker.Recipe)}.
	 * Testing for successfully adding a second recipe to the list
	 */
	@Test
	public final void testAddSecondRecipe() {
		//Can you not add a second recipe?
		myCoffeeMaker.addRecipe(myRecipe1);
		boolean successfullyAdded = myCoffeeMaker.addRecipe(myRecipe2);
		assertTrue("Successfully added second recipe", successfullyAdded);
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.examples.coffeemaker.CoffeeMaker#addRecipe(edu.towson.cis.cosc442.examples.coffeemaker.Recipe)}.
	 * Testing for successfully adding a third recipe to the list
	 */
	@Test
	public final void testAddThirdRecipe() {
		//Can you not add a second recipe?
		myCoffeeMaker.addRecipe(myRecipe1);
		myCoffeeMaker.addRecipe(myRecipe2);
		boolean successfullyAdded = myCoffeeMaker.addRecipe(myRecipe3);
		assertTrue("Successfully added third recipe", successfullyAdded);
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc442.examples.coffeemaker.CoffeeMaker#addRecipe(edu.towson.cis.cosc442.examples.coffeemaker.Recipe)}.
	 * Testing for successfully adding a fourth recipe to the list
	 */
	@Test
	public final void testAddFourthRecipe() {
		//Can you not add a second recipe?
		myCoffeeMaker.addRecipe(myRecipe1);
		myCoffeeMaker.addRecipe(myRecipe2);
		myCoffeeMaker.addRecipe(myRecipe3);
		boolean successfullyAdded = myCoffeeMaker.addRecipe(myRecipe4);
		assertTrue("Successfully added fourth recipe", successfullyAdded);
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc442.examples.coffeemaker.CoffeeMaker#addRecipe(edu.towson.cis.cosc442.examples.coffeemaker.Recipe)}.
	 * Testing for unsuccessfully adding a fifth recipe to the list
	 */
	@Test
	public final void testAddFifthRecipe() {
		//Can you not add a second recipe?
		myCoffeeMaker.addRecipe(myRecipe1);
		myCoffeeMaker.addRecipe(myRecipe2);
		myCoffeeMaker.addRecipe(myRecipe3);
		myCoffeeMaker.addRecipe(myRecipe4);
		boolean unsuccessfullyAdded = myCoffeeMaker.addRecipe(myRecipe5);
		assertFalse("Unsuccessfully added fifth recipe", unsuccessfullyAdded);
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc442.examples.coffeemaker.CoffeeMaker#deleteRecipe(edu.towson.cis.cosc442.examples.coffeemaker.Recipe)}.
	 */
	@Test
	public final void testDeleteRecipe() {
		//Can you delete a recipe?
		myCoffeeMaker.addRecipe(myRecipe1);
		boolean successfullyDeleted = myCoffeeMaker.deleteRecipe(myRecipe1);
		assertTrue("Unsuccessfully deleted Coffee recipe", successfullyDeleted);
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.examples.coffeemaker.CoffeeMaker#editRecipe(edu.towson.cis.cosc442.examples.coffeemaker.Recipe, edu.towson.cis.cosc442.examples.coffeemaker.Recipe)}.
	 */
	@Test
	public final void testEditRecipe() {
		// Can you edit a recipe?
		myCoffeeMaker.addRecipe(myRecipe1);
		Recipe newRecipe = new Recipe();
		newRecipe.setName("Coffee");
		newRecipe.setPrice(50);
		newRecipe.setAmtCoffee(3);
		newRecipe.setAmtMilk(2);
		newRecipe.setAmtSugar(1);
		newRecipe.setAmtChocolate(0);
		boolean successfullyEdited = myCoffeeMaker.editRecipe(myRecipe1, newRecipe);
		assertTrue("Unsuccessfully edited recipe", successfullyEdited);
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.examples.coffeemaker.CoffeeMaker#addInventory(int, int, int, int)}.
	 */
	@Test
	public final void testAddInventory() {
		boolean successfullyAddedInventory = myCoffeeMaker.addInventory(3, 1, 2, 1);
		assertTrue("Unsuccesfully added inventory", successfullyAddedInventory);
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.examples.coffeemaker.CoffeeMaker#checkInventory()}.
	 */
	@Test
	public final void testCheckInventory() {
		assertNotNull("Could not get iventory", myCoffeeMaker.checkInventory());
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.examples.coffeemaker.CoffeeMaker#makeCoffee(edu.towson.cis.cosc442.examples.coffeemaker.Recipe, int)}.
	 */
	@Test
	public final void testMakeCoffee() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.examples.coffeemaker.CoffeeMaker#getRecipes()}.
	 */
	@Test
	public final void testGetRecipes() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.examples.coffeemaker.CoffeeMaker#getRecipeForName(java.lang.String)}.
	 */
	@Test
	public final void testGetRecipeForName() {
		fail("Not yet implemented"); // TODO
	}

}
