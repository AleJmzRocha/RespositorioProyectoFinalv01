/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoentidades;

import conexionmysql.Conexion;
import entidades.Administrador;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author nga_a
 */
public class AdministradorDAOImplement implements AdministradorDAO{
    Conexion con;
    
    public AdministradorDAOImplement(){
        con = new Conexion();
    }
    
    @Override
    public void NuevoAdministrador(Administrador administrador) {
        try {
            try (PreparedStatement pstm = con.getConnection()
                    .prepareStatement("insert into "
                            + "administrador(idEmpleado, pass, nombrePila, apellidoPaterno, apellidoMaterno, direccion, telefonoCelular, numeroEmergencia, idDepartamento, estado) "
                            + "values(?,?,?,?,?,?,?,?,?,?)")) {
                pstm.setInt(1, administrador.getIdEmpleado());
                pstm.setString(2, administrador.getPassword());
                pstm.setString(3, administrador.getNombrePila());
                pstm.setString(4, administrador.getApellidoPaterno());
                pstm.setString(5, administrador.getApellidoMaterno());
                pstm.setString(6, administrador.getDireccion());
                pstm.setInt(7, administrador.getTelefonoCelular());
                pstm.setInt(8, administrador.getNumeroEmergencia());
                pstm.setInt(9, administrador.getIdDepartamento());
                pstm.setString(10, administrador.getEstado());
                pstm.execute();
                pstm.close();
            }
            JOptionPane.showMessageDialog(null, "Registro exitoso.");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    @Override
    public Boolean entrarAdministradorId(String idAministrador, String cod) {
        Boolean flag = false;
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("select idEmpleado, pass from administrador where idEmpleado = ? and pass = ?");
            pstm.setString(1, idAministrador);
            pstm.setString(2, cod);
            pstm.execute();
            pstm.close();
            flag = true;
        } catch (SQLException e) {
            System.out.println(e);
//            JOptionPane.showMessageDialog(null, "Número de administrador o contraseña incorrecta.");
        }
        return flag;
    }
}
