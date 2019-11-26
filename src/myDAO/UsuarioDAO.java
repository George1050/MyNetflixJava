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
import modelos.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {
    private final Conexao con = new Conexao();
    
    private final String ADDUSER = "INSERT INTO usuario (login, prioridade, senha) VALUES (?, ?, ?)";
    private final String UPDATEUSER = "UPDATE usuario SET login = ?, prioridade = ?, senha = ? WHERE login = ?";
    private final String RMUSER = "DELETE FROM usuario WHERE login = ?";
    private final String LISTUSER = "SELECT * FROM usuario";
    private final String VUSER = "SELECT * FROM USUARIO WHERE LOGIN = ? AND SENHA = ?";
    private final String SEARCHUSER = "SELECT * FROM usuario WHERE UPPER(login) LIKE '?'";
    private final String GETID = "SELECT ID_USUARIO FROM USUARIO WHERE LOGIN LIKE '?'";
    
    public boolean addUser(Usuario u){
        try {
            //conectar ao banco e preparar a string do sql pelo objeto de PreparedStatement
            con.conecta();
            PreparedStatement sqlquery;
            
            sqlquery = con.getConexao().prepareStatement(ADDUSER);
            
            //atribuir os parâmetros que irão substituir os '?' das queries sql em ordem
            sqlquery.setString(1, u.getLogin());            
            sqlquery.setInt(2, u.getPrioridade());         
            sqlquery.setString(3, u.getSenha()); 
            
            //executar
            sqlquery.execute();
            con.desconecta();
            return true;
        } catch (SQLException ex) {
            System.out.println("NÃO PODE CRIAR DOIS IGUAIS");
            return false;
        }
        
    }
    
    public boolean updateUser(Usuario u){
        try{
            con.conecta();
            PreparedStatement sqlquery;
            sqlquery = con.getConexao().prepareStatement(UPDATEUSER);
            sqlquery.setString(1, u.getLogin());
            sqlquery.setInt(2, u.getPrioridade());
            sqlquery.setString(3, u.getSenha());
            sqlquery.setString(4, u.getLogin());  
            
            sqlquery.execute();
            
            con.desconecta();
            return true;
        } catch (SQLException ex){
            System.out.println("Exceção no update");
            System.err.println(ex);
            return false;
        }
    }
    
    public boolean removeUser(String login){
        try {
            con.conecta();
            PreparedStatement remover;            
            remover = con.getConexao().prepareStatement(RMUSER);
            remover.setString(1, login);            
            remover.execute();           
            con.desconecta();
            return true;
        } catch(SQLException ex){
            System.err.println(ex);
            return false;
        }
    }
    public boolean valiUser(String login, String senha){
        try {
            con.conecta();
            PreparedStatement validar;            
            validar = con.getConexao().prepareStatement(VUSER);
            validar.setString(1, login);   
            validar.setString(2, senha);     
            validar.execute();           
            con.desconecta();
            return true;
        } catch(SQLException ex){
            System.err.println(ex);
            return false;
        }
    }
    
    public ArrayList<Usuario> listAll(){
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            con.conecta();
            PreparedStatement listar;
            listar = con.getConexao().prepareStatement(LISTUSER);
            ResultSet rs = listar.executeQuery();
            while(rs.next()){
                Usuario user = new Usuario(rs.getInt("ID_USUARIO"), rs.getString("LOGIN"), rs.getInt("PRIORIDADE"), rs.getString("SENHA"));
                lista.add(user);
            }
            System.out.println(lista);
            con.desconecta();
        } catch (SQLException ex){
            System.err.println(ex);            
        }
        return lista;
    }
    public ArrayList<Usuario> searchUser(){
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            con.conecta();
            PreparedStatement listar;
            listar = con.getConexao().prepareStatement(SEARCHUSER);
            ResultSet rs = listar.executeQuery();
            while(rs.next()){
                Usuario user = new Usuario(rs.getString("LOGIN"),rs.getInt("PRIORIDADE"), rs.getString("SENHA"));
                lista.add(user);
            }
            con.desconecta();
        } catch (SQLException ex){
            System.err.println(ex);            
        }
        return lista;
    } 
    public int getId(String login){
        try {
            con.conecta();
            PreparedStatement buscarid;
            buscarid = con.getConexao().prepareStatement(GETID);
            //System.out.println("1");
            
            buscarid.setString(1, login);
            //System.out.println("2");
            ResultSet rs = buscarid.executeQuery();
            //System.out.println("3");
            if(rs.next()){
                //System.out.println(rs.getInt("ID_USUARIO"));
                
                return rs.getInt("ID_USUARIO");
            }
            
        } catch (SQLException ex) {
            System.out.println("Exceção no getID");
            System.err.println(ex);
            
        }
        return 0;
    }
}