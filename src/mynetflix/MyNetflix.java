/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynetflix;


import java.util.ArrayList;
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
    private static Scene perfil;
    
    @Override
    public void start(Stage stage) throws Exception {
        stageInicial = stage;
        
        Parent principalTela = FXMLLoader.load(getClass().getResource("/telas/Principal.fxml"));
        principal = new Scene(principalTela);
        
        Parent inicialTela = FXMLLoader.load(getClass().getResource("/telas/Inicial.fxml"));
        inicial = new Scene(inicialTela);
        
        Parent cadastrarTela = FXMLLoader.load(getClass().getResource("/telas/CadastrarUsuario.fxml"));
        cadastrar = new Scene(cadastrarTela);
        
        Parent perfilMenu = FXMLLoader.load(getClass().getResource("/telas/PerfilMenu.fxml"));
        perfil = new Scene(perfilMenu);
        
        stageInicial.setScene(inicial);
        stageInicial.show();
    }
    
    public static void trocarTela(String tela, Object dados){
        switch(tela){
            case "inicial":
                stageInicial.setScene(inicial); 
                notificarMudancaTela("inicial", dados);
                break;
            case "principal":
                stageInicial.setScene(principal);
                notificarMudancaTela("pricipal",null);
                break;
            
            case "cadastrar":
                stageInicial.setScene(cadastrar);
                notificarMudancaTela("cadastrar", dados);
                break;
            case "perfil":
                stageInicial.setScene(perfil);
                notificarMudancaTela("perfil", dados);
                break;
        }
    }
    
    public static void trocarTela(String tela){
        switch(tela){
            case "inicial":
                stageInicial.setScene(inicial); 
                notificarMudancaTela("inicial", null);
                break;
            case "principal":
                stageInicial.setScene(principal);
                notificarMudancaTela("pricipal", null);
                break;
            
            case "cadastrar":
                stageInicial.setScene(cadastrar);
                notificarMudancaTela("cadastrar", null);
                break;
            case "perfil":
                stageInicial.setScene(perfil);
                notificarMudancaTela("perfil", null);
                break;
        }
    }
    public static void main(String[] args) {        
        launch(args);
    }
    
    //------------

    private static ArrayList<MudancaTela> listeners = new ArrayList<>();


    public static interface MudancaTela{
        
        void mundacaTelaParametro(String novaTela, Object dados);
        
    }
    
    private static void addMudancaTela(MudancaTela novaTela){
        listeners.add(novaTela);
    }
    
    private static void notificarMudancaTela(String novaTela, Object dados){
        for(MudancaTela n : listeners)
            n.mundacaTelaParametro(novaTela, dados);
    }
    
    
}
