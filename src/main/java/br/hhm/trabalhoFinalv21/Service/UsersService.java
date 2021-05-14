package br.hhm.trabalhoFinalv21.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hhm.trabalhoFinalv21.Models.Users;
import br.hhm.trabalhoFinalv21.Repositories.UsersRepo;

@Service
public class UsersService {
	
	private final UsersRepo usersRepo;
	
	
	@Autowired
	public UsersService(UsersRepo usersRepo) {
		this.usersRepo = usersRepo;
	}
	
	
	
	public Users addUsers(Users users) {
		return usersRepo.save(users);
	}
	
	public Users addUsersRandom() {
		int random = (int)Math.floor(Math.random()*(999-1+1)+1);
		Users users = new Users();
		users.setName("User#" + random);
		users.setEmail("User#" + random + "@gmail.com");
		users.setPhone(Math.round(Math.random()*10000)+"-"+Math.round(Math.random()*10000));
		users.setImage("https://bootdey.com/img/Content/avatar/avatar"+(int)Math.floor(Math.random()*(5)+1)+".png");
		return usersRepo.save(users);
	}
	
	public List<Users> listAllUsers(){
		return usersRepo.findAll();
	}
	
	public Users updateUsers(Users users) {
		return usersRepo.save(users);
	}
	
	public void deleteUsers(Long id) {
		usersRepo.deleteById(id);
	}

}
