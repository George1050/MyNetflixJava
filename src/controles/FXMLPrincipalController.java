/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import modelos.Filme;
import modelos.Genero;
import modelos.Movie;
import modelos.Serie;
import myDAO.FilmeDAO;
import myDAO.GeneroDAO;
import myDAO.SerieDAO;

public class FXMLPrincipalController {
    private FilmeDAO f = new FilmeDAO();
    private SerieDAO s = new SerieDAO();
    private GeneroDAO g = new GeneroDAO();
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
        
    }
    
    @FXML
    private ImageView config;
    
    @FXML
    protected ListView<Movie> listaMovies;
    @FXML
    protected ComboBox<Genero> listaGenero;

    
    public void initialize(){
        atualizarLista();
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
    
    
}
