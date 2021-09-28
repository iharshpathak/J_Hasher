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
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HFilesController implements Initializable {

    @FXML
    private Stage HFStage;

    @FXML
    private AnchorPane FvAnchorPane;

    @FXML
    private Label SAlLabel, selectAlLabel2, SFileLabel2;

    @FXML
    private TextArea myGenHash;

    @FXML
    private Label SFileLabel;

    @FXML
    private ChoiceBox<String> myFChoiceBox;
    private final String[] Algo={"MD2", "MD5", "SHA-1", "SHA-224", "SHA-256", "SHA-384", "SHA-512"};
    private String AVal="";

    private String filep="";

    public void FileC(){

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select The File");
        Stage stage =(Stage)FvAnchorPane.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        if(file!=null){
            filep=file.getAbsolutePath().replaceAll("\\\\", "\\\\\\\\");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myFChoiceBox.getItems().addAll(Algo);
        myFChoiceBox.setOnAction(this::GetHashVal);
    }

    public void GetHashVal(ActionEvent event){
        AVal=myFChoiceBox.getValue();
        SAlLabel.setText("");
        selectAlLabel2.setText("");
    }
    public void GetHashF(){
        Hasher hasherfile = new Hasher();
        if(AVal.equals("") && filep.equals("")){
            SFileLabel.setText("N o  F i l e  &");
            SFileLabel2.setText("A l g o r i t h m  S e l e c t e d ");
        }
        else if(filep.equals("")){
            SFileLabel.setText("N o  F i l e ");
            SFileLabel2.setText("S e l e c t e d");
        }
        else if(AVal.equals("")){
            SFileLabel.setText("N o  A l g o r i t h m");
            SFileLabel2.setText("S e l e c t e d");
        }
        else {
            myGenHash.setText(hasherfile.FileHasher(filep, AVal));
            SFileLabel.setText(AVal + "  H a s h ");
            SFileLabel2.setText("G e n e r a t e d");
        }
    }

    public void goBack(ActionEvent event)throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(JHasherMain.class.getResource("Home.fxml"));
        HFStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        HFStage.setScene(scene);
        HFStage.show();
    }
}
