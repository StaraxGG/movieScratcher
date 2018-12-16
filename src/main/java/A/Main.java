package A;

import B.MovieDBBasic;
import B.MovieFachklasse;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.LinkedList;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage){

        MovieFachklasse f = new MovieFachklasse();
        Grid mainWindow = new Grid();

        LinkedList<MovieDBBasic> hp = f.getResults("Harry Potter");
        LinkedList<MovieDBBasic> bo = f.getResults("Bourne");
        LinkedList<MovieDBBasic> hdr = f.getResults("Herr der Ringe");
        GUITools.listToGrid(hp,mainWindow);



        primaryStage.setTitle("Hello World");
        ScrollPane main = new ScrollPane(mainWindow);
        main.setStyle("-fx-background-color: #081c24");


        HorizontalBar hbhp = new HorizontalBar(hp);

        HorizontalBar hb2 = new HorizontalBar(bo);
        HorizontalBar hb3 = new HorizontalBar(hdr);
/*
        final VBox netflix = new VBox(hbhp);

        final ScrollPane netflixScroll = new ScrollPane(netflix);

        netflix.setOnScroll(new EventHandler<ScrollEvent>() {
            public void handle(ScrollEvent event) {
                double deltaY = event.getDeltaY()*6; // *6 to make the scrolling a bit faster
                double width = netflixScroll.getContent().getBoundsInLocal().getWidth();
                double vvalue = netflixScroll.getVvalue();
                netflixScroll.setVvalue(vvalue + -deltaY/width); // deltaY/width to make the scrolling equally fast regardless of the actual width of the component
            }
        });


        netflixScroll.setFitToHeight(true);
        netflixScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        netflixScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);


        */
        DiscoverScreen discoverScreen = new DiscoverScreen();
        discoverScreen.addRow("Harry Potter",hbhp);
        discoverScreen.addRow("Bourne",hb2);
        discoverScreen.addRow("Harry Potter",hb3);

        primaryStage.setScene(new Scene(discoverScreen, -40, 900));
        //primaryStage.sizeToScene();
        //primaryStage.setMaxWidth(300);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
