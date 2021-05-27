package model;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DBPropertiesTest {
	static DBProperties dbproperties;

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
	public void testProperties() {
		final String url = "jdbc:mysql://localhost:3308/boulder?useSSL=false&serverTimezone=UTC";
		final String login = "root";
		final String password = "";
		
		assertEquals(url, dbproperties.getUrl());
		assertEquals(login, dbproperties.getLogin());
		assertEquals(password, dbproperties.getPassword());
	}

}
