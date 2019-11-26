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

import modelos.Filme;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmeDAO {
    private final Conexao con = new Conexao();
    
    private final String ADDFILME = "INSERT INTO filme (nome, genero, duracao, sinopse) VALUES (?, ?, ?, ?)";
    private final String UPFILME = "UPDATE filme SET name = ?, genero = ?, duracao = ?, sinopse = ? WHERE nome = ?";
    private final String RMFILME = "DELETE FROM filme WHERE nome = ?";
    private final String LSFILME = "SELECT * FROM filme";
    private final String PFILME = "SELECT * FROM filme WHERE UPPER(nome) LIKE ?";
    private final String GETCOD = "SELECT COD_FILME FROM FILME WHERE NOME LIKE ?";
    
    public boolean addFilme(Filme f){
        try {
            //conectar ao banco e preparar a string do sql pelo objeto de PreparedStatement
            con.conecta();
            PreparedStatement sqlquery;
            
            sqlquery = con.getConexao().prepareStatement(ADDFILME);
            
            //atribuir os parâmetros que irão substituir os '?' das queries sql em ordem
            sqlquery.setString(1, f.getNome());            
            sqlquery.setInt(2, f.getGenero());         
            sqlquery.setString(3, f.getDuracao()); 
            sqlquery.setString(4, f.getSinopse()); 
            
            //executar
            sqlquery.execute();
            con.desconecta();
            return true;
        } catch (SQLException ex) {
            System.out.println("NÃO PODE CRIAR DOIS IGUAIS");
            return false;
        }
        
    }
    
    public boolean upFilme(Filme f){
        try{
            con.conecta();
            PreparedStatement sqlquery;
            sqlquery = con.getConexao().prepareStatement(UPFILME);
            sqlquery.setString(1, f.getNome());
            sqlquery.setInt(2, f.getGenero());
            sqlquery.setString(3, f.getDuracao());
            sqlquery.setString(4, f.getSinopse());
            sqlquery.setString(5, f.getNome());
            
            
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
            remover = con.getConexao().prepareStatement(RMFILME);
            remover.setString(1, nome);            
            remover.execute();           
            con.desconecta();
            return true;
        } catch(SQLException ex){
            System.err.println(ex);
            return false;
        }
    }
    
    public ArrayList<Filme> listAll(){
        ArrayList<Filme> lista = new ArrayList<>();
        try {
            con.conecta();
            PreparedStatement listar;
            listar = con.getConexao().prepareStatement(LSFILME);
            ResultSet rs = listar.executeQuery();
            while(rs.next()){
                Filme f = new Filme(rs.getInt("COD_FILME"), rs.getString("NOME"), rs.getInt("GENERO"), rs.getString("SINOPSE"), rs.getString("DURACAO"));
                lista.add(f);
            }
            System.out.println(lista);
            con.desconecta();
        } catch (SQLException ex){
            System.err.println(ex);            
        }
        return lista;
    }
    public ArrayList<Filme> searchFilme(){
        ArrayList<Filme> lista = new ArrayList<>();
        try {
            con.conecta();
            PreparedStatement listar;
            listar = con.getConexao().prepareStatement(PFILME);
            ResultSet rs = listar.executeQuery();
            while(rs.next()){
                Filme f = new Filme(rs.getString("NOME"), rs.getInt("GENERO"), rs.getString("SINOPSE"), rs.getString("DURACAO"));
                lista.add(f);
            }
            con.desconecta();
        } catch (SQLException ex){
            System.err.println(ex);            
        }
        return lista;
    } 
    public int getId(String nome){
        try {
            con.conecta();
            PreparedStatement buscarid;
            buscarid = con.getConexao().prepareStatement(GETCOD);
            //System.out.println("1");
            
            buscarid.setString(1, nome);
            //System.out.println("2");
            ResultSet rs = buscarid.executeQuery();
            //System.out.println("3");
            if(rs.next()){
                //System.out.println(rs.getInt("ID_USUARIO"));
                
                return rs.getInt("COD_FILME");
            }
            
        } catch (SQLException ex) {
            System.out.println("Exceção no getID");
            System.err.println(ex);
            
        }
        return 0;
    }
}