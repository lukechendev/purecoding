package problems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Test1 {
	
	private Solution1 s;

	@BeforeEach
	void setUp() throws Exception {
		s = new Solution1();
		
		s.increase(1);
		
		s.increase(2);
		s.increase(2);
		s.increase(2);
		
		s.increase(3);
		s.increase(3);
		
		s.increase(4);
		s.increase(4);
		s.increase(4);
		s.increase(4);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIncrease() {
		assertEquals(4, s.getKeyWithMaxValue());
		assertEquals(1, s.getKeyWithMinValue());
		
		s.increase(2);
		s.increase(2);
		
		assertEquals(2, s.getKeyWithMaxValue());
		assertEquals(1, s.getKeyWithMinValue());
	}

	@Test
	void testDecrease() {
		assertEquals(4, s.getKeyWithMaxValue());
		assertEquals(1, s.getKeyWithMinValue());
		
		s.decrease(4);
		s.decrease(4);
		
		assertEquals(2, s.getKeyWithMaxValue());
		assertEquals(1, s.getKeyWithMinValue());
	}

	@Test
	void testGetKeyWithMaxValue() {
		assertEquals(4, s.getKeyWithMaxValue());
		
		s.increase(2);
		s.increase(2);
		
		assertEquals(2, s.getKeyWithMaxValue());
		
		s.increase(4);
		s.decrease(2);
		
		assertEquals(4, s.getKeyWithMaxValue());
		
		s.decrease(4);
		s.decrease(4);
		
		assertEquals(2, s.getKeyWithMaxValue());
	}

	@Test
	void testGetKeyWithMinValue() {
		assertEquals(1, s.getKeyWithMinValue());
		
		s.increase(1);
		s.increase(1);
		
		assertEquals(3, s.getKeyWithMinValue());
		
		s.decrease(4);
		s.decrease(4);
		s.decrease(4);
		
		assertEquals(4, s.getKeyWithMinValue());
	}

}
