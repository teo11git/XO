package xo;

import xo.model.*;
import xo.model.exceptions.*;
import java.awt.Point;

public class XOCLI {

	public static void main(final String[] args) {
		Point pnt = new Point(1, 1);
		Field field = new Field();
		try {
			System.out.println(field.getSize());
			field.setFigure(pnt, Figure.X);
			Figure f = field.getFigure(pnt);
			System.out.println(f);
		} catch(InvalidCoordException e) {

		}

		
	}
}
