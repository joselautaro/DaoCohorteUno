package Interfaces;

import Dao.Main;
import Personas.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOEmpleadoImplementacion implements DAOEmpleado{
    
    //Establecer una instancia de la clase main 
    
    Main main = new Main();
    
    public DAOEmpleadoImplementacion(){}
    
    //Implementamos método registrar
   @Override
   public void registrar(Empleado empleado){
       try{
           
           Connection conectar = main.establecerConeccion();
           
           PreparedStatement insertar = conectar.prepareStatement("INSERTAR INTO empleados (id, nombre) VALUES(?, ?)");
           
           insertar.setInt(1, empleado.getId());
           
           insertar.setString(2, empleado.getEmpleado());
           
           insertar.executeUpdate();
           
       }catch(Exception e){
           System.out.println(e);
       }
   }
    
   //Implementamos el método modificar
   
   public void modificar(Empleado empleado){
       try{
           
           Connection conectar = main.establecerConeccion();
           
           PreparedStatement modificar = conectar.prepareStatement("UPDATE empleados set nombre = ? where id = ?");
           
           modificar.setInt(1, empleado.getId());
           
           modificar.setString(2, empleado.getEmpleado());
           
           modificar.executeUpdate();
           
       }catch(Exception e){
           System.out.println(e);
       }
   }
   
   public void eliminar(Empleado empleado){
       try{
           
           Connection conectar = main.establecerConeccion();
           
           PreparedStatement eliminar = conectar.prepareStatement("DELETE FROM empleados where id = ?");
           
           eliminar.setInt(1, empleado.getId());
           
           eliminar.executeUpdate();
           
       }catch(Exception e){
           System.out.println(e);
       }
   }

    @Override
    public void buscar(Empleado empleado) {
        try{
           
           Connection conectar = main.establecerConeccion();
           
           PreparedStatement buscar = conectar.prepareStatement("select * from empleados where id = ?");
           
           buscar.setInt(1, empleado.getId());
           
           ResultSet consulta = buscar.executeQuery();
           
           if( consulta.next() ){
               empleado.setId(Integer.parseInt(consulta.getString("id")));
               empleado.setEmpleado(consulta.getString("nombre"));
           }
           
       }catch(Exception e){
           System.out.println(e);
       }
    }
    
}
