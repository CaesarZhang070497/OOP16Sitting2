import org.junit.Before;
import org.junit.Test;

public class UG5StudentTest {

	private UG5Student u, u2;
	private Course c;

	@Before
	public void setUp() {
		u = new UG5Student("David Parnas", "s0000000", 0);
		u2 = new UG5Student();
		c = new Course();
	}

	@Test
	public void testToString() {
		String s = u.toString();
	}

	@Test
	public void testAddCourse() {
		boolean b = u.addCourse(c);
	}

	@Test
	public void testLevel9s() {
		int b = u.level9s();
	}

}
