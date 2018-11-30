package A;

import B.MovieDBBasic;

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

    private static LinkedList<GridItem> getGridItems(LinkedList<MovieDBBasic> mb){
        //todo change size
        LinkedList<GridItem> results = new LinkedList<GridItem>();
        for (int i=0; i<10; i++){
            GridItem gi = new GridItem();
            gi.setImgPoster(mb.get(i).getPoster());
            gi.setLblMovieTitle(mb.get(i).getName());
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

    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */

}
