package self.carson;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AlgoVisualizer extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Controller control = new Controller();
        control.setStyle("-fx-background-color: #EAEAEA");

        Scene scene = new Scene(control, Controller.WINDOW_WIDTH, Controller.WINDOW_HEIGHT);
        stage.setTitle("Algorithm Visualizer");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }
}