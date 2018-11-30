package A;

import B.MovieDBBasic;
import B.MovieFachklasse;
import com.sun.jmx.remote.internal.ArrayQueue;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.LinkedList;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage){

        MovieFachklasse f = new MovieFachklasse();
        Grid mainWindow = new Grid();

        LinkedList<MovieDBBasic> hp = f.getResults("Harry Potter");
        GUITools.listToGrid(hp,mainWindow);


        primaryStage.setTitle("Hello World");
        ScrollPane main = new ScrollPane(mainWindow);
        main.setStyle("-fx-background-color: #081c24");

        primaryStage.setScene(new Scene(main, -40, -40));
        primaryStage.sizeToScene();
        //primaryStage.setMaxWidth(300);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
