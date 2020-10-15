package xo.controllers;

import xo.model.Field;
import xo.model.Figure;
import java.awt.Point;
import xo.controllers.WinnerController;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class WinnerControllerTest {
	
	Field field;

	WinnerController wc;

	@Before
	public void createField() {
		field = new Field();
		wc = new WinnerController();
	}


	@Test
	public void shouldWinXRow() throws Exception {
		field.setFigure(new Point(0, 0), Figure.O);
		field.setFigure(new Point(0, 1), Figure.X);
		field.setFigure(new Point(1, 1), Figure.X);
		field.setFigure(new Point(2, 1), Figure.X);
		field.setFigure(new Point(2, 2), Figure.O);

		Figure expectedValue = Figure.X;
		Figure actualValue = wc.getWinner(field);

		assertEquals(expectedValue, actualValue);
	}

	@Test
	public void shouldWinORow() throws Exception {
		field.setFigure(new Point(0, 0), Figure.X);
		field.setFigure(new Point(1, 1), Figure.X);
		field.setFigure(new Point(2, 1), Figure.X);
		field.setFigure(new Point(0, 2), Figure.O);
		field.setFigure(new Point(1, 2), Figure.O);
		field.setFigure(new Point(2, 2), Figure.O);

		Figure expectedValue = Figure.O;
		Figure actualValue = wc.getWinner(field);

		assertEquals(expectedValue, actualValue);
	}
	//
	@Test
	public void shouldWinXColl() throws Exception {
		field.setFigure(new Point(0, 0), Figure.X);
		field.setFigure(new Point(0, 1), Figure.X);
		field.setFigure(new Point(0, 2), Figure.X);
		field.setFigure(new Point(1, 1), Figure.O);
		field.setFigure(new Point(1, 2), Figure.O);

		Figure expectedValue = Figure.X;
		Figure actualValue = wc.getWinner(field);

		assertEquals(expectedValue, actualValue);
	}
	//
	@Test
	public void shouldWinOColl() throws Exception {
		field.setFigure(new Point(0, 0), Figure.X);
		field.setFigure(new Point(2, 0), Figure.X);
		field.setFigure(new Point(2, 1), Figure.X);
		field.setFigure(new Point(1, 0), Figure.O);
		field.setFigure(new Point(1, 1), Figure.O);
		field.setFigure(new Point(1, 2), Figure.O);

		Figure expectedValue = Figure.O;
		Figure actualValue = wc.getWinner(field);

		assertEquals(expectedValue, actualValue);
	}
	//
	@Test
	public void shouldWinXDiag() throws Exception {
		field.setFigure(new Point(0, 0), Figure.X);
		field.setFigure(new Point(1, 1), Figure.X);
		field.setFigure(new Point(2, 2), Figure.X);
		field.setFigure(new Point(1, 0), Figure.O);
		field.setFigure(new Point(2, 1), Figure.O);

		Figure expectedValue = Figure.X;
		Figure actualValue = wc.getWinner(field);

		assertEquals(expectedValue, actualValue);
	}
	//
	@Test
	public void shouldWinODiag() throws Exception {
		field.setFigure(new Point(1, 0), Figure.X);
		field.setFigure(new Point(2, 1), Figure.X);
		field.setFigure(new Point(2, 0), Figure.O);
		field.setFigure(new Point(1, 1), Figure.O);
		field.setFigure(new Point(0, 2), Figure.O);

		Figure expectedValue = Figure.O;
		Figure actualValue = wc.getWinner(field);

		assertEquals(expectedValue, actualValue);
	}
	//
	@Test
	public void noWinner() throws Exception {
		field.setFigure(new Point(0, 0), Figure.X);
		field.setFigure(new Point(1, 1), Figure.X);
		field.setFigure(new Point(1, 2), Figure.X);
		field.setFigure(new Point(0, 1), Figure.O);
		field.setFigure(new Point(0, 2), Figure.O);
		field.setFigure(new Point(2, 2), Figure.O);

		Figure expectedValue = null;
		Figure actualValue = wc.getWinner(field);

		assertEquals(expectedValue, actualValue);
	}



}
