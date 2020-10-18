package xo.view;


import xo.model.*;
import java.awt.Point;
import xo.model.exceptions.*;
import java.util.Scanner;

public class ConsoleView {

	public void show(Game game) {

	}

	private void showField(Field field) 
			throws InvalidCoordException {
		int i = 0;
		int j = 0;
		int amount = field.getSize() * field.getSize();
		int fieldSize = field.getSize();
		String line = "";


		while ( i < amount) {

			int x = i - j * fieldSize;
			int y = j;
			Point pnt = new Point(x, y);
			Figure fg = field.getFigure(pnt);
 	
			if (fg != null) {
				line +=" " + fg + " ";	
			} else {
				line += "   ";
			}
			if (x + 1 != fieldSize) {
				line += "|";
			}
			i++;
			if (i % fieldSize == 0) {
				System.out.println(line);
				line = "";
				System.out.println("~~~~~~~~~");
				j++;
			}
		}
		System.out.println("---End of field---");
	}

	private void printLine(Field field) {

	}
	
	public String askName() {

	}
}
