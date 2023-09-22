package com.example.gallows;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Entry {
    public static String game_words;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button_exit;

    @FXML
    private Button button_game;

    @FXML
    void initialize() {
      button_exit.setOnAction(actionEvent ->{
          Stage stage =(Stage) button_exit.getScene().getWindow();
          stage.close();
      } );
      button_game.setOnAction(event -> {
          try {
              game_words= random_word();
              System.out.println(game_words);
          } catch (IOException e) {
              throw new RuntimeException(e);
          }
          button_game.getScene().getWindow().hide();
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource("start_game.fxml"));
          try {
              loader.load();
          } catch (IOException e) {
              e.printStackTrace();
          }
          Parent root = loader.getRoot();
          Stage stage = new Stage();
          stage.setTitle("Gallows");
          stage.setScene(new Scene(root));
          stage.showAndWait();

      });

    }
    private static String random_word() throws IOException {
        String fileName = "C:\\Users\\P14s\\IdeaProjects\\Gallows\\src\\main\\resources\\com\\example\\gallows\\Words.txt";
        BufferedReader reader = new BufferedReader(new InputStreamReader
                (new FileInputStream(fileName)));
        Random random = new Random();
        int randomNumber = random.nextInt(11650 - 1 + 1) + 1;
       // System.out.println(randomNumber);
        String word = "";
        String line;
        String[] words_all;
        int i = 0;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\W+");
            ++i;
            if (i == randomNumber) {
                word = line;
            }
        }
        //System.out.println(word);
        return word;
    }

}