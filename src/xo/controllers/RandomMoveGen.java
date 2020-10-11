package xo.controllers;

import xo.model.Field;
import java.awt.Point;

public class RandomMoveGen {

	public Point makeRandomMove(Field field) {
		int x = getRandomCoord(field);
		int y = getRandomCoord(field);

		Point point = new Point(x, y);
		
		return point;
	}

	private int getRandomCoord(Field field) {
		return (int)(Math.random() * 10 % (field.getSize()));
	}


}
