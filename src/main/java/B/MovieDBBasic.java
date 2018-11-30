package B;

import info.movito.themoviedbapi.model.MovieDb;
import javafx.scene.image.Image;

/**
 * An implementation of MovieDBBasic
 * in movieScratcher
 *
 * Used to simplify the use of the MovieDB class.
 *
 * @author Nicolas
 * @version 1.0
 * @since 2018-Nov-30
 */
public class MovieDBBasic {

    /* ---------------------------------------- Main ---------------------------------------------------------------- */

    private String name;
    private Image poster;
    private Image backdrop;
    private int movieID;

    private MovieDb movieDb;


    /* ---------------------------------------- Attributes ---------------------------------------------------------- */



    /* ---------------------------------------- Constants ----------------------------------------------------------- */



    /* ---------------------------------------- Constructors -------------------------------------------------------- */



    /* ---------------------------------------- Methods ------------------------------------------------------------- */

    public MovieDBBasic(MovieDb mdb){

        movieDb = mdb;

        name = mdb.getTitle();
        poster = new Image("https://image.tmdb.org/t/p/w500"+mdb.getPosterPath());
        backdrop = new Image("https://image.tmdb.org/t/p/w500"+mdb.getBackdropPath());
        movieID = mdb.getId();
    }

    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getPoster() {
        return poster;
    }

    public void setPoster(Image poster) {
        this.poster = poster;
    }

    public Image getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(Image backdrop) {
        this.backdrop = backdrop;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public MovieDb getMovieDb() {
        return movieDb;
    }

    public void setMovieDb(MovieDb movieDb) {
        this.movieDb = movieDb;
    }
}
