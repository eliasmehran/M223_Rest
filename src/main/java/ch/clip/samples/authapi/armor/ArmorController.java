package ch.clip.samples.authapi.armor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController für
 *
 * @author luigicavuoti
 * @date 10.07.2020
 */
@RestController
@RequestMapping("/armors")
public class ArmorController {

    @Autowired
    private ArmorRepository armorRepository;

    public ArmorController(ArmorRepository armorRepository) {
        this.armorRepository = armorRepository;
    }

    /**
     * @return
     */
    @GetMapping
    public List<Armor> getArmors() {
        return armorRepository.findAll();  //armorRepository.findAll();
    }

    /**
     * adds a new armor to the list - or db
     *
     * @param armor
     */
    @PostMapping
    public void addArmor(@RequestBody Armor armor) {
        armorRepository.save(armor);
    }


    @PutMapping("/{id}")
    public void editArmor(@PathVariable long id, @RequestBody Armor armor) {
        Armor existingArmor = armorRepository.findById(id).get();
        Assert.notNull(existingArmor, "Armor not found");
        existingArmor.setName(armor.getName());
        existingArmor.setDefence(armor.getDefence());
        armorRepository.save(existingArmor);
    }

    @GetMapping("/{id}")
    public Armor getArmorById(@PathVariable long id) {
        Armor existingArmor = armorRepository.findById(id).get();
        Assert.notNull(existingArmor, "Armor not found");
        return existingArmor;
    }

    @DeleteMapping("/{id}")
    public void deleteArmor(@PathVariable long id) {
        Armor armorToDel = armorRepository.findById(id).get();
        armorRepository.delete(armorToDel);
    }
}
