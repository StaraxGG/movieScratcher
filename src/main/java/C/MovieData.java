package C;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

import java.io.FileNotFoundException;

/**
 * An implementation of C.MovieData
 * in movieScratcher
 *
 * Klasse zur Datenanbindung.
 *
 * @author Nicolas
 * @version 1.0
 * @since 2018-Nov-27
 */
public class MovieData {

    private String apiKey = "652086fc44227443a5017d1f532898da";
    TmdbSearch search = new TmdbApi(apiKey).getSearch();
    /* ---------------------------------------- A.Main ---------------------------------------------------------------- */



    /* ---------------------------------------- Attributes ---------------------------------------------------------- */



    /* ---------------------------------------- Constants ----------------------------------------------------------- */



    /* ---------------------------------------- Constructors -------------------------------------------------------- */



    /* ---------------------------------------- Methods ------------------------------------------------------------- */

    /**
     * Returns url of the movie with the corresponding movie title.
     * @param movieTitle    search Title
     * @return  URL to movie cover
     * @throws FileNotFoundException
     */

    public MovieDb getMovie(String movieTitle){
        MovieResultsPage searchResults = search.searchMovie(movieTitle, null, "eng",true,0);
        return searchResults.getResults().get(0);
    }

    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */

}
