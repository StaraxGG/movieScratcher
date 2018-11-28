package B;

import javafx.scene.image.Image;

public interface Fachklasse {
    Image getPoster (String movieName);
    Image getBackdrop (String movieName);
    String getTitle (String movieName);
    int getMovieYear(String movieName);
}
