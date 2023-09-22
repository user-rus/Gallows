package com.example.gallows;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class game extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(game.class.getResource("Entry.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        InputStream iconStream = getClass().getResourceAsStream("gallows.png");
        Image image = new Image(iconStream);
        stage.getIcons().add(image);
        stage.setTitle("Gallows");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
