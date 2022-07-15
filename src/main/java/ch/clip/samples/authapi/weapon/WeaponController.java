package ch.clip.samples.authapi.weapon;

import ch.clip.samples.authapi.equipment.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController für
 * @author luigicavuoti
 * @date 10.07.2020
 *
 */
@RestController
@RequestMapping("/weapons")
public class WeaponController {

    @Autowired
    private WeaponRepository weaponRepository;

    public WeaponController(WeaponRepository weaponRepository) {
        this.weaponRepository = weaponRepository;
    }

    /**
     *
     * @return
     */
    @GetMapping
    public List<Weapon> getWeapons() {
        return weaponRepository.findAll();  //weaponRepository.findAll();
    }

    /**
     * gets specific piece by id
     * @param id
     */
    @GetMapping("/{id}")
    public Weapon getEquipmentById(@PathVariable long id) {
        Weapon existingweapon = weaponRepository.findById(id).get();
        Assert.notNull(existingweapon, "Weapon not found");
        return existingweapon;
    }

    /**
     * adds a new weapon to the list - or db
     * @param weapon
     */
    @PostMapping
    public void addWeapon(@RequestBody Weapon weapon) {
        weaponRepository.save(weapon);
    }


    /**
     * edits weapon in the list - or db
     * @param id, weapon
     */
    @PutMapping("/{id}")
    public void editWeapon(@PathVariable long id, @RequestBody Weapon weapon) {
        Weapon existingWeapon = weaponRepository.findById(id).get();
        Assert.notNull(existingWeapon, "Weapon not found");
        existingWeapon.setName(weapon.getName());
        existingWeapon.setDamage(weapon.getDamage());
        weaponRepository.save(existingWeapon);
    }

    /**
     * delets weapon from the list - or db
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteWeapon(@PathVariable long id) {
        Weapon weaponToDel = weaponRepository.findById(id).get();
        weaponRepository.delete(weaponToDel);
    }
}
