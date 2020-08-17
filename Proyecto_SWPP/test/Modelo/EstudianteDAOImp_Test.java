/*
------------------------
Dan Javier Olvera Villeda
UNIVERSIDAD VERACRUZANA
------------------------
 */
package Modelo;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Clave del programa: SWPP<br>
 * Autor: olver <br>
 * Fecha: 22/07/2020 <br>
 * Descripción: Prueba unitaria de los metodos de la clase EstudianteDAOImp<br>
 */
public class EstudianteDAOImp_Test {
    EstudianteDAOImp estudianteDAO;
    EstudianteVO estudiante;
    
    @Before
    public void previo(){
        try{
            estudianteDAO = new EstudianteDAOImp();
            estudiante = new EstudianteVO("S18012181","Dan Javier Olvera Villeda","Aprobado","74286");
            estudianteDAO.create(estudiante);
        }catch (Exception ex) {
            Logger.getLogger(EstudianteDAOImp_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    @Test
    public void testCreate(){
        estudianteDAO.delete(estudiante);
        boolean resultado = false;
        
        try{
            resultado = estudianteDAO.create(estudiante);
        }catch (Exception ex) {
            Logger.getLogger(EstudianteDAOImp_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        assertTrue(resultado);
    }
    */
    
    @Test
    public void testReadAll(){
        ObservableList<EstudianteVO> listaPrueba = null;
        try{
            listaPrueba = estudianteDAO.readAll();
        }catch (Exception ex) {
            Logger.getLogger(EstudianteDAOImp_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean resultado;
        
        if(listaPrueba.isEmpty() || listaPrueba == null){
            resultado = false;
        }else{
            System.out.println(listaPrueba.get(0));
            resultado = true;
        }
        
        assertTrue(resultado);
    }
    
    /*
    @Test
    public void testRead(){
        EstudianteVO estudianteRecuperado = estudianteDAO.read("S18012181");
        boolean resultado;
        
        resultado = estudianteRecuperado != null;
        
        System.out.println(estudianteRecuperado);
        assertTrue(resultado);
    }
    */
    /*
    @Test
    public void testUpdate(){
        EstudianteVO estudianteActualizado = new EstudianteVO("S18012181","Olvera Villeda Dan Javier","Evaluado","74286");
        boolean resultado = estudianteDAO.update("S18012181", estudianteActualizado);
        System.out.println(estudianteDAO.read("S18012181"));
        assertTrue(resultado);
    }
    */
    /*
    @Test
    public void testDelete(){
        try {
            boolean resultado = estudianteDAO.delete(estudiante);
            estudianteDAO.create(estudiante);
            assertTrue(resultado);
        } catch (Exception ex) {
            Logger.getLogger(EstudianteDAOImp_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    /*
    @Test
    public void testDelete(){
        boolean resultado = estudianteDAO.delete("S18012181");
        estudianteDAO.create(estudiante);
        assertTrue(resultado);
    }
    */
    @After
    public void despues(){
        estudianteDAO.delete(estudiante);
    }
}
