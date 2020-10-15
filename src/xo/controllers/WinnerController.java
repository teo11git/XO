package xo.controllers;

import xo.model.Field;
import xo.model.Figure;
import xo.model.exceptions.InvalidCoordException;

import java.awt.Point;

public class WinnerController {

	public Figure getWinner(Field field) {
		//System.out.println("Try to check Rows");
		Figure fg = checkRows(field);
		if (fg == null) {
		//System.out.println("try to check Colls");
			fg = checkColls(field);
		}
		if (fg == null) {
			System.out.println("try to check Diag-s");
			fg = checkDiagonals(field);
		}
		return fg;
	}

	private Figure checkRows(Field field) {
		int i = 0;
		int j = 0;
		int fieldSize = field.getSize();
		int amount = fieldSize * fieldSize;
		int counter = 0;
		int target = fieldSize - 1;
		Figure initialFigure = null;
		Figure figure = null;

		while (i < amount && counter < target) {
			//System.out.println("I is " + i );
			//System.out.println("J is " + j );
			int x = i - fieldSize * j;
			int y = j;

			if (x == 0) {
				Point initialPoint = new Point(x, y);
				initialFigure = getFigure(field, initialPoint);
				counter = 0;
				i ++;
				continue;
			}

			Point point = new Point(x, y);
			figure = getFigure(field, point);

			if (initialFigure == figure && initialFigure != null) {
			counter += 1;
			}

			i ++;
			if (i % fieldSize == 0) {
				j ++;
			}
	}
		return counter == target ? initialFigure : null;
}

	private Figure checkColls(Field field) {
		int i = 0;
		int j = 0;
		int fieldSize = field.getSize();
		int amount = fieldSize * fieldSize;
		int counter = 0;
		
		Figure initialFigure = null;
		Figure figure = null;


		while (i < amount && counter < fieldSize - 1) {
			int x = j;
			int y = i - fieldSize * j;
			//System.out.println("x is " + x + "y is " + y);
			if (y == 0) {
				Point initialPoint = new Point(x, y);
				initialFigure = getFigure(field, initialPoint);
				counter = 0;
				i ++;
				continue;
			}

			Point point = new Point(x, y);
			figure = getFigure(field, point);

			if (initialFigure == figure && initialFigure != null) {
			counter += 1;
			//System.out.println("Counter is " + counter);
			}

			i ++;
			if (i % fieldSize == 0) {
				j ++;
			}
	}
		return counter == fieldSize - 1 ? initialFigure : null;
	}

	private Figure  checkDiagonals(Field field) {
	
		int i = 0;
		int j = 0;
		int fieldSize = field.getSize();
		int counter = 0;

		Point initialPoint1 = new Point(i, j);
		Figure initialFigure1 = getFigure(field, initialPoint1);
		//System.out.println("InitialFigure is " + initialFigure1);
		//System.out.println("InitialFigure is " + initialFigure2);
	

		while(i + 1 < fieldSize) {
			if (initialFigure1 == null) {
			break;
			}
			i ++;
			j ++;
			//System.out.println("I is " + i);
			//System.out.println("j is " + j);		
			Point nextPoint = new Point(i, j);
			Figure figure = getFigure(field, nextPoint);
			if (initialFigure1 == figure) {
				counter += 1;
			}
		}
		if (counter == 2) {
			return initialFigure1;
		}
		
		counter = 0;
		i = fieldSize - 1;
		j = 0;
		Point initialPoint2 = new Point(fieldSize - 1, j);
		Figure initialFigure2 = getFigure(field, initialPoint2);
		
		while(j + 1 < fieldSize) {
			if (initialFigure2 == null) {
			break;
			}
			//System.out.println("I is " + i);
			//System.out.println("j is " + j);		
			i --;
			j ++;
			Point nextPoint = new Point(i, j);
			Figure figure = getFigure(field, nextPoint);
			if (initialFigure2 == figure) {
				counter += 1;
			}
		}

		if (counter == 2) {
			return initialFigure2;
		}
		return null;		 
	}

	private Figure getFigure(Field field, Point point){
		try {
			return field.getFigure(point);
		} catch(InvalidCoordException e) {
			System.out.println("InvalidCoord from WinnerController");
			System.out.println("with point " + point.x + "|" + point.y );
			return null;		}
	}
}
