package xo.controllers;

import xo.model.*;
import xo.model.exceptions.InvalidCoordException;
import xo.model.exceptions.AllreadyOccupiedException;
import java.awt.Point;

public class MoveController {

	public void applyFigure	(Field field,
							Figure figure,
							Point point) 
	throws AllreadyOccupiedException,
					InvalidCoordException {
		
		if (field.getFigure(point) != null) {
			throw new AllreadyOccupiedException();
		}

		field.setFigure(point, figure);	
	}
}
