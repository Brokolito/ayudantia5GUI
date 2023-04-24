package data;

import model.Usuario;

import java.io.*;

public class GestorDatos {
	private String direccionArchivo;
	public GestorDatos(String direccionArchivo) {
		this.direccionArchivo=direccionArchivo;
	}

	public boolean registrarUsuario(Usuario usuario) {
		if(!noEsUsuarioRegistrado(usuario)){
			return false;
		}
		boolean lineaVacia=false;
		try{
			File archivo=new File(this.direccionArchivo);
			FileWriter fileWriter = new FileWriter(archivo, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			if (lineaVacia == false) {
				bufferedWriter.newLine();
			}
			//bufferedWriter.write(cliente.toString());
			bufferedWriter.write(usuario.getUsername()+","+usuario.getPassword());
			bufferedWriter.close();
			fileWriter.close();
			return true;
		}catch (Exception e){
			System.out.println("Error al ingresar hora de llegada, favor contactar con administrador");
			return false;
		}
	}
	public boolean noEsUsuarioRegistrado(Usuario usuario){
		String textoArchivo = "";
		try {
			File archivo = new File(this.direccionArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			// Comprobamos si existe
			FileReader fileReader = new FileReader(archivo);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			//Lee cada linea del archivo hasta que la linea sea nula
			while ((textoArchivo = bufferedReader.readLine()) != null) {
				String[] data = textoArchivo.split(",");
				if (data.length== 2 && usuario.getUsername().equals(data[0])) {
					fileReader.close();
					bufferedReader.close();
					return false;
				}
			}
			//Con eso corroboramos que el cliente no esta registrado por RUT
			fileReader.close();
			bufferedReader.close();
			return true;
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
	}

	public boolean loginUsuario(Usuario usuario) {
		String textoArchivo = "";
		try {
			File archivo = new File(this.direccionArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			// Comprobamos si existe
			FileReader fileReader = new FileReader(archivo);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			//Lee cada linea del archivo hasta que la linea sea nula
			while ((textoArchivo = bufferedReader.readLine()) != null) {
				String[] data = textoArchivo.split(",");
				if (usuario.getUsername().equals(data[0]) && usuario.getPassword().equals(data[1])) {
					fileReader.close();
					bufferedReader.close();
					return true;
				}
			}
			//Con eso corroboramos que el cliente no esta registrado por RUT
			fileReader.close();
			bufferedReader.close();
			return false;
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
	}
}