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

	@Test
	public void ifNoCurrentWinner() throws Exception {
		Field field = new Field();
		Point pnt1 = new Point(0 ,0);		
		Point pnt2 = new Point(1 ,1);
		Point pnt3 = new Point(2 ,2);	
		Point pnt4 = new Point(1 ,2);
		Point pnt5 = new Point(0 ,2);
		
		field.setFigure(pnt1, Figure.X);
		field.setFigure(pnt2, Figure.O);
		field.setFigure(pnt3, Figure.X);
		field.setFigure(pnt4, Figure.O);
		field.setFigure(pnt5, Figure.X);
		
		CurrentMoveController cmc = new CurrentMoveController();

		Figure expectedValue = Figure.O;
		Figure actualValue = cmc.currentMove(field);

		assertEquals(expectedValue, actualValue);

		field.setFigure(new Point(0, 1), Figure.O);

		expectedValue = Figure.X;
		actualValue = cmc.currentMove(field);
		assertEquals(expectedValue, actualValue);
	}
}
