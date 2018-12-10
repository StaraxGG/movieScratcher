package A;

import B.MovieDBBasic;
import javafx.scene.layout.FlowPane;

import java.util.LinkedList;

/**
 * An implementation of GUITools
 * in movieScratcher
 *
 * @author Nicolas
 * @version 1.0
 * @since 2018-Nov-30
 */
public class GUITools {

    /* ---------------------------------------- Main ---------------------------------------------------------------- */



    /* ---------------------------------------- Attributes ---------------------------------------------------------- */



    /* ---------------------------------------- Constants ----------------------------------------------------------- */



    /* ---------------------------------------- Constructors -------------------------------------------------------- */



    /* ---------------------------------------- Methods ------------------------------------------------------------- */

    public static LinkedList<GridItem> getGridItems(LinkedList<MovieDBBasic> mb){
        //todo change size
        LinkedList<GridItem> results = new LinkedList<GridItem>();
        int max = mb.size();
        for (int i=0; i<max; i++){
            GridItem gi = new GridItem();
            gi.setImgPoster(mb.get(i).getPoster());
            gi.setLblMovieTitle(mb.get(i).getName());
            gi.setLblReviews(mb.get(i).getReview());
            results.add(gi);
        }
        return results;
    }

    private static void fillGrid(LinkedList<GridItem> gr, Grid window){
        int i = 0;

        while(gr.size() > 2){
            window.getGridPane().addRow(i,gr.poll(),gr.poll(),gr.poll());
            i++;
        }
        if(gr.size() > 1){
            window.getGridPane().addRow(i,gr.poll(),gr.poll());
        }
        else if(gr.size() == 1){
            window.getGridPane().addRow(i,gr.poll());
        }
    }

    public static void listToGrid(LinkedList<MovieDBBasic> mb,Grid window){
        fillGrid(getGridItems(mb),window);
    }

    public static void listToFlow(LinkedList<MovieDBBasic> mb, FlowPane fl){
        LinkedList<GridItem> list = getGridItems(mb);
        fl.getChildren().addAll(list.get(0));
    }

    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */

}
