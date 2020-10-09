package xo.model;

public class Game {

	final Player[] players;

	final Field field;

	final String name;

	public Game(final String name, 
				final Field field,
			    final Player[] players) {
		this.players = players;
		this.field = field;
		this.name = name;
	}

	public Player[] getPlayers() {
		return this.players;
	}

	public Field getField() {
		return this.field;
	}

	public String getName() {
		return this.name;
	}

}
