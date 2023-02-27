package main;

import states.GameModel;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/* This class is where you start out. It's the entry of the game and it creates the GameModel, GameFrame, GamePanel and the main loop of the game. 
 */
public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage gameStage) throws Exception {
		gameStage.setTitle("Kingdom Vindication");
		gameStage.setWidth(1920);
		gameStage.setHeight(1080);
		GameModel model = new GameModel();
		GameFrame frame = new GameFrame(model, 1920, 1080);
		Scene gameScene = new Scene(frame);

		final double targetFps = 50.0;

		final double nanoPerUpdate = 1000000000.0 / targetFps;

		gameStage.setScene(gameScene);

		gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {

				model.keyPressed(event);
			}
		});

		new AnimationTimer() {
			long lastUpdate = 0;

			public void handle(long now) {

				if ((now - lastUpdate) > nanoPerUpdate) {
					model.update();
					frame.repaint();
					lastUpdate = now;
				}
			}
		}.start();

		gameStage.show();
	}
}
