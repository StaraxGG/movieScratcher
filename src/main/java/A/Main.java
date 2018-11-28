package A;

import B.MovieFachklasse;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //FXMLLoader loader = new FXMLLoader();
        //loader.setLocation(getClass().getResource("/Grid.fxml"));
        //loader.setController(new A.MovieController());

        //Parent root = loader.load();

        MovieFachklasse f = new MovieFachklasse();
        GridPane mainWindow = new GridPane();


        GridItemRoot fightclub = new GridItemRoot();
        fightclub.setImgPoster(f.getPoster("Fight Club"));
        fightclub.setLblMovieTitle(f.getTitle("Fight Club"));
        mainWindow.add(fightclub,0,0);

        GridItemRoot americanhustle = new GridItemRoot();
        americanhustle.setImgPoster(f.getPoster("american hustle"));
        americanhustle.setLblMovieTitle(f.getTitle("american hustle"));
        mainWindow.add(americanhustle,1,0);

        GridItemRoot departed = new GridItemRoot();
        departed.setImgPoster(f.getPoster("departed"));
        departed.setLblMovieTitle(f.getTitle("departed"));
        mainWindow.add(departed,2,0);

        GridItemRoot fightclub2 = new GridItemRoot();
        fightclub2.setImgPoster(f.getPoster("Fight Club"));
        fightclub2.setLblMovieTitle(f.getTitle("Fight Club"));
        mainWindow.add(fightclub2,0,1);

        GridItemRoot americanhustle2 = new GridItemRoot();
        americanhustle2.setImgPoster(f.getPoster("american hustle"));
        americanhustle2.setLblMovieTitle(f.getTitle("american hustle"));
        mainWindow.add(americanhustle2,1,1);

        GridItemRoot departed2 = new GridItemRoot();
        departed2.setImgPoster(f.getPoster("departed"));
        departed2.setLblMovieTitle(f.getTitle("departed"));
        mainWindow.add(departed2,2,1);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(mainWindow, -40, -40));
        //primaryStage.sizeToScene();
        //primaryStage.setMaxWidth(300);
        //primaryStage.setResizable(false);
        primaryStage.show();
    }



    public void start2(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/gridItem.fxml"));
        //loader.setController(new A.MovieController());

        Parent root = loader.load();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, -40, -40));
        primaryStage.sizeToScene();
        primaryStage.setMaxWidth(300);
        primaryStage.setResizable(false);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
