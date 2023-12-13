package Interfaces;

import Personas.Empleado;

public interface DAOEmpleado {
    
    public void registrar(Empleado empleado);
    
    public void modificar(Empleado  empleado);
    
    public void eliminar(Empleado empleado);
    
    public void buscar(Empleado empleado);
    
}
