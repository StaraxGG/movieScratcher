package B;

import C.MovieData;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import javafx.scene.image.Image;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * An implementation of B.MovieFachklasse
 * Implementierung einer Fachklasse
 * in movieScratcher
 *
 * @author Nicolas
 * @version 1.0
 * @since 2018-Nov-27
 */
public class MovieFachklasse implements Fachklasse {


    /* ---------------------------------------- A.Main ---------------------------------------------------------------- */
    MovieData mData = new MovieData();


    /* ---------------------------------------- Attributes ---------------------------------------------------------- */



    /* ---------------------------------------- Constants ----------------------------------------------------------- */



    /* ---------------------------------------- Constructors -------------------------------------------------------- */



    /* ---------------------------------------- Methods ------------------------------------------------------------- */


    public LinkedList<MovieDBBasic> getResults(String name){
         List<MovieDb> mrp = mData.searchMovies(name).getResults();
        LinkedList<MovieDBBasic> results = new LinkedList<MovieDBBasic>();

         int items = 10;
         if(mrp.size() < 10){
             items = mrp.size();
         }
         for(int i=0; i<items; i++){
             results.add(new MovieDBBasic(mrp.get(i)));
         }

         return results;
    }


    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */

}
