/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import modelos.Filme;
import modelos.Genero;
import modelos.Movie;
import modelos.Serie;
import myDAO.FilmeDAO;
import myDAO.SerieDAO;
import mynetflix.MyNetflix;

public class FXMLPrincipalController implements Initializable {
    private FilmeDAO f = new FilmeDAO();
    private SerieDAO s = new SerieDAO();
    @FXML
    private Label mynetflix;
    @FXML
    private Hyperlink filme;
    @FXML
    private Hyperlink serie;
    @FXML
    private TextField valPesquisa; 
    @FXML
    private Button pesquisar;
   
    @FXML
    private Button perfil;
    
    @FXML
    protected ListView<Movie> listaMovies;
    
    @FXML
    public void onMenuPerfil(ActionEvent e){
        MyNetflix.trocarTela("perfil");
    }
    
    public void initialize(){
        listaFilme();
        listaSerie();
    }
    
    private void atualizarLista(){
        listaMovies.getItems().clear();
        for(Movie list : f.listAll())
            listaMovies.getItems().add(list);
        
    }
    public void onClickFilme(ActionEvent a){
        listaFilme();
    }
    
    public void onClickSerie(ActionEvent a){
        listaSerie();
    }
    private void listaSerie(){
        listaMovies.getItems().clear();
        for(Serie list : s.listAll())
            listaMovies.getItems().add(list);
    }
    private void listaFilme(){
        listaMovies.getItems().clear();
        for(Filme list : f.listAll())
        listaMovies.getItems().add(list);
        
    }
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void cancelar(ActionEvent event) {
        valPesquisa.clear();
        
    }
}
