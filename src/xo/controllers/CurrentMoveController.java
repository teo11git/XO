package xo.controllers;

import xo.model.Figure;
import xo.model.Field;
import xo.model.exceptions.*;

import java.awt.Point;

public class CurrentMoveController {
		
	public Figure currentMove() {

		return Figure.X;
	}

	public int countFigures(Field field) { //make private
		int i = 0;
		int j = 0;
		int amount = field.getSize() * field.getSize();
		int fieldSize = field.getSize();
		int counter = 0;
		Figure fg = null;

		while (i < amount) {
			int x = i - j * fieldSize;
			int y = j;
			Point pnt = new Point(x, y);
			System.out.println("" + pnt.x +  pnt.y);
			try {
				fg = field.getFigure(pnt);
			} catch(InvalidCoordException e) {
				System.out.println("oops from countFigures");
			}
			if (fg != null) {
				counter += 1;
			}
			i ++;

			if (i % fieldSize == 0) {
				j ++;
			}

		}
		return counter;
	}

} 
