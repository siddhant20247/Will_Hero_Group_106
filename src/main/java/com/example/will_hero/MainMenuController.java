package com.example.will_hero;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
    @FXML private AnchorPane scenePane;
    @FXML private ImageView newGameButton;
    @FXML private ImageView loadGameButton;
    @FXML private ImageView exitGameButton;
    @FXML private ImageView endlessButton;

    @FXML private AnchorPane loadMenu;
    @FXML private Text loadText;
    @FXML private Text cancelText;
    @FXML private ImageView closeMenuButton;



    private Stage stage;
    private Scene scene;
    private Parent root;

    public void exitGame(MouseEvent event) {
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }

    public void openLoadGame(MouseEvent event) throws IOException {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(loadMenu);
        transition.setDuration(Duration.millis(1000));
        transition.setByY(-516);
        transition.play();
    }

    public void cancelLoadGame(MouseEvent event) throws IOException {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(loadMenu);
        transition.setDuration(Duration.millis(1000));
        transition.setByY(516);
        transition.play();
    }

    public void loadGame(MouseEvent event) {
        Game game = new Game();
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("savedGames"));
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            game.loadGame(event, selectedFile.getPath());
        }
    }



    public void newGame(MouseEvent event) throws IOException {
        Game game = new Game();
        game.startGame(event);
    }

    public void newEndlessGame(MouseEvent event) throws IOException {
        Game game = new Game();
        game.startEndlessGame(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
