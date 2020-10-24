package xo.view;

import xo.model.Field;
import xo.model.Figure;
import java.awt.Point;
import xo.view.ConsoleView;
import xo.model.exceptions.*;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ConsoleViewTest {

	Field field;

	ConsoleView cv;

	@Before
	public void createBefore() {
		field = new Field();
		cv = new ConsoleView();
	}

	@Test
	public void showEmptyField() 
		throws InvalidCoordException {
		cv.showField(field);
	}

	@Test
	public void showSomeField() 
		throws InvalidCoordException {
		
		field.setFigure(new Point(0, 0), Figure.X);
		field.setFigure(new Point(1, 0), Figure.O);
		field.setFigure(new Point(2, 1), Figure.X);
		field.setFigure(new Point(1, 2), Figure.O);
		
		cv.showField(field);
	}

	@Test
	public void showFullField()
		throws InvalidCoordException {

		field.setFigure(new Point(0, 0), Figure.X);
		field.setFigure(new Point(1, 0), Figure.X);
		field.setFigure(new Point(2, 0), Figure.X);

		field.setFigure(new Point(0, 1), Figure.O);
		field.setFigure(new Point(1, 1), Figure.O);
		field.setFigure(new Point(2, 1), Figure.O);

		field.setFigure(new Point(0, 2), Figure.X);
		field.setFigure(new Point(1, 2), Figure.X);
		field.setFigure(new Point(2, 2), Figure.X);	

		cv.showField(field);
	}


}
