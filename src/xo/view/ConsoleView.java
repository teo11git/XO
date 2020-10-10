package xo.view;


import xo.model.*;
import java.awt.Point;
import xo.model.exceptions.*;

public class ConsoleView {

	public void show(Game game) {
				
	}

	public void showField(Field field) {
		int i = 0;
		int j = 0;
		int amount = field.getSize() * field.getSize();
		int fieldSize = field.getSize();
		String line = "";


		while ( i < amount) {

			int x = i - j * fieldSize;
			int y = j;
			Point pnt = new Point(x, y);
			Figure fg = getFigureToPrint(field, pnt);
 	
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

	private Figure getFigureToPrint(Field field, Point point) {
		try {
			return  field.getFigure(point);
		} catch (InvalidCoordException e){
			System.out.println("OMG from ConsoleView");
			return null;
		}



	}

}
