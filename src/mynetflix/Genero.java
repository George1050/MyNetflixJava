/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynetflix;

/**
 *
 * @author georg
 */
public class Genero {
    private int id_genero;
    private String nome;

    public Genero(String nome) {
        this.nome = nome;
    }

    public Genero(int id_genero, String nome) {
        this.id_genero = id_genero;
        this.nome = nome;
    }

    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Genero{" + "id_genero=" + id_genero + ", nome=" + nome + '}';
    }
        
}
