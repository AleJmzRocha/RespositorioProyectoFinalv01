package daoentidades;

import java.sql.*;
import conexionmysql.*;
/**
 *
 * @author nga_a
 */
public class DepartamentoDAOImplement implements DepartamentoDAO{
    Conexion con;
    
    public DepartamentoDAOImplement(){
        con = new Conexion();
    }
    
    @Override
    public String[] getDepartamento() {
        Integer registros = 0;
        // obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement pstm = con.getConnection()
                    .prepareStatement("SELECT count(idDepartamento) as total FROM departamento ");
            try (ResultSet res = pstm.executeQuery()) {
                res.next();
                registros = res.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        String[] data = new String[registros];
        // realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement pstm = con.getConnection()
                    .prepareStatement("SELECT "
                            + " nombreDepartamento"
                            + " FROM departamento" + " ORDER BY idDepartamento ");
            ResultSet res = pstm.executeQuery();
            Integer i = 0;
            while (res.next()) {
                String nomdepa = res.getString("nombreDepartamento");
                data[i] = nomdepa;
                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }
}
