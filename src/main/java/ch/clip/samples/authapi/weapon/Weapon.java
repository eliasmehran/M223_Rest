package ch.clip.samples.authapi.weapon;

import ch.clip.samples.authapi.equipment.Equipment;
import ch.clip.samples.authapi.user.AppUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name, imageLink;
    private long damage;

    @OneToMany(mappedBy="weapon")
    private List<Equipment> equipmentList = new ArrayList<>();

    protected Weapon() { }

    public Weapon(String name) {
        this.name = name;
    }

    public Weapon(String name, long damage, String imageLink) {
        this.name = name;
        this.damage = damage;
        this.imageLink = imageLink;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDamage() {
        return damage;
    }

    public void setDamage(long defence) {
        this.damage = defence;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
