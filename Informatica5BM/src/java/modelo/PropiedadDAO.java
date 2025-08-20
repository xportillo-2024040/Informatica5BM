package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PropiedadDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    // Listar todas las propiedades
    public List<Propiedad> listar() {
        String sql = "SELECT * FROM propiedad"; // Consulta SQL directa
        List<Propiedad> listaPropiedades = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Propiedad pr = new Propiedad();
                pr.setCodigoPropiedad(rs.getInt("codigoPropiedad"));
                pr.setTipo(rs.getString("tipo"));
                pr.setDireccion(rs.getString("direccion"));
                pr.setNumeroHabitaciones(rs.getInt("numeroHabitaciones"));
                pr.setPrecio(rs.getString("precio"));
                pr.setCodigoPropietario(rs.getInt("codigoPropietario"));
                listaPropiedades.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPropiedades;
    }

    // Agregar una nueva propiedad
    public int agregar(Propiedad pr) {
        String sql = "INSERT INTO propiedad(tipo, direccion, numeroHabitaciones, precio, codigoPropietario) VALUES(?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getTipo());
            ps.setString(2, pr.getDireccion());
            ps.setInt(3, pr.getNumeroHabitaciones());
            ps.setString(4, pr.getPrecio());
            ps.setInt(5, pr.getCodigoPropietario());
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    // Buscar propiedad por código
    public Propiedad listarCodigoPropiedad(int id) {
        Propiedad pr = null;
        String sql = "SELECT * FROM propiedad WHERE codigoPropiedad = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                pr = new Propiedad();
                pr.setCodigoPropiedad(rs.getInt("codigoPropiedad"));
                pr.setTipo(rs.getString("tipo"));
                pr.setDireccion(rs.getString("direccion"));
                pr.setNumeroHabitaciones(rs.getInt("numeroHabitaciones"));
                pr.setPrecio(rs.getString("precio"));
                pr.setCodigoPropietario(rs.getInt("codigoPropietario"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }

    // Actualizar la información de una propiedad
    public int actualizar(Propiedad pr) {
        String sql = "UPDATE propiedad SET tipo = ?, direccion = ?, numeroHabitaciones = ?, precio = ?, codigoPropietario = ? WHERE codigoPropiedad = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getTipo());
            ps.setString(2, pr.getDireccion());
            ps.setInt(3, pr.getNumeroHabitaciones());
            ps.setString(4, pr.getPrecio());
            ps.setInt(5, pr.getCodigoPropietario());
            ps.setInt(6, pr.getCodigoPropiedad());
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    // Eliminar una propiedad
    public void eliminar(int id) {
        String sql = "DELETE FROM propiedad WHERE codigoPropiedad = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
