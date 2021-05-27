package model;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Entity.Rockford;
import Entity.Actor;

public class ModelTest {

	private static final Rockford Actor = null;
	private static final Object character = null;
	private static final Entity.Actor Rockford = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCharacter() {
		Actor excepted = Rockford;
		assertEquals(excepted, this.Rockford);
	}
	@Test
	public void testSetLevel(){
		int excepted = 1;
		assertEquals(excepted, 1);
		
	}
	

}
