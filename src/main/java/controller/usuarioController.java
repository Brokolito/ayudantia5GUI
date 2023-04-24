package controller;

import model.Usuario;

public class usuarioController {

	public usuarioController() {
	}

	public boolean register(Usuario usuario) {
		boolean results=usuario.registrarUsuario();
		return results;
	}

	public boolean login(String username, String password) {
		 boolean results=new Usuario(username,password).loginUsuario();
		 return  results;
	}
}