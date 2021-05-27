package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contract.IActor;
import contract.ILevel;

class ModelTest {

	private ILevel level;
	private IActor rockford;
	
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
	void testGetLevel() {
		final ILevel  expected = level;
		assertEquals(expected, this.level);
	}

	@Test
	void testGetRockford() {
		IActor excepted = rockford;
		assertEquals(excepted, this.rockford);
	}

}
