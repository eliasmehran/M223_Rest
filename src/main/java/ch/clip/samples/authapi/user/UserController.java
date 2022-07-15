package ch.clip.samples.authapi.user;

import ch.clip.samples.authapi.service.EquipmentService;
import ch.clip.samples.authapi.weapon.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
	private AppUserRepository applicationUserRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private EquipmentService equipmentService;

	public UserController(AppUserRepository applicationUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.applicationUserRepository = applicationUserRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@PostMapping("/sign-up")
	public void signUp(@RequestBody AppUser user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		applicationUserRepository.save(user);
	}

	@PutMapping("/{id}")
	public void editUser(@RequestParam Long id, @RequestBody AppUser user) {
		AppUser existingUser = applicationUserRepository.findById(id).get();
		Assert.notNull(existingUser, "Weapon not found");
		existingUser.setUsername(user.getUsername());
		existingUser.setPassword(user.getPassword());
		applicationUserRepository.save(existingUser);
	}

//	@PostMapping("/{id}")
//	public void addUser(@RequestBody AppUser user, @PathVariable Long id) { // , @RequestBody Task task) {
//		// service methode user, id -> Service taak getById user.setTask
//		equipmentService.addTask(user, id);
//	}

	/**
	 *
	 * @return
	 */
	@GetMapping
	public List<AppUser> getUsers() {
		return applicationUserRepository.findAll(); // taskRepository.findAll();
	}

}
