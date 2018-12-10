package A;

import B.MovieDBBasic;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

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

        btnBack = new Button("<");
        btnForward = new Button(">");

        this.getChildren().add(btnBack);
        this.getChildren().add(movieBar);
        this.getChildren().add(btnForward);

        items = GUITools.getGridItems(movieList);
        max = items.size();

        for(int i = 0; i<2;i++){
            movieBar.getChildren().add(items.get(i));
        }


        btnForward.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                pushForward();
            }
        });

        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                pushBack();
            }
        });
    }


    /* ---------------------------------------- Methods ------------------------------------------------------------- */

    public void pushForward(){
        if(index+2 < max){
            movieBar.getChildren().clear();
            index++;
            for(int i = index; i<(index+2);i++){

                movieBar.getChildren().add(items.get(i));
            }
        }
    }

    public void pushBack(){
        if(index-1 >= 0){
            movieBar.getChildren().clear();
            index--;
            for(int i = index; i<(index+2);i++){
                movieBar.getChildren().add(items.get(i));
            }
        }
    }

    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */

}
