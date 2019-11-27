/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myDAO;

/**
 *
 * @author george
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author george
 */
public class Conexao {
    private static final String USUARIO = "george";
    private static final String SENHA = "1234";
    //INIT=runscript from '~/Documents/NetBeansProjects/MyNetflix/lib/SQL/banco.sql'
    private static final String CAMINHO = "jdbc:h2:~/jdbc/mynetflix;";
    private static final String DRIVER = "org.h2.Driver";
    private Connection conexao;
    
    public void conecta(){
        try{
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(CAMINHO, USUARIO, SENHA);
            System.out.println("Conectou!");
        } catch ( ClassNotFoundException  | SQLException e) {
            System.err.println(e);
        }
    }
    
    public void desconecta(){
        try{
            conexao.close();
            System.out.println("Desconectou!");
        }catch (SQLException ex){
            System.err.println(ex);
        }
    }
    
    public Connection getConexao(){
        return conexao;
    }
            
}
