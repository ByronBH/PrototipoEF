/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica.modelo;

import seguridad.modelo.clsConexion;
import logistica.controlador.clsTipopago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoTipopago {

    private static final String SQL_SELECT = "SELECT tipcodigo, tipnombre FROM tbl_tipopago";
    private static final String SQL_INSERT = "INSERT INTO tbl_tipopago(tipnombre) VALUES(?)";
    private static final String SQL_UPDATE = "UPDATE tbl_tipopago SET tipnombre=? WHERE tipcodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_tipopago WHERE tipcodigo=?";
    private static final String SQL_QUERY = "SELECT tipcodigo, tipnombre FROM tbl_tipopago WHERE tipcodigo = ?";

    public List<clsTipopago> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsTipopago tipomarca = null;
        List<clsTipopago> tipomarcas = new ArrayList<clsTipopago>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("tipcodigo");
                String nombre = rs.getString("tipnombre");
                
                
                tipomarca = new clsTipopago();
                tipomarca.setTipcodigo(codigo);
                tipomarca.setTipnombre(nombre);
               
                
                tipomarcas.add(tipomarca);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return tipomarcas;
    }

    public int insert(clsTipopago tipomarca) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, tipomarca.getTipnombre());
           


            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int update(clsTipopago tipomarca) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, tipomarca.getTipnombre());
            stmt.setInt(2, tipomarca.getTipcodigo());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int delete(clsTipopago tipomarca) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, tipomarca.getTipcodigo());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public clsTipopago query(clsTipopago tipomarca) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsTipopago> tipomarcas = new ArrayList<clsTipopago>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, tipomarca.getTipcodigo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("tipcodigo");
                String nombre = rs.getString("tipnombre");
                
                
                tipomarca = new clsTipopago();
                tipomarca.setTipcodigo(codigo);
                tipomarca.setTipnombre(nombre);
               
                
                //vendedores.add(vendedor); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return vendedores;  // Si se utiliza un ArrayList
        return tipomarca;
    }
        
}
