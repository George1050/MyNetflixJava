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

import modelos.Genero;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GeneroDAO {
    private final Conexao con = new Conexao();
    
    private final String ADDGENERO = "INSERT INTO genero (nome) VALUES (?)";
    private final String UPGENERO = "UPDATE genero SET nome = ? WHERE id_genero = ?";
    private final String RMGENERO = "DELETE FROM genero WHERE nome = ?";
    private final String LSGENERO = "SELECT * FROM genero";
    private final String GETID = "SELECT ID_GENERO FROM GENERO WHERE GENERO LIKE ?";
    
    public boolean addGenero(Genero u){
        try {
            //conectar ao banco e preparar a string do sql pelo objeto de PreparedStatement
            con.conecta();
            PreparedStatement sqlquery;
            
            sqlquery = con.getConexao().prepareStatement(ADDGENERO);
            
            //atribuir os parâmetros que irão substituir os '?' das queries sql em ordem
            sqlquery.setString(1, u.getNome());
            
            //executar
            sqlquery.execute();
            con.desconecta();
            return true;
        } catch (SQLException ex) {
            System.out.println("NÃO PODE CRIAR DOIS IGUAIS");
            return false;
        }
        
    }
    
    public boolean updateUser(Genero u){
        try{
            con.conecta();
            PreparedStatement sqlquery;
            sqlquery = con.getConexao().prepareStatement(UPGENERO);
            sqlquery.setString(1, u.getNome()); 
            
            sqlquery.execute();
            
            con.desconecta();
            return true;
        } catch (SQLException ex){
            System.out.println("Exceção no update");
            System.err.println(ex);
            return false;
        }
    }
    
    public boolean removeUser(String nome){
        try {
            con.conecta();
            PreparedStatement remover;            
            remover = con.getConexao().prepareStatement(RMGENERO);
            remover.setString(1, nome);            
            remover.execute();           
            con.desconecta();
            return true;
        } catch(SQLException ex){
            System.err.println(ex);
            return false;
        }
    }
    
    public ArrayList<Genero> listAll(){
        ArrayList<Genero> lista = new ArrayList<>();
        try {
            con.conecta();
            PreparedStatement listar;
            listar = con.getConexao().prepareStatement(LSGENERO);
            ResultSet rs = listar.executeQuery();
            while(rs.next()){
                Genero g = new Genero(rs.getInt("ID_GENERO"),rs.getString("NOME"));
                lista.add(g);
            }
            System.out.println(lista);
            con.desconecta();
        } catch (SQLException ex){
            System.err.println(ex);            
        }
        return lista;
    }
    
    public int getId(String genero){
        try {
            con.conecta();
            PreparedStatement buscarid;
            buscarid = con.getConexao().prepareStatement(GETID);
            //System.out.println("1");
            
            buscarid.setString(1, genero);
            //System.out.println("2");
            ResultSet rs = buscarid.executeQuery();
            //System.out.println("3");
            if(rs.next()){
                //System.out.println(rs.getInt("ID_USUARIO"));
                
                return rs.getInt("ID_GENERO");
            }
            
        } catch (SQLException ex) {
            System.out.println("Exceção no getID");
            System.err.println(ex);
            
        }
        return 0;
    }
    
}
