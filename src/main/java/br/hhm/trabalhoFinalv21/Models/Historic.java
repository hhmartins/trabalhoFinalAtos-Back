package br.hhm.trabalhoFinalv21.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Historic implements Serializable{
	
	@ApiModelProperty(notes = "ID do Carregamento", name="id", required=true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private long id;
	
    @ApiModelProperty(notes = "Nome do Usuário", name="name", 
            required=true, value="Nome do usuário")
    @Column(nullable = false)
	private String name;
    
    @ApiModelProperty(notes = "Tempo de Carregamento", name="time", 
            required=true, value="Tempo de carregamento")
    @Column(nullable = false)
	private int time;
    
    @ApiModelProperty(notes = "Energia Consumida", name="energy", 
            required=true, value="Energia Consumida")
    @Column(nullable = false)
	private int energy;
    
    @ApiModelProperty(notes = "Custo da Recarga", name="cost", 
            required=true, value="Custo da Recarga")
    @Column(nullable = false)
	private int cost;
    
    
	public Historic() {

	}
	
	public Historic( String name, int time, int energy, int cost) {
		this.name = name;
		this.time = time;
		this.energy = energy;
		this.cost = cost;
	}
    


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}


	public int getEnergy() {
		return energy;
	}


	public void setEnergy(int energy) {
		this.energy = energy;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	@Override
	public String toString() {
		return "Historic [id=" + id + ", name=" + name + ", time=" + time + ", energy=" + energy + ", cost=" + cost
				+ "]";
	}

	
}
	