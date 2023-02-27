package states;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;

/*
 * This class represents the current state of the game. It's used to let the game know
 * which state you currently are in since you are able to switch between different states with this class.
 */

public class GameModel {

	private GameState currentState;
	
	public GameModel() {
		this.currentState = new MenuState(this);
	}

	public void switchState(GameState nextState) {
		currentState = nextState;
	}

	public void keyPressed(KeyEvent key) {
		currentState.keyPressed(key);
	}

	public void update() {
		currentState.update();
	}

	public void draw(GraphicsContext g) {
		currentState.draw(g);
	}
}
