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
public class UserDAO implements DAO<User>{
    private Connection connection;

    public UserDAO() {
        connection = DataBaseConnection.getInstance().getConnection();
    }

    // Create or Insert new User
    @Override
    public void insert(User actor) {
        String query = "INSERT INTO actor (first_name, last_name) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, actor.getFirstName());
            stmt.setString(2, actor.getLastName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read or Retrieve all Actors
    @Override
    public List<User> getAll() {
        List<User> actors = new ArrayList<>();
        String query = "SELECT * FROM actor";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                User actor = new User(
                        rs.getInt("actor_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"));
                actors.add(actor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }

    // Update User
    public void update(User actor) {
        String query = "UPDATE actor SET first_name = ?, last_name = ? WHERE actor_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, actor.getFirstName());
            stmt.setString(2, actor.getLastName());
            stmt.setInt(3, actor.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete User
    @Override
    public void delete(int actorId) {
        String query = "DELETE FROM actor WHERE actor_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, actorId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getById(int id) throws SQLException {
        String query = "SELECT * FROM administrador WHERE idAdmin = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("carrera"), rs.getBoolean("esEstudiante"), rs.getBoolean("esProfesor"), rs.getBoolean("esAyudate"));
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
