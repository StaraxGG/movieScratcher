package A;

import B.MovieFachklasse;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage){

        MovieFachklasse f = new MovieFachklasse();
        Grid mainWindow = new Grid();


        GridItem fightclub = new GridItem();
        fightclub.setImgPoster(f.getPoster("Fight Club"));
        fightclub.setLblMovieTitle(f.getTitle("Fight Club"));
        mainWindow.addToGrid(fightclub,0,0);

        GridItem americanhustle = new GridItem();
        americanhustle.setImgPoster(f.getPoster("american hustle"));
        americanhustle.setLblMovieTitle(f.getTitle("american hustle"));
        mainWindow.addToGrid(americanhustle,1,0);

        GridItem departed = new GridItem();
        departed.setImgPoster(f.getPoster("departed"));
        departed.setLblMovieTitle(f.getTitle("departed"));
        mainWindow.addToGrid(departed,2,0);

        GridItem fightclub2 = new GridItem();
        fightclub2.setImgPoster(f.getPoster("Fight Club"));
        fightclub2.setLblMovieTitle(f.getTitle("Fight Club"));
        mainWindow.addToGrid(fightclub2,0,1);

        GridItem americanhustle2 = new GridItem();
        americanhustle2.setImgPoster(f.getPoster("american hustle"));
        americanhustle2.setLblMovieTitle(f.getTitle("american hustle"));
        mainWindow.addToGrid(americanhustle2,1,1);

        GridItem departed2 = new GridItem();
        departed2.setImgPoster(f.getPoster("departed"));
        departed2.setLblMovieTitle(f.getTitle("departed"));
        mainWindow.addToGrid(departed2,2,1);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(new ScrollPane(mainWindow), -40, -40));
        //primaryStage.sizeToScene();
        //primaryStage.setMaxWidth(300);
        //primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
