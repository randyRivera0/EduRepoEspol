/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.edurepoespol;

import java.time.LocalDateTime;

/**
 *
 * @author User Dell
 */
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String carrera;
    private LocalDateTime fechaReg;
    private boolean isStudent;
    private boolean isProfesor;
    private boolean isTeachingAssistant;
    private boolean idAdmin;

    public User(String carrera, boolean isStudent, boolean isProfesor, boolean isTeachingAssistant) {
        this.carrera = carrera;
        this.isStudent = isStudent;
        this.isProfesor = isProfesor;
        this.isTeachingAssistant = isTeachingAssistant;
    }

    public boolean isIsStudent() {
        return isStudent;
    }

    public boolean isProfesor() {
        return isProfesor;
    }

    public boolean isTeachingAssistant() {
        return isTeachingAssistant;
    }
    
    

    // Constructor, getters, setters, etc.
    public User(int actorId, String firstName, String lastName) {
        this.id = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
