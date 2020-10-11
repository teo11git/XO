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

	private Game createNewGame() {
		Player pl1 = new Player("Fed", Figure.X);
		Player pl2 = new Player("Mash", Figure.O);
		Player[] players = { pl1, pl2 };
		return new Game("XO", players);			
	}



}
