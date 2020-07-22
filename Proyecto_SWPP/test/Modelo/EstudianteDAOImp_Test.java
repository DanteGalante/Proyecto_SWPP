/*
------------------------
Dan Javier Olvera Villeda
UNIVERSIDAD VERACRUZANA
------------------------
 */
package Modelo;

import java.util.List;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author olver
 */
public class EstudianteDAOImp_Test {
    EstudianteDAOImp estudianteDAO;
    EstudianteVO estudiante;
    
    @Before
    public void previo(){
        estudianteDAO = new EstudianteDAOImp();
        estudiante = new EstudianteVO("S18012181","Dan Javier Olvera Villeda","Aprobado","74286");
        estudianteDAO.create(estudiante);
    }
    /*
    @Test
    public void testCreate(){
        estudianteDAO.delete(estudiante);
    
        boolean resultado = estudianteDAO.create(estudiante);
    
        assertTrue(resultado);
    }
    */
    /*
    @Test
    public void testReadAll(){
        List<EstudianteVO> listaPrueba = null;
        listaPrueba = estudianteDAO.readAll();
        boolean resultado;
        
        if(listaPrueba.isEmpty() || listaPrueba == null){
            resultado = false;
        }else{
            System.out.println(listaPrueba.get(0));
            resultado = true;
        }
        
        assertTrue(resultado);
    }
    */
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
        boolean resultado = estudianteDAO.delete(estudiante);
        estudianteDAO.create(estudiante);
        assertTrue(resultado);
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
