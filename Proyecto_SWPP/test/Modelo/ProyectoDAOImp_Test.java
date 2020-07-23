/*
------------------------
Dan Javier Olvera Villeda
UNIVERSIDAD VERACRUZANA
------------------------
 */
package Modelo;

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
        institucionDAO = new InstitucionVinculadaDAOImp();
        institucion = new InstitucionVinculadaVO("nombreInstitucionVinculada","direccion","sector","correoElectronico");
        institucionDAO.create(institucion);
        
        proyectoDAO = new ProyectoDAOImp();
        proyecto = new ProyectoVO("nombreProyecto","Descripcion del proyecto","Estatus del proyecto","Nombre del lider de proyecto",0,"mes de inicio de periodo","Año de inicio de periodo","Mes de final de periodo","Año de final de periodo","nombreInstitucionVinculada");
        proyectoDAO.create(proyecto);
    }
    /*
    @Test
    public void testCreate(){
        proyectoDAO.delete(proyecto);
    
        boolean resultado = proyectoDAO.create(proyecto);
    
        assertTrue(resultado);
    }
    */
    /*
    @Test
    public void testReadAll(){
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
    }
    */
    /*
    @Test
    public void testRead(){
        ProyectoVO proyectoRecuperado = proyectoDAO.read("nombreProyecto");
        boolean resultado;
        
        resultado = proyectoRecuperado != null;
        
        System.out.println(proyectoRecuperado);
        assertTrue(resultado);
    }
    */
    /*
    @Test
    public void testUpdate(){
        ProyectoVO proyectoActualizado = new ProyectoVO(proyecto.getNombreProyecto(),"Nueva descripcion","Nuevo estatus","Nuevo lider",2,"mes de inicio de periodo","Año de inicio de periodo","Mes de final de periodo","Año de final de periodo",proyecto.getNombreInstitucionVinculada());
        boolean resultado = proyectoDAO.update(proyecto.getNombreProyecto(), proyectoActualizado);
        System.out.println(proyectoDAO.read(proyecto.getNombreProyecto()));
        assertTrue(resultado);
    }
    */
    /*
    @Test
    public void testDelete(){
        boolean resultado = proyectoDAO.delete(proyecto);
        proyectoDAO.create(proyecto);
        assertTrue(resultado);
    }
    */
    
    @Test
    public void testDelete(){
        boolean resultado = proyectoDAO.delete(proyecto.getNombreProyecto());
        proyectoDAO.create(proyecto);
        assertTrue(resultado);
    }
    
    @After
    public void despues(){
        proyectoDAO.delete(proyecto);
        institucionDAO.delete(institucion);
    }
}
