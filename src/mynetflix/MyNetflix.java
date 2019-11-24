/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynetflix;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author george
 */
public class MyNetflix extends Application {
   
    private static Stage stageInicial;
    
    private static Scene principal;
    private static Scene cadastrar;
    private static Scene inicial;
    
    @Override
    public void start(Stage stage) throws Exception {
        stageInicial = stage;
        
        Parent principalTela = FXMLLoader.load(getClass().getResource("/telas/Principal.fxml"));
        principal = new Scene(principalTela);
        
        Parent inicialTela = FXMLLoader.load(getClass().getResource("/telas/Inicial.fxml"));
        inicial = new Scene(inicialTela);
        
        Parent cadastrarTela = FXMLLoader.load(getClass().getResource("/telas/CadastrarUsuario.fxml"));
        cadastrar = new Scene(cadastrarTela);
        
        stageInicial.setScene(inicial);
        stageInicial.show();
    }
    
    public static void trocarTela(String tela){
        switch(tela){
            case "inicial":
                stageInicial.setScene(inicial); 
                break;
            case "principal":
                stageInicial.setScene(principal);
                break;
            case "cadastrar":
                stageInicial.setScene(cadastrar);
                break;
        }
    }
    public static void main(String[] args) {        
        launch(args);
    }
    
}
