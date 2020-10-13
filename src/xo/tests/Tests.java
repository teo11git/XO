package xo.tests;

import xo.model.*;
import xo.model.exceptions.*;
import xo.controllers.*;
import xo.view.*;
import java.awt.Point;

public class Tests {

	public void makeTests() {
		Player pl1 = new Player("Fed", Figure.X);
		Player pl2 = new Player("Mash", Figure.O);
		Player[] players = { pl1, pl2 };
		Game game = new Game("XO", players);
	}

	public void testRandomMoveGen() {
		RandomMoveGen rmg = new RandomMoveGen();

		Game game = createNewGame();
		Field fld = game.getField();
		for(int i = 0; i < 10; i ++) {
			Point point = rmg.makeRandomMove(fld);
			System.out.format("X is %d Y is %d",point.x, point.y);
			System.out.println("---");
		}
		for(int i = 0; i < 1000; i ++) {
			Point point = rmg.makeRandomMove(fld);
			if (point.x > fld.getSize()) {
				System.out.println("ERRROORR");
				return;
			}
		}
		System.out.println("makeRandomMove works well");
	}
	
	public void applyFigureTest() {
		MoveController mc = new MoveController();

		Game game = createNewGame();
		Field field = game.getField();

		Point pnt1 = new Point(0, 0);
		Point pnt2 = new Point(1, 1);
		Point pnt3 = new Point(2, 2);
		try {
			mc.applyFigure(field, Figure.X, pnt1);
			mc.applyFigure(field, Figure.X, pnt2);
			mc.applyFigure(field, Figure.X, pnt3);
		} catch (InvalidCoordException e) { 

		} catch (AllreadyOccupiedException e) {

		}

		ConsoleView cv = new ConsoleView();
		cv.show(game);

		System.out.println("Try to check exceptions");
		try {
			Point pntErr = new Point(10, 20);
			mc.applyFigure(field, Figure.X, pntErr);
			
		} catch (InvalidCoordException e) {
			System.out.println("Exception from tests: 64 = InvalidPoint");
			System.out.println("Good!!");
		} catch (AllreadyOccupiedException e) {

		}

		try {
			mc.applyFigure(field, Figure.O, pnt2);
		} catch (InvalidCoordException e) {

		} catch (AllreadyOccupiedException e) {
			System.out.println("Exception from tests: 77 = AllreadyOccupied");
			System.out.println("Good!");
		}
	}

	public void countFiguresTest() {
	Game game = createNewGame();
	Field field = game.getField();
	MoveController mc = new MoveController();

	Point pnt1 = new Point(0, 0);
	Point pnt2 = new Point(1, 1);
	Point pnt3 = new Point(1, 2);
	Point pnt4 = new Point(2, 2);

	try {
		mc.applyFigure(field, Figure.X, pnt1);
		mc.applyFigure(field, Figure.X, pnt2);
		mc.applyFigure(field, Figure.X, pnt3);
		mc.applyFigure(field, Figure.X, pnt4);
	} catch (InvalidCoordException e) {

	} catch (AllreadyOccupiedException e) {

	}
		CurrentMoveController cmc = new CurrentMoveController();
		int result = cmc.countFigures(field);
		System.out.println(result);

	}

	public void makeFieldTest() {
		ConsoleView cv = new ConsoleView();
		FieldGenerator fieldGen = new FieldGenerator();
		Game game = createNewGame();
		Field field = game.getField();
		fieldGen.makeField(field);
		cv.show(game);
	}

	public void getWinnerTest() {
		Game game = createNewGame();
		Field field = game.getField();
		MoveController mc = new MoveController();

		Point point1 = new Point(2, 0);
		Point point2 = new Point(1, 1);
		Point point3 = new Point(1, 2);
		try {
			mc.applyFigure(field, Figure.X, point1);
			mc.applyFigure(field, Figure.X, point2);
			mc.applyFigure(field, Figure.X, point3);
		} catch (InvalidCoordException e) {

		} catch (AllreadyOccupiedException e) {

		}

		WinnerController wc = new WinnerController();
		Figure fg = wc.getWinner(field);
		System.out.println("Winner is " + fg);
	}

	private Game createNewGame() {
		Player pl1 = new Player("Fed", Figure.X);
		Player pl2 = new Player("Mash", Figure.O);
		Player[] players = { pl1, pl2 };
		return new Game("XO", players);			
	}



}
