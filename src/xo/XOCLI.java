package xo;

import xo.model.*;
import xo.model.exceptions.*;
import xo.view.ConsoleView;
import java.awt.Point;

public class XOCLI {

	public static void main(final String[] args) {
		Point pnt = new Point(1, 1);
		Player pl1 = new Player("Fed", Figure.X);
		Player pl2 = new Player("Mash", Figure.O);
		Player[] pls = { pl1, pl2 };
		Game xo = new Game("XO", pls);
		Field field = xo.getField();
		try {
			System.out.println(field.getSize());
			field.setFigure(pnt, Figure.X);
			Figure f = field.getFigure(pnt);
			System.out.println(f);
		} catch(InvalidCoordException e) {

		}


		ConsoleView cw = new ConsoleView();
		cw.show(xo);
	}
}
