/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynetflix;

import netflixDAO.UsuarioDAO;

/**
 *
 * @author george
 */
public class Teste {
    public static void main(String[] args) {
        Usuario c = new Usuario("George",2,"1234");
        UsuarioDAO user;
        user = new UsuarioDAO();
        user.updateUser(c);
        user.listAll();
    }
}
