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

import modelos.Serie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SerieDAO {
    private final Conexao con = new Conexao();
    
    private final String ADDSERIE = "INSERT INTO serie (nome, genero, num_epi, sinopse) VALUES (?, ?, ?, ?)";
    private final String UPSERIE = "UPDATE serie SET name = ?, genero = ?, num_epi = ?, sinopse = ? WHERE nome = ?";
    private final String RMSERIE = "DELETE FROM serie WHERE nome = ?";
    private final String LSSERIE = "SELECT * FROM serie";
    private final String PSERIE = "SELECT * FROM serie WHERE UPPER(nome) LIKE ?";
    private final String GETCOD = "SELECT COD_SERIE FROM SERIE WHERE nome LIKE ?";
    
    public boolean addSerie(Serie f){
        try {
            //conectar ao banco e preparar a string do sql pelo objeto de PreparedStatement
            con.conecta();
            PreparedStatement sqlquery;
            
            sqlquery = con.getConexao().prepareStatement(ADDSERIE);
            
            //atribuir os parâmetros que irão substituir os '?' das queries sql em ordem
            sqlquery.setString(1, f.getNome());            
            sqlquery.setInt(2, f.getGenero()); 
            sqlquery.setInt(3, f.getNum_epi()); 
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
    
    public boolean upSerie(Serie f){
        try{
            con.conecta();
            PreparedStatement sqlquery;
            sqlquery = con.getConexao().prepareStatement(UPSERIE);
            sqlquery.setString(1, f.getNome());
            sqlquery.setInt(2, f.getGenero());
            sqlquery.setInt(3, f.getNum_epi()); 
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
            remover = con.getConexao().prepareStatement(RMSERIE);
            remover.setString(1, nome);            
            remover.execute();           
            con.desconecta();
            return true;
        } catch(SQLException ex){
            System.err.println(ex);
            return false;
        }
    }
    
    public ArrayList<Serie> listAll(){
        ArrayList<Serie> lista = new ArrayList<>();
        try {
            con.conecta();
            PreparedStatement listar;
            listar = con.getConexao().prepareStatement(LSSERIE);
            ResultSet rs = listar.executeQuery();
            while(rs.next()){
                Serie f = new Serie(rs.getInt("COD_SERIE"), rs.getString("NOME"), rs.getInt("GENERO"), rs.getString("SINOPSE"), rs.getInt("NUM_EPI"));
                lista.add(f);
            }
            System.out.println(lista);
            con.desconecta();
        } catch (SQLException ex){
            System.err.println(ex);            
        }
        return lista;
    }
    public ArrayList<Serie> searchSerie(){
        ArrayList<Serie> lista = new ArrayList<>();
        try {
            con.conecta();
            PreparedStatement listar;
            listar = con.getConexao().prepareStatement(PSERIE);
            ResultSet rs = listar.executeQuery();
            while(rs.next()){
                Serie f = new Serie(rs.getString("NOME"), rs.getInt("GENERO"), rs.getString("SINOPSE"), rs.getInt("NUM_EPI"));
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
                
                return rs.getInt("COD_SERIE");
            }
            
        } catch (SQLException ex) {
            System.out.println("Exceção no getID");
            System.err.println(ex);
            
        }
        return 0;
    }
}