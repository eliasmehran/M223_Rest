package ch.clip.samples.authapi.equipment;

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
@RequestMapping("/equipments")
public class EquipmentController {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public EquipmentController(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    /**
     *
     * @return
     */
    @GetMapping
    public List<Equipment> getEquipments() {
        return equipmentRepository.findAll();  //equipmentRepository.findAll();
    }

    /**
     * adds a new equipment to the list - or db
     * @param equipment
     */
    @PostMapping
    public void addEquipment(@RequestBody Equipment equipment) {
        equipmentRepository.save(equipment);
    }

    /**
     * edits equipment in the list - or db
     * @param id, equipment
     */
    @PutMapping("/{id}")
    public void editEquipment(@PathVariable long id, @RequestBody Equipment equipment) {
        Equipment existingEquipment = equipmentRepository.findById(id).get();
        Assert.notNull(existingEquipment, "Equipment not found");
        existingEquipment.setName(equipment.getName());
        existingEquipment.setWeapon(equipment.getWeapon());
        existingEquipment.setArmor(equipment.getArmor());
        existingEquipment.setAppUser(equipment.getAppUser());
        equipmentRepository.save(existingEquipment);
    }

    /**
     * delets equipment in the list - or db
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteEquipment(@PathVariable long id) {
        Equipment equipmentToDel = equipmentRepository.findById(id).get();
        equipmentRepository.delete(equipmentToDel);
    }
}
