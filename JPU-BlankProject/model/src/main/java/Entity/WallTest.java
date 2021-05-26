
package Entity;

import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WallTest {

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

	
	

  
	public class DiamondTest {

		private Object Wall;

		@Test
		public void testgetImgObject() {
			ImageIcon expected = null;
			Wall.setImgObject(null);
			assertEquals(expected, Wall.getImgObject());
			
		}
		@Test
		public void testgetIconObject() {
			ImageIcon expected = null;
			Wall.setIconObject(null);
			assertEquals(expected, Wall.getIconObject());
			
		}
}
}
