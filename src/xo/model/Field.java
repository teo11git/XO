package xo.model;

import java.awt.Point;
import xo.model.exceptions.InvalidCoordException;

public class Field {

	final int FIELD_SIZE = 3;

	final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

	public int getSize() {
		return FIELD_SIZE;	
	}

	public void setFigure(Point point, Figure figure) throws InvalidCoordException {
		if (checkPoint(point) == false) {
			throw new InvalidCoordException();
		}
	field[point.x][point.y] = figure;
	}

	public Figure getFigure(Point point) throws InvalidCoordException {
		if (checkPoint(point) == false) {
			throw new InvalidCoordException();
		}
		return field[point.x][point.y];
	}

	private boolean checkPoint(Point point) {
	return checkCoordinate(point.x) && checkCoordinate(point.y) ? true : false;
	}

	private boolean checkCoordinate(int coord) {
		if (coord < 0) {
			return false;
		}
		if (coord >= FIELD_SIZE) {
			return false;
		}
		return true;
	}
}
