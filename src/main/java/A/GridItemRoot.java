package A;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * An implementation of GridItemRoot
 * in movieScratcher
 *
 * @author Nicolas
 * @version 1.0
 * @since 2018-Nov-27
 */
    public class GridItemRoot extends BorderPane implements Initializable {

    public Label lblMovieTitle;

    public ImageView imgPoster;

    public ImageView btnPlus;
    public ImageView btnStar;
    public ImageView btnCheck;

    public GridItemRoot() {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                    "/fxml/gridItemRoot.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);

            try {
                fxmlLoader.load();
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        }

    public void initialize(URL location, ResourceBundle resources) {
        btnPlus.setImage(new Image("add.png"));
        btnStar.setImage(new Image("star.png"));
        btnCheck.setImage(new Image("success.png"));
    }

    /**
     * Getter Title
      * @return
     */
    public String getLblMovieTitle() {
        return lblMovieTitle.getText();
    }

    /**
     * Setter Title
     * @param s
     */
    public void setLblMovieTitle(String s){
        lblMovieTitle.setText(s);
    }

    /**
     * Getter Poster
     * @return
     */
    public Image getImgPoster() {
        return imgPoster.getImage();
    }

    /**
     * Setter Poster
     * @param i
     */
    public void setImgPoster(Image i){
        imgPoster.setImage(i);
    }

    /**
     * TODO implement button logic
     * @return
     */
    public ImageView getBtnPlus() {
        return btnPlus;
    }

    public ImageView getBtnStar() {
        return btnStar;
    }

    public ImageView getBtnCheck() {
        return btnCheck;
    }

    @FXML
        protected void doSomething() {
            System.out.println("The button was clicked!");
        }
    }

