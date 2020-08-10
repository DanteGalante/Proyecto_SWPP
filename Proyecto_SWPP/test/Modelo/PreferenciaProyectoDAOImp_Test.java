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
 * Descripción: Prueba unitaria de los metodos de la clase PreferenciaProyectoDAOImp<br>
 */
public class PreferenciaProyectoDAOImp_Test {
    EstudianteDAOImp estudianteDAOTest;
    EstudianteVO estudianteTest;

    InstitucionVinculadaDAOImp institucionDAOTest;
    InstitucionVinculadaVO institucionTest;

    ProyectoDAOImp proyectoDAOTest;
    ProyectoVO proyectoTest;
    
    PreferenciaProyectoDAOImp preferenciaProyectoDAO;
    PreferenciaProyectoVO preferenciaProyecto;
    
    @Before
    public void previo(){
        
        try {
            estudianteDAOTest = new EstudianteDAOImp();
            estudianteTest = new EstudianteVO("matriculaEstudiante","Nombre del estudiante","Estatus del estudiante","NRC del estudiante");
            estudianteDAOTest.create(estudianteTest);
            
            institucionDAOTest = new InstitucionVinculadaDAOImp();
            institucionTest = new InstitucionVinculadaVO("nombreInstitucionVinculada","direccion","sector","correoElectronico");
            institucionDAOTest.create(institucionTest);
            
            proyectoDAOTest = new ProyectoDAOImp();
            proyectoTest = new ProyectoVO("nombreProyecto","Descripcion del proyecto","Estatus del proyecto","Nombre del lider de proyecto",0,"mes de inicio de periodo","Año de inicio de periodo","Mes de final de periodo","Año de final de periodo","nombreInstitucionVinculada");
            proyectoDAOTest.create(proyectoTest);
            
            preferenciaProyectoDAO = new PreferenciaProyectoDAOImp();
            preferenciaProyecto = new PreferenciaProyectoVO("matriculaEstudiante","nombreProyecto",1);
            preferenciaProyectoDAO.create(preferenciaProyecto);
        } catch (Exception ex) {
            Logger.getLogger(PreferenciaProyectoDAOImp_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    @Test
    public void testCreate(){
        preferenciaProyectoDAO.delete(preferenciaProyecto);
    
        boolean resultado = preferenciaProyectoDAO.create(preferenciaProyecto);
    
        assertTrue(resultado);
    }
    */
    /*
    @Test
    public void testReadAll(){
        ObservableList<PreferenciaProyectoVO> listaPrueba = null;
        listaPrueba = preferenciaProyectoDAO.readAll();
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
    @Test
    public void testReadAllConMatricula(){
        ObservableList<PreferenciaProyectoVO> listaPrueba = null;
        listaPrueba = preferenciaProyectoDAO.readAll(estudianteTest.getMatricula());
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
        PreferenciaProyectoVO preferenciaProyectoRecuperado = preferenciaProyectoDAO.read("nombreProyecto","matriculaEstudiante");
        boolean resultado;
        
        resultado = preferenciaProyectoRecuperado != null;
        
        System.out.println(preferenciaProyectoRecuperado);
        assertTrue(resultado);
    }
    */
    /*
    @Test
    public void testUpdate(){
        PreferenciaProyectoVO preferenciaProyectoActualizado = new PreferenciaProyectoVO(preferenciaProyecto.getMatriculaEstudianteVinculado(),preferenciaProyecto.getNombreProyectoVinculado(),4);
        
        boolean resultado = preferenciaProyectoDAO.update("nombreProyecto","matriculaEstudiante", preferenciaProyectoActualizado);
        
        System.out.println(preferenciaProyectoDAO.read("nombreProyecto", "matriculaEstudiante"));
        preferenciaProyectoDAO.update("nombreProyecto","matriculaEstudiante",preferenciaProyecto);
        assertTrue(resultado);
    }
    */
    /*
    @Test
    public void testDelete(){
        boolean resultado = preferenciaProyectoDAO.delete(preferenciaProyecto);
        preferenciaProyectoDAO.create(preferenciaProyecto);
        assertTrue(resultado);
    }
    */
    /*
    @Test
    public void testDelete2(){
        boolean resultado = preferenciaProyectoDAO.delete("nombreProyecto", "matriculaEstudiante");
        preferenciaProyectoDAO.create(preferenciaProyecto);
        assertTrue(resultado);
    }
    */
    @After
    public void despues(){
        preferenciaProyectoDAO.delete(preferenciaProyecto);
        estudianteDAOTest.delete(estudianteTest);
        proyectoDAOTest.delete(proyectoTest);
        institucionDAOTest.delete(institucionTest);
    }
}
