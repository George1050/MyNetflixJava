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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelos.Usuario;
import myDAO.UsuarioDAO;

/**
 * FXML Controller class
 *
 * @author george
 */
public class CadastrarUsuarioController implements Initializable {

    private Usuario user;
    
    @FXML
    private Button ok, cancelar;

    @FXML
    private TextField login;

    @FXML
    private TextField senha;

    @FXML
    public void cancelarCadastro(ActionEvent event) {
        mynetflix.MyNetflix.trocarTela("inicial",null);
        cancelar(event);
    }
    @FXML
    public void cadastrarBD(ActionEvent event) {
        String nome = login.getText();
        String pass = senha.getText();
        user = new Usuario(nome, 1, pass);
        UsuarioDAO u = new UsuarioDAO();
        u.addUser(user);
        mynetflix.MyNetflix.trocarTela("inicial",null);
        cancelar(event);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void cancelar(ActionEvent event) {
        senha.clear();
        login.clear();
    }
    
}
