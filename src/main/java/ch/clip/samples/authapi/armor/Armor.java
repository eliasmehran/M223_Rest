package ch.clip.samples.authapi.armor;

import ch.clip.samples.authapi.equipment.Equipment;
import ch.clip.samples.authapi.user.AppUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Armor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long defence;

    @OneToMany(mappedBy="armor")
	private List<Equipment> equipmentList = new ArrayList<>();

    protected Armor() { }

    public Armor(String name) {
        this.name = name;
    }

    public Armor(String name, long defence) {
        this.name = name;
        this.defence = defence;
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

    public long getDefence() {
        return defence;
    }

    public void setDefence(long defence) {
        this.defence = defence;
    }
}
