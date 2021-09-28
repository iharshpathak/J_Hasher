/* J Hasher - A FOSS JavaFx Application For Hashing texts, Files & Validating hash of files.
    Copyright (C) 2021  Harsh Pathak

    J Hasher is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.*/

package com.jhasher.jhasher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HStringController implements Initializable {

    @FXML
    private Stage StriStage;

    @FXML
    private ChoiceBox<String> myChoiceBox;
    @FXML
    private TextField stringText;
    @FXML
    private final String[] Algos={"MD2", "MD5", "SHA-1", "SHA-224", "SHA-256", "SHA-384", "SHA-512"};

    @FXML
    private Label SLabel;

    private String Value="";

    @FXML
    private Label HLabel, HLabel2;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        myChoiceBox.getItems().addAll(Algos);
        myChoiceBox.setOnAction(this::getValue);
    }

    public void getValue(ActionEvent event){
        Value = myChoiceBox.getValue();
        SLabel.setText("");
    }

    public void SHashEvent(){
        String txt = stringText.getText();
        Hasher hasher = new Hasher();
        hasher.setValues(txt,Value);
        stringText.setText(hasher.ShHasher());
        if (Value.equals("")){
            HLabel.setText("P l e a s e  S e l e c t");
            HLabel2.setText("A n  A l g o r i t h m");
            stringText.setText("");
        }
        else if(txt.equals("")){
            HLabel.setText("P l e a s e  E n t e r");
            HLabel2.setText("A n y  T e x t");
            stringText.setText("");
        }
        else if(Value.equals("") && txt.equals("")){
            HLabel.setText("P l e a s e  E n t e r  T e x t");
            HLabel2.setText("&  S e l e c t  A n  A l g o r i t h m");
        }
        else{
            HLabel.setText(Value);
            HLabel2.setText("H a s h  G e n e r a t e d");
        }
    }

    public void GoBack(ActionEvent event)throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(JHasherMain.class.getResource("Home.fxml"));
        StriStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        StriStage.setScene(scene);
        StriStage.show();
    }
}
