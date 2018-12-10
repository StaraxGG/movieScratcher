package A;

import B.MovieDBBasic;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.LinkedList;

/**
 * An implementation of HorizontalBar
 * in movieScratcher
 *
 * @author Nicolas
 * @version 1.0
 * @since 2018-Dez-10
 */
public class HorizontalBar extends HBox {

    /* ---------------------------------------- Main ---------------------------------------------------------------- */



    /* ---------------------------------------- Attributes ---------------------------------------------------------- */
    private int index = 0;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnForward;

    private LinkedList<GridItem> items;
    private int max;

    @FXML
    private HBox movieBar = new HBox();

    /* ---------------------------------------- Constants ----------------------------------------------------------- */



    /* ---------------------------------------- Constructors -------------------------------------------------------- */

    public HorizontalBar(LinkedList<MovieDBBasic> movieList){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/fxml/horizontalBar.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        items = GUITools.getGridItems(movieList);
        max = items.size();

        if(max<5){
            for(int i = 0; i<max;i++){
                movieBar.getChildren().add(items.get(i));
            }
        }
        for(int i = 0; i<5;i++){
            movieBar.getChildren().add(items.get(i));
        }

    }


    /* ---------------------------------------- Methods ------------------------------------------------------------- */

    public void pushForward(){
        index++;
        int endIndex = index + 5;

        if(endIndex < max){
            movieBar.getChildren().clear();
            for(int i = index; i<endIndex;i++){
                movieBar.getChildren().add(items.get(i));
            }
        }
        else if (!(max-index < 5)){
            movieBar.getChildren().clear();
            for(int i = index; i<(max);i++){

                movieBar.getChildren().add(items.get(i));
            }
        }
    }

    public void pushBack(){
        if(index-1 >= 0){
            movieBar.getChildren().clear();
            index--;
            for(int i = index; i<(index+5);i++){
                movieBar.getChildren().add(items.get(i));
            }
        }
    }

    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */

}
