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

public class CFileController implements Initializable {


    @FXML
    private Stage CFStage;

    @FXML
    private TextArea MyTxtArea;

    @FXML
    private AnchorPane fChAnchorPane;

    @FXML
    private Label myLabl, myLabl2;
    @FXML
    private Label mySelLabel;

    @FXML
    private ChoiceBox<String> myAlgoChoiceBox;
    private final String[] Algosprsnt={"MD2", "MD5", "SHA-1", "SHA-224", "SHA-256", "SHA-384", "SHA-512"};
    private String AlVal="";

    private String filepath="";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myAlgoChoiceBox.getItems().addAll(Algosprsnt);
        myAlgoChoiceBox.setOnAction(this::getChoiceVal);
    }

    public void getChoiceVal(ActionEvent event){
        AlVal=myAlgoChoiceBox.getValue();
        mySelLabel.setText("");
    }

    public void FileChosr(){

        FileChooser fileChoosez = new FileChooser();
        fileChoosez.setTitle("Select File");
        Stage stage =(Stage)fChAnchorPane.getScene().getWindow();
        File filie = fileChoosez.showOpenDialog(stage);
        if(filie!=null){
            filepath=filie.getAbsolutePath().replaceAll("\\\\", "\\\\\\\\");
        }
    }
    public void GetHashF(){
        Hasher hasherf = new Hasher();
        String hshVal = MyTxtArea.getText();
        String genHash = hasherf.FileHasher(filepath,AlVal);
        if(filepath.equals("")){
            myLabl.setText("P l e a s e  S e l e c t");
            myLabl2.setText("A  F i l e ");
        }
        else if(AlVal.equals("")){
            myLabl.setText("N o  A l g o r i t h m");
            myLabl2.setText("S e l e c t e d");
        }
        else if(hshVal==null || hshVal.equals("")){
            myLabl.setText("P l e a s e  P r o v i d e  A");
            myLabl2.setText("P r o p e r  H a s h  V a l u e");
        }
        else if(genHash.equals(hshVal)){
            myLabl.setText("H a s h  M a t c h e d  !");
            myLabl2.setText("File Integrity is maintained !");
        }
        else {
            myLabl.setText("U n s a f e  F i l e  !");
            myLabl2.setText("H a s h  N o t  M a t c h e d  !");
        }

    }

    public void GoBackH(ActionEvent event)throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(JHasherMain.class.getResource("Home.fxml"));
        CFStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        CFStage.setScene(scene);
        CFStage.show();
    }
}
