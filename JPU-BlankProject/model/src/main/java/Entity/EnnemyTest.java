package Entity;

import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EnnemyTest {

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
		public void testgetImgObject() {
			ImageIcon expected = null;
			Ennemy.setImgObject(null);
			assertEquals(expected, Ennemy.getImgObject());
			
		}
		@Test
		public void testgetIconObject() {
			ImageIcon expected = null;
			Ennemy.setIconObject(null);
			assertEquals(expected, Ennemy.getIconObject());
			
		}

	}



