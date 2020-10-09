package xo;

import xo.model.*;
import xo.model.exceptions.*;
import java.awt.Point;

public class XOCLI {

	public static void main(final String[] args) {
		Point pnt = new Point(1, 1);
		Field field = new Field();
		Player pl1 = new Player("Fed", Figure.X);
		Player pl2 = new Player("Mash", Figure.O);
		Player[] pls = { pl1, pl2 };
		Game newXO = new Game("XO", field, pls);
		try {
			System.out.println(field.getSize());
			field.setFigure(pnt, Figure.X);
			Figure f = field.getFigure(pnt);
			System.out.println(f);
		} catch(InvalidCoordException e) {

		}

		System.out.println(pl1.getName());
		System.out.println(pl1.getFigure());
		System.out.println(newXO.getName());
		System.out.println(newXO.getPlayers());		
	}
}
