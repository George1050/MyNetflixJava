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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import modelos.Filme;
import modelos.Genero;
import modelos.Serie;
import myDAO.FilmeDAO;
import myDAO.SerieDAO;
import mynetflix.MyNetflix;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class PerfilMenuController implements Initializable {
    
    private Filme f;
    private FilmeDAO filme = new FilmeDAO();
    private Serie s;
    private SerieDAO serie = new SerieDAO();
    
    @FXML
    private Hyperlink home;

    @FXML
    private TextField login;

    @FXML
    private TextField senha;

    @FXML
    private Button editarPefil;

    @FXML
    private TextField nomeFilme;

    @FXML
    private TextField duracao;

    @FXML
    private ComboBox<Genero> genero;

    @FXML
    private TextArea descricaoFilme;

    @FXML
    private Button enviarFilme;

    @FXML
    private Button cancelar;

    @FXML
    private TextField nomeSerie;

    @FXML
    private TextField numEpi;

    @FXML
    private ComboBox<?> genero1;

    @FXML
    private TextArea descricaoSerie;

    @FXML
    private Button enviarSerie;

    @FXML
    private Button cancelar1;

    @FXML
    private Button sair;
    @FXML
    public void cancelar(ActionEvent event) {
        nomeSerie.clear();
        nomeFilme.clear();
        numEpi.clear();
        descricaoSerie.clear();
        descricaoFilme.clear();
        duracao.clear();
        senha.clear();
        login.clear();
    }

    @FXML
    void cadastrarFilme(ActionEvent event) {
        String titulo = nomeFilme.getText();
        String dur = duracao.getText();
        String sinopse = descricaoFilme.getText();
        f = new Filme(titulo, 1, sinopse, dur);
        filme.addFilme(f);
        MyNetflix.trocarTela("principal",null);
        cancelar(event);
    }

    @FXML
    void cadastrarSerie(ActionEvent event) {
        String titulo = nomeSerie.getText();
        String num = numEpi.getText();
        int epi = Integer.parseInt(num);
        String sinopse = descricaoSerie.getText();
        s = new Serie(titulo, 2, sinopse, epi);
        serie.addSerie(s);
        MyNetflix.trocarTela("principal",null);
        cancelar(event);
    }

    

    @FXML
    void editarPerfilUsuario(ActionEvent event) {

    }

    @FXML
    void principal(ActionEvent event) {
        MyNetflix.trocarTela("principal",null);
    }

    @FXML
    void sairUsuario(ActionEvent event) {
        MyNetflix.trocarTela("inicial",null);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
