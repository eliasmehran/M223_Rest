package ch.clip.samples.authapi;

import ch.clip.samples.authapi.equipment.Equipment;
import ch.clip.samples.authapi.equipment.EquipmentRepository;
import ch.clip.samples.authapi.service.EquipmentService;
import ch.clip.samples.authapi.armor.Armor;
import ch.clip.samples.authapi.armor.ArmorRepository;
import ch.clip.samples.authapi.user.AppUser;
import ch.clip.samples.authapi.user.AppUserRepository;
import ch.clip.samples.authapi.weapon.Weapon;
import ch.clip.samples.authapi.weapon.WeaponRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/
// https://github.com/auth0/java-jwt
@SpringBootApplication
public class SpringbootAuthUpdatedApplication {
	private static final Logger log = LoggerFactory.getLogger(SpringbootAuthUpdatedApplication.class);

	@Autowired
	private EquipmentService equipmentService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAuthUpdatedApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ArmorRepository armorRepository, AppUserRepository userRepository, WeaponRepository weaponRepository, EquipmentRepository equipmentRepository) {
		return (args) -> {

			AppUser u1 = new AppUser("user", "123");
			AppUser u2 = new AppUser("user1", "123");
			AppUser u3 = new AppUser("user2", "123");
			userRepository.save(u1);
			userRepository.save(u2);
			userRepository.save(u3);

			Armor damascus = new Armor("Damascus Beta Armor Set", 90, "https://bit.ly/3cmjH48");
			Armor zorah = new Armor("Zorah Gamma Armor Set", 100, "https://bit.ly/3AWs54m");
			Armor odogaron = new Armor("Odogaron Beta + Armor Set", 70, "https://bit.ly/3aEe6FE");
			armorRepository.save(damascus);
			armorRepository.save(zorah);
			armorRepository.save(odogaron);

			Weapon longsword = new Weapon("Stahlurteil", 430, "https://bit.ly/3o7akYE");
			Weapon huntinghorn = new Weapon("Trauerklang", 480, "https://bit.ly/3z7noDn");
			Weapon chargeblade = new Weapon("Unheilskraft", 460, "https://bit.ly/3RBkTAF");
			weaponRepository.save(longsword);
			weaponRepository.save(huntinghorn);
			weaponRepository.save(chargeblade);

			equipmentService.createSet(new Equipment("LS loadout"), 3L, 3L, 1L);
			equipmentService.createSet(new Equipment("CB loadout"), 1L, 1L ,3L);
			equipmentService.createSet(new Equipment("HH loadout"), 2L, 2L, 2L);

		};
	}
}
