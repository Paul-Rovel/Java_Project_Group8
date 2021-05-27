package Entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contract.IElement;

class ElementTest {
	private IElement sprite;
	private IElement permeability;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testElement() {
	//	fail("Not yet implemented");
	}

	@Test
	void testGetSprite() {
		IElement expected = sprite;
		assertEquals(expected, this.sprite);
	}

	@Test
	void testSetSprite() {
		IElement expected = sprite;
		assertEquals(expected, this.sprite);
	}

	@Test
	void testGetPermeability() {
		IElement expected = permeability;
		assertEquals(expected, this.sprite);
	}

	@Test
	void testGetImage() {
		//fail("Not yet implemented");
	}

	@Test
	void testGetName() {
		//fail("Not yet implemented");
	}

}
