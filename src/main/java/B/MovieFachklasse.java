package B;

import C.MovieData;
import info.movito.themoviedbapi.model.MovieDb;
import javafx.scene.image.Image;

import java.io.FileNotFoundException;
import java.io.IOException;

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

    public Image getPoster(String movieName) {
        MovieDb mov = mData.getMovie(movieName);
        String posterKey = mov.getPosterPath();
        return new Image("https://image.tmdb.org/t/p/w500"+posterKey);
    }

    public Image getBackdrop(String movieName) {
        MovieDb mov = mData.getMovie(movieName);
        String posterKey = mov.getBackdropPath();
        return new Image("https://image.tmdb.org/t/p/w500"+posterKey);
    }

    public String getTitle(String movieName){
        MovieDb mov = mData.getMovie(movieName);
        return mov.getTitle();
    }

    public int getMovieYear(String movieName) {
        return 0;
    }


    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */

}
