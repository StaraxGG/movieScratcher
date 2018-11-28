package A;

import B.MovieFachklasse;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * An implementation of A.GridItemController
 * in movieScratcher
 *
 * @author Nicolas
 * @version 1.0
 * @since 2018-Nov-27
 */
public class GridItemController implements Initializable {
    public ImageView gridPoster;
    public ImageView buttonLinks;
    public ImageView buttonMitte;
    public ImageView buttonRechts;
    public Label label;
    public TextField searchBar;

    /* ---------------------------------------- A.Main ---------------------------------------------------------------- */

    public void initialize(URL location, ResourceBundle resources) {
        Image gridImage = new Image("file:///C:\\Users\\Nicolas\\Desktop\\movieScratcher\\src\\main\\resources\\poster.jpg");
        Image button1 = new Image("file:///C:\\Users\\Nicolas\\Desktop\\movieScratcher\\src\\main\\resources\\add.png");
        Image button2 = new Image("file:///C:\\Users\\Nicolas\\Desktop\\movieScratcher\\src\\main\\resources\\star.png");
        Image button3 = new Image("file:///C:\\Users\\Nicolas\\Desktop\\movieScratcher\\src\\main\\resources\\success.png");

        buttonLinks.setImage(button1);
        buttonMitte.setImage(button2);
        buttonRechts.setImage(button3);

        gridPoster.setImage(gridImage);

        label.setFont(new Font("Arial",40));


    }

    public void starClicked(MouseEvent mouseEvent) {
        buttonLinks.setVisible(false);
        String search = searchBar.getText();
        MovieFachklasse mf = new MovieFachklasse();

        gridPoster.setImage(mf.getPoster(search));
    }

    /* ---------------------------------------- Attributes ---------------------------------------------------------- */



    /* ---------------------------------------- Constants ----------------------------------------------------------- */



    /* ---------------------------------------- Constructors -------------------------------------------------------- */



    /* ---------------------------------------- Methods ------------------------------------------------------------- */



    /* ---------------------------------------- S/Getters ----------------------------------------------------------- */

}
