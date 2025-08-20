package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PropietarioDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    // Listar todos los propietarios
    public List<Propietario> listar() {
        String sql = "SELECT * FROM propietario"; // Consulta SQL directa
        List<Propietario> listaPropietarios = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Propietario p = new Propietario();
                p.setCodigoPropietario(rs.getInt("codigoPropietario"));
                p.setNombre(rs.getString("nombre"));
                p.setTelefono(rs.getString("telefono"));
                listaPropietarios.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPropietarios;
    }

    // Agregar un nuevo propietario
    public int agregar(Propietario p) {
        String sql = "INSERT INTO propietario (nombre, telefono) VALUES (?, ?)"; // Consulta SQL directa
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTelefono());
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    // Buscar propietario por código
    public Propietario listarCodigoPropietario(int id) {
        Propietario p = null;
        String sql = "SELECT * FROM propietario WHERE codigoPropietario = ?"; // Consulta SQL directa
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                p = new Propietario();
                p.setCodigoPropietario(rs.getInt("codigoPropietario"));
                p.setNombre(rs.getString("nombre"));
                p.setTelefono(rs.getString("telefono"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    // Actualizar información de un propietario
    public int actualizar(Propietario p) {
        String sql = "UPDATE propietario SET nombre = ?, telefono = ? WHERE codigoPropietario = ?"; // Consulta SQL directa
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTelefono());
            ps.setInt(3, p.getCodigoPropietario());
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    // Eliminar un propietario
    public void eliminar(int id) {
        String sql = "DELETE FROM propietario WHERE codigoPropietario = ?"; // Consulta SQL directa
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
