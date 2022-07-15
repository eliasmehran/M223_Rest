package ch.clip.samples.authapi.service;

import ch.clip.samples.authapi.equipment.Equipment;
import ch.clip.samples.authapi.user.AppUser;

public interface EquipmentService {

	public void addUser(Equipment equipment, Long appUserId);
	public void addArmor(Equipment equipment, Long armorId);
	public void addWeapon(Equipment equipment, Long weaponId);
	public void createSet(Equipment equipment, Long appUserId, Long armorId, Long weaponId);

}
