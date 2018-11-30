package A;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * An implementation of Grid
 * in movieScratcher
 *
 * @author Nicolas
 * @version 1.0
 * @since 2018-Nov-30
 */
public class Grid extends BorderPane implements Initializable {

    public TextField txtSearch;
    public Button btnSearch;
    public GridPane layoutCenterGrid;

    /* ---------------------------------------- Main ---------------------------------------------------------------- */



    /* ---------------------------------------- Attributes ---------------------------------------------------------- */



    /* ---------------------------------------- Constants ----------------------------------------------------------- */



    /* ---------------------------------------- Constructors -------------------------------------------------------- */



    /* ---------------------------------------- Methods ------------------------------------------------------------- */

    public Grid() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/fxml/grid.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }


    public void initialize(URL location, ResourceBundle resources) {

    }

    public void addToGrid(Node node, int column, int row){
        layoutCenterGrid.add(node, column,row);
    }

    public GridPane getGridPane(){
        return layoutCenterGrid;
    }

    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */

}
