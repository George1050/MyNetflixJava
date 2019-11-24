/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelos.Genero;
import myDAO.GeneroDAO;

public class FXMLPrincipalController {

    @FXML
    private Label mynetflix;
    @FXML
    private Hyperlink filme;
    @FXML
    private Hyperlink serie;
    @FXML
    private ComboBox genero;
    @FXML
    private TextField valPesquisa; 
    @FXML
    private Button pesquisar;
    @FXML
    public void listGenero(ActionEvent event){
        ArrayList<Genero> lista = new ArrayList<>();
        GeneroDAO g = new GeneroDAO();
        System.out.println(g.listAll());
    }
    
    
    
}
