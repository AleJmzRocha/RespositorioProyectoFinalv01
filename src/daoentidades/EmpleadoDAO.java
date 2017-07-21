package daoentidades;

import entidades.Empleado;

/**
 *
 * @author AleRocha
 */
public interface EmpleadoDAO {    
    public void NuevoEmpleado(Empleado empleado);
    public Object[][] getDatos();
    public Object[][] verActuales();
    public Object[][] buscarEmpleado(String cod);
    public void darBaja(String idEmpleado);
    public Boolean numEmpleado(String numEmpleado);
    public void editarEmpleado(Empleado em);
}
