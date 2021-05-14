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

import br.hhm.trabalhoFinalv21.Models.Historic;
import br.hhm.trabalhoFinalv21.Service.HistoricService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "Swagger2RestController",
description = "REST APIs relacionada ao historico das Recargas")
@RestController
@RequestMapping("/historic")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HistoricController {
	
	private final HistoricService historicService;
	
	public HistoricController(HistoricService historicService) {
		this.historicService = historicService;
	}
	
	@ApiOperation(value = "Retorna o historico de recarga", response = Iterable.class, tags = "Listar historico")
	@GetMapping("/all")
	public ResponseEntity<List<Historic>> getAllHistoric (){
		List<Historic> historics = historicService.listAllHistoric();
		return new ResponseEntity<>(historics, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Adiciona uma Recarga", response = Iterable.class, tags = "Adicionar recarga ao historico")
	@PostMapping("/add")
	public ResponseEntity<Historic> addHistoric (@RequestBody Historic historic){
		Historic hist = historicService.addHistoric(historic);
		return new ResponseEntity<>(hist, HttpStatus.CREATED);
	}
	@ApiOperation(value = "Adiciona uma Recarga", response = Iterable.class, tags = "Adicionar recarga ao historico")
	@PostMapping("/addRandom")
	public ResponseEntity<Historic> addHistoricRandom (){
		Historic hist = historicService.addHistoricRandom();
		return new ResponseEntity<>(hist, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Atualizar recarga", response = Iterable.class, tags = "Atualizar uma recarga do historico")
	@ResponseBody
	@RequestMapping(value = "/update",method=RequestMethod.PUT)
	public ResponseEntity<Historic> updateHistoric (@RequestBody Historic historic){
		Historic hist = historicService.updateHistoric(historic);
		return new ResponseEntity<>(hist, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Deletar uma recarga", response = Iterable.class, tags = "Deletar uma recarga do historico")
	@ResponseBody
	@RequestMapping(value = "/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteHistoric (@PathVariable("id") Long id){
		historicService.deleteHistoric(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	


}
