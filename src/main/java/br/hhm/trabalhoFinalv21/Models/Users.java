package br.hhm.trabalhoFinalv21.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Users implements Serializable{
	
	@ApiModelProperty(notes = "ID do Usuário", name="id", required=true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private long id;
	
    @ApiModelProperty(notes = "Nome do Usuário", name="name", 
            required=true, value="Nome do usuário")
    @Column(nullable = false)
	private String name;
    
    @ApiModelProperty(notes = "Email do usuário", name="email", 
            required=true, value="Email do usuário")
    @Column(nullable = false)
	private String email;
    
    @ApiModelProperty(notes = "Telefone do usuário", name="phone", 
            required=true, value="Telefone do usuário")
    @Column(nullable = false)
	private String phone;
    
    @ApiModelProperty(notes = "Foto do usuário", name="image", 
            required=true, value="Foto do usuário")
    @Column(nullable = false)
	private String image;
    
	public Users() {

	}

	public Users(String name, String email, String phone, String image) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.image = image;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
    
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", image=" + image
				+ "]";
	}

}
