package br.hhm.trabalhoFinalv21.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.hhm.trabalhoFinalv21.Models.Users;
import br.hhm.trabalhoFinalv21.Service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController",
description = "REST APIs relacionada a lista de usuários")
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsersController {
	
	private final UsersService usersService;
	
	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}
	
	@ApiOperation(value = "Retorna os usuários", response = Iterable.class, tags = "Listar usuário")
	@GetMapping("/all")
	public ResponseEntity<List<Users>> getAllUsers (){
		List<Users> userss = usersService.listAllUsers();
		return new ResponseEntity<>(userss, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Adiciona um Usuário", response = Iterable.class, tags = "Adicionar um usuário")
	@PostMapping("/add")
	public ResponseEntity<Users> addUsers (@RequestBody Users users){
		Users hist = usersService.addUsers(users);
		return new ResponseEntity<>(hist, HttpStatus.CREATED);
	}
	@ApiOperation(value = "Adiciona uma Recarga", response = Iterable.class, tags = "Adicionar um usuário")
	@PostMapping("/addRandom")
	public ResponseEntity<Users> addUsersRandom (){
		Users hist = usersService.addUsersRandom();
		return new ResponseEntity<>(hist, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Atualizar usuário", response = Iterable.class, tags = "Atualizar um usuário")
	//@PostMapping("/update")
	@ResponseBody
	@RequestMapping(value = "/update",method=RequestMethod.PUT)
	public ResponseEntity<Users> updateUsers (@RequestBody Users users){
		Users hist = usersService.updateUsers(users);
		return new ResponseEntity<>(hist, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Deletar um usuário", response = Iterable.class, tags = "Deletar um usuário")
	@ResponseBody
	@RequestMapping(value = "/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteUsers (@PathVariable("id") Long id){
		usersService.deleteUsers(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
