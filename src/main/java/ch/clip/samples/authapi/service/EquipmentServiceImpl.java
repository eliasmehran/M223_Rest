package ch.clip.samples.authapi.service;

import ch.clip.samples.authapi.armor.Armor;
import ch.clip.samples.authapi.armor.ArmorRepository;
import ch.clip.samples.authapi.equipment.Equipment;
import ch.clip.samples.authapi.equipment.EquipmentRepository;
import ch.clip.samples.authapi.user.AppUser;
import ch.clip.samples.authapi.user.AppUserRepository;
import ch.clip.samples.authapi.weapon.Weapon;
import ch.clip.samples.authapi.weapon.WeaponRepository;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl implements EquipmentService {

	private AppUserRepository appUserRepository;
	private ArmorRepository armorRepository;
	private WeaponRepository weaponRepository;
	private EquipmentRepository equipmentRepository;

	public EquipmentServiceImpl(AppUserRepository appUserRepository, ArmorRepository armorRepository, WeaponRepository weaponRepository, EquipmentRepository equipmentRepository) {
		this.appUserRepository = appUserRepository;
		this.weaponRepository = weaponRepository;
		this.armorRepository = armorRepository;
		this.equipmentRepository = equipmentRepository;
	}


	@Override
	public void addUser(Equipment equipment, Long appUserId) {
		AppUser appUser = appUserRepository.getOne(appUserId);
		equipment.setAppUser(appUser);
		equipmentRepository.save(equipment);
	}

	@Override
	public void addArmor(Equipment equipment, Long armorId) {
		Armor armor = armorRepository.getOne(armorId);
		equipment.setArmor(armor);
		equipmentRepository.save(equipment);
	}

	@Override
	public void addWeapon(Equipment equipment, Long weaponId) {
		Weapon weapon = weaponRepository.getOne(weaponId);
		equipment.setWeapon(weapon);
		equipmentRepository.save(equipment);
	}

	/**
	 * creates Equipmensset
	 * @param equipment, appUserId, armorId, weaponId
	 */
	@Override
	public void createSet(Equipment equipment, Long appUserId, Long armorId, Long weaponId) {
		AppUser appUser = appUserRepository.getOne(appUserId);
		Armor armor = armorRepository.getOne(armorId);
		Weapon weapon = weaponRepository.getOne(weaponId);
		equipment.setAppUser(appUser);
		equipment.setArmor(armor);
		equipment.setWeapon(weapon);
		equipmentRepository.save(equipment);
	}


}
