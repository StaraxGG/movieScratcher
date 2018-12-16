package A;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * An implementation of DiscoverScreen
 * in movieScratcher
 *
 * @author Nicolas
 * @version 1.0
 * @since 2018-Dez-11
 */
public class DiscoverScreen extends HBox implements Initializable {
    public VBox movieColumn;
    public ScrollPane scrollPane;

    public HBox header;
    public Button btnLists;
    public TextField txtSearch;
    public Button btnSearch;


    /* ---------------------------------------- Main ---------------------------------------------------------------- */



    /* ---------------------------------------- Attributes ---------------------------------------------------------- */



    /* ---------------------------------------- Constants ----------------------------------------------------------- */



    /* ---------------------------------------- Constructors -------------------------------------------------------- */

    public DiscoverScreen() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/fxml/discoverScreen.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }


    }

    public void initialize(URL location, ResourceBundle resources) {
        movieColumn.setOnScroll(new EventHandler<ScrollEvent>() {
            public void handle(ScrollEvent event) {
                double deltaY = event.getDeltaY()*6; // *6 to make the scrolling a bit faster
                double width = scrollPane.getContent().getBoundsInLocal().getWidth();
                double vvalue = scrollPane.getVvalue();
                scrollPane.setVvalue(vvalue + -deltaY/width); // deltaY/width to make the scrolling equally fast regardless of the actual width of the component
            }
        });

        btnSearch.setOnAction(event -> {
            Stage stage = new SearchResultsScreen(txtSearch.getText());
            stage.setTitle("My New Stage Title");
            stage.show();

            // Hide this current window (if this is what you want)
            //((Node)(event.getSource())).getScene().getWindow().hide();
        });

        movieColumn.getChildren().addAll(header);

        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }

    /**
     * Addes new Row with title bar to the DiscoverScreen
     * @param rowTitle  the row's heading
     * @param row   the row itself, with the corresponding movie data in it
     */

    public void addRow(String rowTitle, HorizontalBar row){
        Label title = new Label(rowTitle);
        movieColumn.getChildren().addAll(title, row);
    }

    /* ---------------------------------------- Methods ------------------------------------------------------------- */



    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */

}
