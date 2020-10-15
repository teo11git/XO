package xo.controllers;

import xo.model.Field;
import xo.model.Figure;
import java.awt.Point;

import xo.model.exceptions.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class CurrentMoveControllerTest {
		
	@Test
	public void ifFieldIsEmpty() {
		Field field = new Field();
		CurrentMoveController cmc = new CurrentMoveController();
		
		Figure expectedValue = Figure.X;
		Figure actualValue = null;
		try {
			actualValue = cmc.currentMove(field);
		} catch (NoWinnerException e) {
			
		}
		assertEquals(actualValue, expectedValue);
	}


}
