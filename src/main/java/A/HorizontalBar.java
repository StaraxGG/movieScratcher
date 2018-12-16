package A;

import B.MovieDBBasic;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

/**
 * An implementation of HorizontalBar
 * in movieScratcher
 *
 * @author Nicolas
 * @version 1.0
 * @since 2018-Dez-10
 */
public class HorizontalBar extends HBox implements Initializable {

    /* ---------------------------------------- Main ---------------------------------------------------------------- */



    /* ---------------------------------------- Attributes ---------------------------------------------------------- */
    private int index = 0;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnForward;

    private LinkedList<MovieDBBasic> movieList;
    private LinkedList<GridItem> gridItemList;

    private ObservableQueue observableQueue;


    private int max;

    @FXML
    private HBox movieBar = new HBox();

    /* ---------------------------------------- Constants ----------------------------------------------------------- */



    /* ---------------------------------------- Constructors -------------------------------------------------------- */

    public HorizontalBar(LinkedList<MovieDBBasic> movieList){
        super();
        this.movieList = movieList;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/fxml/horizontalBar.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }



    }

    //if private @fxml is required
    public void initialize(URL location, ResourceBundle resources) {
        gridItemList = GUITools.getGridItems(movieList);
        max = gridItemList.size();

        observableQueue = new ObservableQueue(gridItemList);

        movieBar.getChildren().addAll(observableQueue.getDisplayedList());
    }

    /* ---------------------------------------- Methods ------------------------------------------------------------- */

    public void pushForward(){
        movieBar.getChildren().clear();
        movieBar.getChildren().addAll(observableQueue.push());
    }

    //todo fix the STILL weired stuff
    public void pushBack(){
        movieBar.getChildren().clear();
        movieBar.getChildren().addAll(observableQueue.pop());
    }

    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */

}
