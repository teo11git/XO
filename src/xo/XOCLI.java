package xo;

import xo.model.*;
import xo.model.exceptions.*;
import xo.view.ConsoleView;
import xo.tests.Tests;
import java.awt.Point;

public class XOCLI {

	public static void main(final String[] args) {
		Tests test = new Tests();
		//test.testRandomMoveGen();
		//test.applyFigureTest();
		test.countFiguresTest();
	}
}
