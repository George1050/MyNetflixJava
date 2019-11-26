/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author george
 */
public class Filme extends Movie{
    private String duracao;

    public Filme(int codigo, String nome, int genero, String sinopse, String duracao) {
        super(codigo, nome, genero, sinopse);
        this.duracao = duracao;
    }
    
     public Filme(String nome, int genero, String sinopse, String duracao) {
        super(nome, genero, sinopse);
        this.duracao = duracao;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDuração: " + duracao + " Minutos";
    }
    
}
