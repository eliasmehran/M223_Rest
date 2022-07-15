package ch.clip.samples.authapi.user;

import ch.clip.samples.authapi.armor.Armor;
import ch.clip.samples.authapi.equipment.Equipment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;

    @OneToMany(mappedBy="appUser")
    private List<Equipment> equipmentList = new ArrayList<>();

    public AppUser() {
        super();
        // TODO Auto-generated constructor stub
    }

    public AppUser(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ApplicationUser [id=" + id + ", username=" + username + ", password=" + password + "]";
    }

}
