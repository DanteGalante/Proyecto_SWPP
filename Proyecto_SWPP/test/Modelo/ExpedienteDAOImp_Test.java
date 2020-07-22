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
public class ExpedienteDAOImp_Test {
    EstudianteDAOImp estudianteDAOTest;
    EstudianteVO estudianteTest;
    DocenteDAOImp docenteDAOTest;
    DocenteVO docenteTest;
    InstitucionVinculadaDAOImp institucionDAOTest;
    InstitucionVinculadaVO institucionTest;
    ProyectoDAOImp proyectoDAOTest;
    ProyectoVO proyectoTest;
    ExpedienteDAOImp expedienteDAO;
    ExpedienteVO expediente;
    
    
    @Before
    public void previo(){
        estudianteDAOTest = new EstudianteDAOImp();
        estudianteTest = new EstudianteVO("matriculaEstudiante","Nombre del estudiante","Estatus del estudiante","NRC del estudiante");
        estudianteDAOTest.create(estudianteTest);
        
        docenteDAOTest = new DocenteDAOImp();
        docenteTest = new DocenteVO("cedulaDocente","Nombre","GrupoNRC");
        docenteDAOTest.create(docenteTest);
        
        institucionDAOTest = new InstitucionVinculadaDAOImp();
        institucionTest = new InstitucionVinculadaVO("nombreInstitucionVinculada","direccion","sector","correoElectronico");
        institucionDAOTest.create(institucionTest);
        
        proyectoDAOTest = new ProyectoDAOImp();
        proyectoTest = new ProyectoVO("nombreProyecto","Descripcion del proyecto","Estatus del proyecto","Nombre del lider de proyecto",0,"mes de inicio de periodo","Año de inicio de periodo","Mes de final de periodo","Año de final de periodo","nombreInstitucionVinculada");
        proyectoDAOTest.create(proyectoTest);
        
        expedienteDAO = new ExpedienteDAOImp();
        expediente = new ExpedienteVO("matriculaEstudiante","nombreProyecto","Periodo",3,100,"CedulaDocente");
        expedienteDAO.create(expediente);
    }
    /*
    @Test
    public void testCreate(){
        expedienteDAO.delete(expediente);
    
        boolean resultado = expedienteDAO.create(expediente);
    
        assertTrue(resultado);
    }
    */
    /*
    @Test
    public void testReadAll(){
        List<ExpedienteVO> listaPrueba = null;
        listaPrueba = expedienteDAO.readAll();
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
        ExpedienteVO expedienteRecuperado = expedienteDAO.read("nombreProyecto","matriculaEstudiante");
        boolean resultado;
        
        resultado = expedienteRecuperado != null;
        
        System.out.println(expedienteRecuperado);
        assertTrue(resultado);
    }
    */
    /*
    @Test
    public void testUpdate(){
        ExpedienteVO expedienteActualizado = new ExpedienteVO(expediente.getMatriculaEstudianteVinculado(),expediente.getNombreProyectoVinculado(),"Nuevo periodo",4,1,expediente.getCedulaDocenteVinculado());
        
        boolean resultado = expedienteDAO.update("matriculaEstudiante","nombreProyecto", expedienteActualizado);
        
        System.out.println(expedienteDAO.read("nombreProyecto", "matriculaEstudiante"));
        expedienteDAO.update("matriculaEstudiante","nombreProyecto",expediente);
        assertTrue(resultado);
    }
    */
    /*
    @Test
    public void testDelete(){
        boolean resultado = expedienteDAO.delete(expediente);
        expedienteDAO.create(expediente);
        assertTrue(resultado);
    }
    */
    
    @Test
    public void testDelete(){
        boolean resultado = expedienteDAO.delete("matriculaEstudiante", "nombreProyecto");
        expedienteDAO.create(expediente);
        assertTrue(resultado);
    }
    
    @After
    public void despues(){
        expedienteDAO.delete(expediente);
        docenteDAOTest.delete(docenteTest);
        estudianteDAOTest.delete(estudianteTest);
        proyectoDAOTest.delete(proyectoTest);
        institucionDAOTest.delete(institucionTest);
    }
}
