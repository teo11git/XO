package xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest { 

	@Test
	public void testGetName() throws Exception {
		final String inputValue = "Mash";
		final String expectedValue = "Mash";

		Player player= new Player(inputValue, null);

		final String actualValue = player.getName();
		assertEquals(actualValue, expectedValue);
	}
}
