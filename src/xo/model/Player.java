package xo.model;

public class Player {

	String name;

	Figure figure;

	public Player(String name, Figure figure) {
		this.name = name;
		this.figure = figure;
	}

	public String getName() {
		return name;
	}

	public Figure getFigure() {
		return figure;
	}

}
