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

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class AboutController {


    @FXML
    Hyperlink GNUlisc,JHahserLisc;

    @FXML
    private Stage Astage;


    @FXML
    private void ReturnBack(ActionEvent event)throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(JHasherMain.class.getResource("Home.fxml"));
        Astage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        Astage.setScene(scene);
        Astage.show();
    }

    @FXML
    public void OpenGNUlnk()throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.gnu.org/licenses/gpl-3.0.html"));
    }

    @FXML
    public void OpenJHasherLnk()throws  URISyntaxException, IOException{
        Desktop.getDesktop().browse(new URI("https://github.com/iharshpathak/J_Hasher"));
    }


}


