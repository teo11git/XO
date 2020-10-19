package xo.view;


import xo.model.*;
import java.awt.Point;
import xo.model.exceptions.*;
import java.util.Scanner;

public class ConsoleView {

	String greetings = "--- Welcome to tik-tak-toe game ---";
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
	
	public void greetings() {
		clearScreen();
		System.out.println(this.greetings);
	}

	public String askName() {
		System.out.println("Hi! What is your name?");
		
		Scanner in = new Scanner(System.in);
		in.useDelimiter("\n");


		while (!in.hasNext("[A-Za-z]+")) {
			System.out.println("Sorry, it must be only one word");
			in.next();
		}
		clearScreen();
		String name = in.next();
		System.out.println("Nice to meet you " + name);
		in.close();
		return name;
	}

	public Figure askFigure() {
		System.out.println("Please, choose your figure!" + "\n"+
			                "Type x or o");
	 
		Scanner scan = new Scanner(System.in);	
		while (!scan.hasNext("[XxYy]")) {
			System.out.println("Nope");
			scan.next();
		}
	    String figure = scan.next();
	    System.out.println("You have choose " + figure);

		switch (figure.toUpperCase()) {
			case "X":
				return Figure.X;
			case "Y":
				return Figure.O;
		}
		return null;

	}


	private void clearScreen() {
		String clearScreen = "\033[2J";
		String moveCursorUp = "\033[H";
		System.out.print(clearScreen + moveCursorUp);
	}
}
