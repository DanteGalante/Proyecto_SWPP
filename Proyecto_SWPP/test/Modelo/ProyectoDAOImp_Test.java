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
 * Descripción: Prueba unitaria de los metodos de la clase ProyectoDAOImp<br>
 */
public class ProyectoDAOImp_Test {
    InstitucionVinculadaDAOImp institucionDAO;
    InstitucionVinculadaVO institucion;
    ProyectoDAOImp proyectoDAO;
    ProyectoVO proyecto;
    
    @Before
    public void previo(){
        try{
            institucionDAO = new InstitucionVinculadaDAOImp();
            institucion = new InstitucionVinculadaVO("nombreInstitucionVinculada","direccion","sector","correoElectronico");
            institucionDAO.create(institucion);
            
            proyectoDAO = new ProyectoDAOImp();
            proyecto = new ProyectoVO("nombreProyecto","Descripcion del proyecto","Estatus del proyecto","Nombre del lider de proyecto",0,"mes de inicio de periodo","Año de inicio de periodo","Mes de final de periodo","Año de final de periodo","nombreInstitucionVinculada");
            proyectoDAO.create(proyecto);
        }catch(Exception ex){
            Logger.getLogger(ProyectoDAOImp_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testCreate(){
        try{
            proyectoDAO.delete(proyecto);
            
            boolean resultado = proyectoDAO.create(proyecto);
            
            assertTrue(resultado);
        }catch(Exception ex){
            Logger.getLogger(ProyectoDAOImp_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Test
    public void testReadAll(){
        try{
            ObservableList<ProyectoVO> listaPrueba = null;
            listaPrueba = proyectoDAO.readAll();
            boolean resultado;
            
            if(listaPrueba.isEmpty() || listaPrueba == null){
                resultado = false;
            }else{
                System.out.println(listaPrueba.get(0));
                resultado = true;
            }
            assertTrue(resultado);
        }catch(Exception ex){
            Logger.getLogger(ProyectoDAOImp_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Test
    public void testRead(){
        try{
            ProyectoVO proyectoRecuperado = proyectoDAO.read("nombreProyecto");
            boolean resultado;
            
            resultado = proyectoRecuperado != null;
            
            System.out.println(proyectoRecuperado);
            assertTrue(resultado);
        }catch(Exception ex){
            Logger.getLogger(ProyectoDAOImp_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Test
    public void testUpdate(){
        try{
            ProyectoVO proyectoActualizado = new ProyectoVO(proyecto.getNombreProyecto(),"Nueva descripcion","Nuevo estatus","Nuevo lider",2,"mes de inicio de periodo","Año de inicio de periodo","Mes de final de periodo","Año de final de periodo",proyecto.getNombreInstitucionVinculada());
            boolean resultado = proyectoDAO.update(proyecto.getNombreProyecto(), proyectoActualizado);
            System.out.println(proyectoDAO.read(proyecto.getNombreProyecto()));
            assertTrue(resultado);
        }catch(Exception ex){
            Logger.getLogger(ProyectoDAOImp_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Test
    public void testDelete(){
        try{
            boolean resultado = proyectoDAO.delete(proyecto);
            proyectoDAO.create(proyecto);
            assertTrue(resultado);
        }catch(Exception ex){
            Logger.getLogger(ProyectoDAOImp_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Test
    public void testDelete2(){
        try{
            boolean resultado = proyectoDAO.delete(proyecto.getNombreProyecto());
            proyectoDAO.create(proyecto);
            assertTrue(resultado);
        }catch(Exception ex){
            Logger.getLogger(ProyectoDAOImp_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void despues(){
        try{
            proyectoDAO.delete(proyecto);
            institucionDAO.delete(institucion);
        }catch(Exception ex){
            Logger.getLogger(ProyectoDAOImp_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
