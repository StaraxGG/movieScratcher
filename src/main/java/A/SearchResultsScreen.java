package A;

/**
 * An implementation of SearchResultsScreen
 * in movieScratcher
 *TODO finish discoverypage
 * @author Nicolas
 * @version 1.0
 * @since 2018-Dez-16
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;

import B.MovieDBBasic;
import B.MovieFachklasse;
import C.MovieData;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class SearchResultsScreen extends Stage {

    Stage stage;

    public  SearchResultsScreen(String search){
        ScrollPane root = new ScrollPane();
        TilePane tile = new TilePane();
        root.setStyle("-fx-background-color: #081c24;");
        tile.setStyle("-fx-background-color: #081c24;");
        tile.setPadding(new Insets(15, 15, 15, 15));
        tile.setHgap(10);

        MovieFachklasse md = new MovieFachklasse();
        LinkedList<MovieDBBasic> searchResults = md.getResults(search);
        LinkedList<GridItem> gridItems = GUITools.getGridItems(searchResults);


        for (final GridItem file : gridItems) {

            tile.getChildren().addAll(file);
        }


        root.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // Horizontal
        root.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); // Vertical scroll bar
        root.setFitToWidth(true);
        root.setContent(tile);
        root.setPrefHeight(Double.MAX_VALUE);

        this.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
        this.setHeight(Screen.getPrimary().getVisualBounds()
                .getHeight());
        Scene scene = new Scene(root);
        this.setScene(scene);
    }

    private ImageView createImageView(final File imageFile) {
        // DEFAULT_THUMBNAIL_WIDTH is a constant you need to define
        // The last two arguments are: preserveRatio, and use smooth (slower)
        // resizing

        ImageView imageView = null;
        try {
            final Image image = new Image(new FileInputStream(imageFile), 150, 0, true,
                    true);
            imageView = new ImageView(image);
            imageView.setFitWidth(150);
            imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent mouseEvent) {

                    if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){

                        if(mouseEvent.getClickCount() == 2){
                            try {
                                BorderPane borderPane = new BorderPane();
                                ImageView imageView = new ImageView();
                                Image image = new Image(new FileInputStream(imageFile));
                                imageView.setImage(image);
                                imageView.setStyle("-fx-background-color: BLACK");
                                imageView.setFitHeight(stage.getHeight() - 10);
                                imageView.setPreserveRatio(true);
                                imageView.setSmooth(true);
                                imageView.setCache(true);
                                borderPane.setCenter(imageView);
                                borderPane.setStyle("-fx-background-color: BLACK");
                                Stage newStage = new Stage();
                                newStage.setWidth(stage.getWidth());
                                newStage.setHeight(stage.getHeight());
                                newStage.setTitle(imageFile.getName());
                                Scene scene = new Scene(borderPane,Color.BLACK);
                                newStage.setScene(scene);
                                newStage.show();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
            });
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return imageView;
    }
}