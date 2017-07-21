package daoentidades;

import conexionmysql.Conexion;
import entidades.RegistrarEntradaSalida;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author nga_a
 */
public class RegistrarEntradaSalidaDAOImplement implements RegistrarEntradaSalidaDAO{
    Conexion con;
    
    public RegistrarEntradaSalidaDAOImplement(){
        con = new Conexion();
    }
    
    @Override
    public void RegistrarEntrada(RegistrarEntradaSalida registro){
        try {            
           try (PreparedStatement pstm = con.getConnection().prepareStatement("insert into " + 
                        "registrar_entrada_salida(idEmpleado, registrarEntrada, registrarSalida, registrarDia) " +
                        " values(?,?,?,?)")) {
               pstm.setInt(1, registro.getIdEmpleado());
               pstm.setString(2, registro.getRegistrarEntrada());
               pstm.setString(3, "");                        
               pstm.setString(4, registro.getRegistrarDia());                        
               pstm.execute();
               JOptionPane.showMessageDialog(null, "Entrada registrada.");
           }
         }catch(SQLException e){
         System.out.println(e);
      }
    }
    
    @Override
    public void registrarSalida(RegistrarEntradaSalida registro){
        try {            
            PreparedStatement pstm = con.getConnection().prepareStatement("update registrar_entrada_salida " +
            "set registrarSalida = ? " +            
            "where idEmpleado = ? ");            
            pstm.setString(1, registro.getRegistrarSalida());                   
            pstm.setInt(2, registro.getIdEmpleado());
            pstm.execute();
            pstm.close();            
            JOptionPane.showMessageDialog(null, "Salida registrada.");
         }catch(SQLException e){
         System.out.println(e);
      }
    }
}
