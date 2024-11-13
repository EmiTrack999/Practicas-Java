package Controlador;

import java.util.regex.Pattern;

public class Modelo {
String correo,contraseña,confir;
public String getConfir() {
	return confir;
}

public void setConfir(String confir) {
	this.confir = confir;
}

int id;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCorreo() {
	return correo;
}

public void setCorreo(String correo) {
	this.correo = correo;
}

public String getContraseña() {
	return contraseña;
}

public void setContraseña(String contraseña) {
	this.contraseña = contraseña;
}
public boolean validarCorreo(String correo) {
    String email = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    Pattern EMAIL_PATTERN = Pattern.compile(email);
    return correo != null && !correo.isEmpty() && EMAIL_PATTERN.matcher(correo).matches();
}
public boolean validarTelefono(String telefono) {
    String telefonoRegex = "^[0-9]{10}$"; 
    Pattern TELEFONO_PATTERN = Pattern.compile(telefonoRegex);
    return telefono != null && !telefono.isEmpty() && TELEFONO_PATTERN.matcher(telefono).matches();
}
}
