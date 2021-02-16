package problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Test1_2 {

	private Solution1_2 s;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testNow() {
		s = new Solution1_2();

		s.increase(1);

		s.increase(2);
		s.increase(2);
		s.increase(2);

		s.increase(3);
		s.increase(3);
		
		assertEquals(2, s.getKeyWithMaxValue());

		s.increase(2);
		s.increase(2);

		assertEquals(2, s.getKeyWithMaxValue());
	}
}
