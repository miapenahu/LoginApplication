/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Usuario;
import static Frontera.FramePrincipal.sistema;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MIGUEL ALEJANDRO
 */
public class TestRegistro {

    private static ValidarRegistro validarRegistro = new ValidarRegistro();    
    
    private String LONG_NOMBRE_INCORRECTA = "Longitud nombre incorrecta";
    private String LONG_PASSWORD_INCORRECTA = "Longitud contraseña incorrecta";
    private String PASSWORDS_DIFERENTES = "Las contraseñas no coinciden";
    private String NOMBRE_REPETIDO = "El usuario con el nombre ingresado ya existe";
    private String SUCCESS = "Registro exitoso";

    public TestRegistro() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
             
        /*
        * * Creamos el arreglo: Nacesitamos importar la clase
        *   ArrayList y la clase entidad.Usuario
        */
        
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    
        /*
        * Creamos los usuarios
        */
        
        Usuario a = new Usuario();
        Usuario b = new Usuario();
        Usuario c = new Usuario();
        /*
        * Proveemos nombres y contraseñas
        */
        
        a.setNombre("juan");
        a.setPassword("1234");
        b.setNombre("pedro");
        b.setPassword("123");
        c.setNombre("maria");
        c.setPassword("12345");
        
        /*
        * Agregamos al arreglo
        */
        
        usuarios.add(a);
        usuarios.add(b);
        usuarios.add(c);
        
        /*
        /* Le asignamos el arreglo usuarios a la variable de clase "sistema"
        */
        sistema.setUsuarios(usuarios);
        
        for(Usuario u: sistema.getUsuarios()){
            System.out.println(u.getNombre());
            System.out.println(u.getPassword());
            System.out.println("------------");    
        }
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testLongitudNombre(){
     Usuario u = new Usuario();
        u.setNombre("mauricio");
        u.setPassword("abcdef");
        String val = "abcdef"; 
        assertEquals(LONG_NOMBRE_INCORRECTA, validarRegistro.verificarRegistro(u,val));

        u.setNombre("m");
        u.setPassword("abcdef");
        val = "abcdef"; 
        assertEquals(LONG_NOMBRE_INCORRECTA, validarRegistro.verificarRegistro(u,val));
    }
    
    @Test
    public void testLongitudContrasenia(){
     Usuario u = new Usuario();
        u.setNombre("Bob");
        u.setPassword("a");
        String val = "a"; 
        assertEquals(LONG_PASSWORD_INCORRECTA, validarRegistro.verificarRegistro(u,val));

        u.setNombre("Bob");
        u.setPassword("abcdef");
        val = "abcdef"; 
        assertEquals(LONG_PASSWORD_INCORRECTA, validarRegistro.verificarRegistro(u,val));
    }
    
    @Test
    public void testContraseniasIguales(){
     Usuario u = new Usuario();
        u.setNombre("Mike");
        u.setPassword("abcd");
        String val = "1234"; 
        assertEquals(PASSWORDS_DIFERENTES, validarRegistro.verificarRegistro(u,val));

        u.setNombre("Mike");
        u.setPassword("abcd");
        val = "abcd"; 
        assertEquals(SUCCESS, validarRegistro.verificarRegistro(u,val));
    }
    
    @Test
    public void testNuevoUsuario(){
     Usuario u = new Usuario();
        u.setNombre("maria");
        u.setPassword("abcd");
        String val = "abcd"; 
        assertEquals(NOMBRE_REPETIDO, validarRegistro.verificarRegistro(u,val));

        u.setNombre("John");
        u.setPassword("abcd");
        val = "abcd"; 
        assertEquals(SUCCESS, validarRegistro.verificarRegistro(u,val));
    }
    
    @Test
    public void testAllCorrect(){
     Usuario u = new Usuario();
        u.setNombre("mary");
        u.setPassword("1234");
        String val = "1234"; 
        assertEquals(SUCCESS, validarRegistro.verificarRegistro(u,val));

        u.setNombre("sebas");
        u.setPassword("4321");
        val = "4321"; 
        assertEquals(SUCCESS, validarRegistro.verificarRegistro(u,val));
        
        u.setNombre("julian");
        u.setPassword("261");
        val = "261"; 
        assertEquals(SUCCESS, validarRegistro.verificarRegistro(u,val));
    
        u.setNombre("robin");
        u.setPassword("abc");
        val = "abc"; 
        assertEquals(SUCCESS, validarRegistro.verificarRegistro(u,val));
    
        u.setNombre("mario");
        u.setPassword("mario");
        val = "mario"; 
        assertEquals(SUCCESS, validarRegistro.verificarRegistro(u,val));
    }
}
