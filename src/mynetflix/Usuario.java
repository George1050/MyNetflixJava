/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynetflix;

/**
 *
 * @author george
 */
public class Usuario {
    private int id;
    private String login;
    private int prioridade;
    private String senha;

    public Usuario(String login, int prioridade, String senha) {
        this.login = login;
        this.prioridade = prioridade;
        this.senha = senha;
    }
    public Usuario(int id, String login, int prioridade, String senha){
        this.id = id;
        this.login = login;
        this.prioridade = prioridade;
        this.senha = senha; 
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }    

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", login=" + login + ", prioridade=" + prioridade + ", senha=" + senha + '}';
    }
    
    
}
