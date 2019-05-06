package bugs.repro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyDataClassTest {


	@Test
	public void itShouldCreate() {
		assertEquals(MyDataClass.create("MyProp"),MyDataClass.create("MyProp"));
	}
}