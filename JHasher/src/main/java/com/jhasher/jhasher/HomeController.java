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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HomeController {

    @FXML
    Hyperlink DevLnk;

    @FXML
    private Stage sstage;


    public void LoadAbout(ActionEvent event)throws IOException{

        FXMLLoader fxmlLoader = new FXMLLoader(JHasherMain.class.getResource("About.fxml"));
        sstage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        sstage.setScene(scene);
        sstage.show();
    }


    public void loadHString(ActionEvent event)throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(JHasherMain.class.getResource("HString.fxml"));
        sstage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        sstage.setScene(scene);
        sstage.show();
    }

    public void loadHFiles(ActionEvent event)throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(JHasherMain.class.getResource("HFiles.fxml"));
        sstage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        sstage.setScene(scene);
        sstage.show();
    }

    public void loadCHFiles(ActionEvent event)throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(JHasherMain.class.getResource("CFile.fxml"));
        sstage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        sstage.setScene(scene);
        sstage.show();
    }

    @FXML
    private void OpenDevLnk()throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://github.com/iharshpathak"));
    }

}