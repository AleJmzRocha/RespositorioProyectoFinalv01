package daoentidades;

import conexionmysql.Conexion;
import entidades.Empleado;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author nga_a
 */
public class EmpleadoDAOImplement implements EmpleadoDAO {

    Conexion con;

    public EmpleadoDAOImplement() {
        con = new Conexion();
    }

    @Override
    public void NuevoEmpleado(Empleado empleado) {
        try {
            try (PreparedStatement pstm = con.getConnection()
                    .prepareStatement("insert into "
                            + "empleado(idEmpleado, nombrePila, apellidoPaterno, apellidoMaterno, direccion, telefonoCelular, numeroEmergencia, idDepartamento, estado) "
                            + "values(?,?,?,?,?,?,?,?,?)")) {
                pstm.setInt(1, empleado.getIdEmpleado());
                pstm.setString(2, empleado.getNombrePila());
                pstm.setString(3, empleado.getApellidoPaterno());
                pstm.setString(4, empleado.getApellidoMaterno());
                pstm.setString(5, empleado.getDireccion());
                pstm.setInt(6, empleado.getTelefonoCelular());
                pstm.setInt(7, empleado.getNumeroEmergencia());
                pstm.setInt(8, empleado.getIdDepartamento());
                pstm.setString(9, empleado.getEstado());
                pstm.execute();
                pstm.close();
            }
            JOptionPane.showMessageDialog(null, "Registro exitoso.");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public Object[][] getDatos() {
        Integer registros = 0;
        // obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement pstm = con.getConnection()
                    .prepareStatement("SELECT count(idEmpleado) as total FROM empleado ");
            try (ResultSet res = pstm.executeQuery()) {
                res.next();
                registros = res.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] data = new String[registros][9];
        // realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement pstm = con.getConnection()
                    .prepareStatement("SELECT "
                            + " idEmpleado, nombrePila, apellidoPaterno, apellidoMaterno, direccion, telefonoCelular, numeroEmergencia, idDepartamento, estado"
                            + " FROM empleado" + " ORDER BY idEmpleado ");
            ResultSet res = pstm.executeQuery();
            Integer i = 0;
            while (res.next()) {
                String idemp = res.getString("idEmpleado");
                String nompila = res.getString("nombrePila");
                String apaterno = res.getString("apellidoPaterno");
                String amaterno = res.getString("apellidoMaterno");
                String direccion = res.getString("direccion");
                String telcel = res.getString("telefonoCelular");
                String numem = res.getString("numeroEmergencia");
                String idepa = res.getString("idDepartamento");
                String estado = res.getString("estado");
                data[i][0] = idemp;
                data[i][1] = nompila;
                data[i][2] = apaterno;
                data[i][3] = amaterno;
                data[i][4] = direccion;
                data[i][5] = telcel;
                data[i][6] = numem;
                data[i][7] = idepa;
                data[i][8] = estado;
                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

    @Override
    public Object[][] verActuales() {
        Integer registros = 0;
        // obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement pstm = con.getConnection()
                    .prepareStatement("SELECT count(idEmpleado) as total FROM empleado ");
            try (ResultSet res = pstm.executeQuery()) {
                res.next();
                registros = res.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] data = new String[registros][9];
        // realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement pstm = con.getConnection()
                    .prepareStatement("SELECT "
                            + " idEmpleado, nombrePila, apellidoPaterno, apellidoMaterno, direccion, telefonoCelular, numeroEmergencia, idDepartamento, estado"
                            + " FROM empleado where estado = 'Alta' " + " ORDER BY idEmpleado ");
            ResultSet res = pstm.executeQuery();
            Integer i = 0;
            while (res.next()) {
                String idemp = res.getString("idEmpleado");
                String nompila = res.getString("nombrePila");
                String apaterno = res.getString("apellidoPaterno");
                String amaterno = res.getString("apellidoMaterno");
                String direccion = res.getString("direccion");
                String telcel = res.getString("telefonoCelular");
                String numem = res.getString("numeroEmergencia");
                String idepa = res.getString("idDepartamento");
                String estado = res.getString("estado");
                data[i][0] = idemp;
                data[i][1] = nompila;
                data[i][2] = apaterno;
                data[i][3] = amaterno;
                data[i][4] = direccion;
                data[i][5] = telcel;
                data[i][6] = numem;
                data[i][7] = idepa;
                data[i][8] = estado;
                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

    @Override
    public Object[][] buscarEmpleado(String cod) {
        //Componer
        Integer registros = 0;
        // obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement pstm = con.getConnection()
                    .prepareStatement("SELECT count(idEmpleado) as total FROM empleado ");
            try (ResultSet res = pstm.executeQuery()) {
                res.next();
                registros = res.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] data = new String[registros][9];
        // realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement pstm = con.getConnection()
                    .prepareStatement("SELECT "
                            + " idEmpleado, nombrePila, apellidoPaterno, apellidoMaterno, direccion, telefonoCelular, numeroEmergencia, idDepartamento, estado"
                            + " FROM empleado where estado = 'Alta' " + " ORDER BY idEmpleado ");
            ResultSet res = pstm.executeQuery();
            Integer i = 0;
            while (res.next()) {
                String idemp = res.getString("idEmpleado");
                String nompila = res.getString("nombrePila");
                String apaterno = res.getString("apellidoPaterno");
                String amaterno = res.getString("apellidoMaterno");
                String direccion = res.getString("direccion");
                String telcel = res.getString("telefonoCelular");
                String numem = res.getString("numeroEmergencia");
                String idepa = res.getString("idDepartamento");
                String estado = res.getString("estado");
                data[i][0] = idemp;
                data[i][1] = nompila;
                data[i][2] = apaterno;
                data[i][3] = amaterno;
                data[i][4] = direccion;
                data[i][5] = telcel;
                data[i][6] = numem;
                data[i][7] = idepa;
                data[i][8] = estado;
                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

    @Override
    public void darBaja(String idEmpleado) {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("update empleado "
                    + "set estado = 'Baja' "
                    + "where idEmpleado = ? ");
            pstm.setString(1, idEmpleado);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public Boolean numEmpleado(String numEmpleado) {
        Boolean numEmp = false;
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("select idEmpleado from empleado where idEmpleado = ?");
            pstm.setString(1, numEmpleado);
            numEmp = pstm.execute();
//            System.out.println(numEmp);
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
//            JOptionPane.showMessageDialog(null, "Número de administrador o contraseña incorrecta.");
        }
        return numEmp;
    }

    @Override
    public void editarEmpleado(Empleado em) {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("update empleado "
//                  + "set idEmpleado = ?,"
                    + "set nombrePila = ? ,"
                    + "apellidoPaterno = ? ,"
                    + "apellidoMaterno = ? ,"
                    + "direccion = ? ,"
                    + "telefonoCelular = ? ,"
                    + "numeroEmergencia = ?,"
                    + "idDepartamento = ?, "
                    + "estado = ?"
                    + "where idEmpleado = ? ");
//            pstm.setInt(1, em.getIdEmpleado());
            pstm.setString(1, em.getNombrePila());
            pstm.setString(2, em.getApellidoPaterno());
            pstm.setString(3, em.getApellidoMaterno());
            pstm.setString(4, em.getDireccion());
            pstm.setInt(5, em.getTelefonoCelular());
            pstm.setInt(6, em.getNumeroEmergencia());
            pstm.setInt(7, em.getIdDepartamento());
            pstm.setString(8, em.getEstado());
            pstm.setInt(9, em.getIdEmpleado());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
