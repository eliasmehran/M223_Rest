package ch.clip.samples.authapi.user;

import ch.clip.samples.authapi.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
