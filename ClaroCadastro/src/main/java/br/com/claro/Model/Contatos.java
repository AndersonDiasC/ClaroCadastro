package br.com.claro.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="tb_contato")
@Transactional
public class Contatos implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	
	private String email;
	@Column
	
	private String nome;
	@Column
	
	private String telefone;
	@Column
	@JsonProperty("code")
	private String cep;
	@Column
	@JsonProperty("address")
	private String endereco;
	@Column
	@JsonProperty("city")
	private String cidade;
	@Column
	@JsonProperty("state")
	private String uf;
	@Column
	
	private Date dh_cadastro;

	

	public Contatos() {
		super();
		
	}	
	
	
	public Contatos(String email, String nome, String telefone, String cep, String endereco, String cidade, String uf,
			Date dh_cadastro) {
		super();
		this.email = email;
		this.nome = nome;
		this.telefone = telefone;
		this.cep = cep;
		this.endereco = endereco;
		this.cidade = cidade;
		this.uf = uf;
		this.dh_cadastro = dh_cadastro;
	}




	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Date getDh_cadastro() {
		return dh_cadastro;
	}

	public void setDh_cadastro(Date dh_cadastro) {
		this.dh_cadastro = dh_cadastro;
	}

	@Override
	public String toString() {
		return "Contatos [email=" + email + ", nome=" + nome + ", telefone=" + telefone + ", cep=" + cep + ", endereco="
				+ endereco + ", cidade=" + cidade + ", uf=" + uf + ", dh_cadastro=" + dh_cadastro + "]";
	}




}
