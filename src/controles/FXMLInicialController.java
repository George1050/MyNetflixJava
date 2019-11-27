/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

//import javafx.event.ActionEvent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import myDAO.UsuarioDAO;

public class FXMLInicialController{
    private UsuarioDAO u;
    @FXML
    private Button cadastrar, entrar;
    
    @FXML
    private TextField login;
    @FXML
    private PasswordField senha;
    @FXML
    private Label net;
    
    @FXML
    public void logar(ActionEvent event){
        u = new UsuarioDAO();
        String nome = login.getText();
        String pass = senha.getText();
        System.out.println(nome+ pass);
        boolean val = u.valiUser(nome, pass);
        if(val){
            mynetflix.MyNetflix.trocarTela("principal", null);
            cancelar(event);
        }
        
        
    }
    @FXML
    public void cadastrarNovoUsuario(ActionEvent event) {
        mynetflix.MyNetflix.trocarTela("cadastrar", null);
        
    }
    public void cancelar(ActionEvent event) {
        senha.clear();
        login.clear();
    }

    
}
