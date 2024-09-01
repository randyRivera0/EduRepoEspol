/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.edurepoespol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User Dell
 */
public class FileDAO implements DAO<Archivo> {
    private Connection connection;

    public FileDAO() {
        connection = DataBaseConnection.getInstance().getConnection();
    }

    // Create or Insert new User
    @Override
    public void insert(Archivo file) {
        String query = "INSERT INTO archivo (nombre, ruta, codigo, matricula) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, file.getNombre());
            stmt.setString(2, "C:\\Users\\User Dell\\Downloads\\" + file.getNombre());
            stmt.setString(3, file.getCodigo());
            stmt.setString(4, "101");
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read or Retrieve all Actors
    @Override
    public List<Archivo> getAll() {
        List<Archivo> actors = new ArrayList<>();
        String query = "SELECT * FROM actor";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Archivo actor = new Archivo(
                        rs.getString("nombre"),
                        rs.getString("codigo"),
                        rs.getString("matricula"));
                actors.add(actor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }

    
    @Override
    public void update(Archivo actor) {
        String query = "UPDATE actor SET first_name = ?, last_name = ? WHERE actor_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, actor.getNombre());
            stmt.setString(2, actor.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    // Delete User
    @Override
    public void delete(int actorId) {
        String query = "DELETE FROM archivo WHERE idArchivo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, actorId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Archivo getById(int id) throws SQLException {
        String query = "SELECT * FROM administrador WHERE idAdmin = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
//                return new Archivo(rs.getString("carrera"), rs.getBoolean("esEstudiante"), rs.getBoolean("esProfesor"), rs.getBoolean("esAyudate"));
                return null;
            }
        }
        return null;
    }
    
    
    public User getByEmail(String nombre) throws SQLException {
        String query = "SELECT * FROM usuario WHERE nombre = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("carrera"), rs.getBoolean("esEstudiante"), rs.getBoolean("esProfesor"), rs.getBoolean("esAyudante"));
            }
        }
        return null;
    }
    
}
