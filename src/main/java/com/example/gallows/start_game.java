package com.example.gallows;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class start_game {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enter_game;

    @FXML
    private TextField he_is_word;

    @FXML
    void initialize() {
        enter_game.setOnAction(event -> {
            String user_word = he_is_word.getText();
            comparison(user_word,Entry.game_words);

        });

    }

    public void comparison(String user_word, String game_word) {
        int counter = 0;
        char[] word_user = user_word.toCharArray();
        char[] word_game = game_word.toCharArray();
        if (user_word.equals(game_word)) {
            System.out.println("win");
        } else {

            int j = 0;
            for (int i = 0; i < word_user.length; i++) {
                if (word_user[i] == word_game[j]) {
                    counter++;
                    j++;
                }
            }
        }
        System.out.println("Столько символов совпадают " + counter );
    }

}
