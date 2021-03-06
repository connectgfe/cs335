package model;

import java.awt.Point;
import java.util.Observable;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import map.Map;
import java.io.*;


public class SafariZone extends Observable implements Serializable{

	private Map theMap;

        private Point pLoc;

	public SafariZone() {
		theMap = new Map();
		startNewGame();
	}

	/**
	 * Start a new game and tell all observers to draw an new game with the string
	 * message startNewGame()
	 */
	public void startNewGame() {
		theMap = new Map();
		setChanged();
		notifyObservers("startNewGame()");
	}

	public Map getMap() {
		return theMap;
	}

	// Move Player
	public void movePlayer(char direction) {
		if (!gameOver()) {
			Point oldLoc = theMap.getTrainer().getCurrentLocation();
			Point newLoc = oldLoc;
			int newC = (int) newLoc.getX();
			int newR = (int) newLoc.getY();

			if (direction == 'U') {
				newR -= 1;
			} else if (direction == 'L') {
				newC -= 1;
			} else if (direction == 'R') {
				newC += 1;
			} else if (direction == 'D') {
				newR += 1;
			}

			newLoc = new Point(newC, newR);
                        pLoc = newLoc;
			theMap.updateTrainerLocation(oldLoc, newLoc);

			setChanged();
			notifyObservers();
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Game Over");
			alert.setHeaderText("You ran out of steps!");
			alert.setContentText("You caught " + theMap.getTrainer().getOwnedPokemonList().size() + " Pokemon");
			alert.showAndWait();
		}
	}

	public boolean gameOver() {
		if (theMap.getTrainer().getNumSteps() == 0) {
			return true;
		} else {
			return false;
		}
	}

        
        public Point getTrainerLoc(){

            return pLoc;

        }


}
