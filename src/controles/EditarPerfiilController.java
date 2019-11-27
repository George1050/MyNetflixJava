/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import myDAO.UsuarioDAO;
import mynetflix.MyNetflix;

/**
 * FXML Controller class
 *
 * @author georg
 */
public class EditarPerfiilController implements Initializable {
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    @FXML
    public void editarPerfilUsuario(ActionEvent e){        
        MyNetflix.trocarTela("perfil", "");
    }
}
