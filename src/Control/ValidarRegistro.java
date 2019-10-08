/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Sistema;
import Entidad.Usuario;
import Frontera.FramePrincipal;

/**
 *
 * @author Miguel Alejandro
 */
public class ValidarRegistro {
 
      private Sistema sistema = FramePrincipal.sistema;
      
      
    public ValidarRegistro() {
        }
    
    public String verificarRegistro (Usuario usuario, String ValPassword){
        if (!verificarLongitudNombre(usuario.getNombre())){
            return("Longitud nombre incorrecta");
        }
        if (!verificarLongitudPassword(usuario.getPassword())){
            return("Longitud contraseña incorrecta");
        }
        if (!passwordsIguales(usuario.getPassword(), ValPassword)){
            return("Las contraseñas no coinciden");
        }
        return("Registro exitoso");
    }
    
    public boolean verificarLongitudNombre (String nombre){
        return (nombre.length() > 1 && nombre.length() <= 6);
    }
    
    public boolean verificarLongitudPassword (String password){
        return (password.length() >= 3 && password.length() < 6);
    }

    public boolean passwordsIguales (String password1, String password2){
        return (password1.equals(password2));
    }
}