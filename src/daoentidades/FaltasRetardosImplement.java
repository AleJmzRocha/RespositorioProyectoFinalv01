package daoentidades;

import conexionmysql.Conexion;
import java.sql.*;

/**
 *
 * @author nga_a
 */
public class FaltasRetardosImplement implements FaltasRetardosDAO{
    Conexion con;
    
    public FaltasRetardosImplement(){
        con = new Conexion();
    }
    
    @Override
    public Object[][] getFaltasRetardos() {
        Integer registros = 0;
        // obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement pstm = con.getConnection()
                    .prepareStatement("SELECT count(idEmpleado) as total FROM faltas_retardos ");
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
                            + " idEmpleado, faltas, retardos, asistencias"
                            + " FROM faltas_retardos" + " order by faltas desc, retardos desc, asistencias desc");
            ResultSet res = pstm.executeQuery();
            Integer i = 0;
            while (res.next()) {
                String idemp = res.getString("idEmpleado");
                String faltas = res.getString("faltas");
                String retardos = res.getString("retardos");
                String asistencias = res.getString("asistencias");
                data[i][0] = idemp;
                data[i][1] = faltas;
                data[i][2] = retardos;
                data[i][3] = asistencias;
                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }
}
