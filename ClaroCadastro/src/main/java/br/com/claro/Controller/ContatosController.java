package br.com.claro.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.claro.Model.Contatos;
import br.com.claro.Repository.ContatosRepository;

@RestController
@RequestMapping("api/v1")
public class ContatosController {
	
	RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	ContatosRepository contatoRepo;
	/***
	 * 
	 * @return Devolve todos os Contatos Cadastrados
	 * retornando o Status 302 encontrado.
	 */
	@GetMapping("/contatos")
	public ResponseEntity<List<Contatos>> findAll(){
		
		List<Contatos> contatos = new ArrayList<>();
		
		contatos= contatoRepo.findAll();
		
		return new ResponseEntity<List<Contatos>>(contatos, HttpStatus.FOUND);
			
	}
	
	@GetMapping("/contatos/{email}")
	public Contatos findByEmail(@PathVariable String email){		
		
	Contatos contatos = contatoRepo.getById(email);			
		
	return contatos;		
	}
	
	/***
	 * 
	 * @param contatos
	 * @return Salva novos contatos, e faz um update nas informações se houver dados cadastrados com o mesmo ID o email 
	 * no nosso caso, com retorno de status 201 Created, caso o cep não for encontrado ou for nullo ele retornará 404 Not Found
	 */
	@PostMapping("/save")
	public ResponseEntity<Contatos> salvarContatos(@RequestBody Contatos contatos) {		
		
		ResponseEntity<Contatos> entity = restTemplate.getForEntity("https://ws.apicep.com/cep/"+contatos.getCep()+".json", Contatos.class);
		if(entity.getBody().getCep()!= null) {
		contatos.setEndereco(entity.getBody().getEndereco());
		contatos.setCidade(entity.getBody().getCidade());
		contatos.setUf(entity.getBody().getUf());
		contatos.setDh_cadastro(new Date());
		contatoRepo.save(contatos);
		
		return new ResponseEntity<Contatos>(contatos, HttpStatus.CREATED);
		}else {return new ResponseEntity<Contatos>(HttpStatus.NOT_FOUND);}
	}

	
		@DeleteMapping("delete/{email}")
		public ResponseEntity<?> deletarContatos(@PathVariable String email){
			
					contatoRepo.deleteById(email);
			
			return ResponseEntity.status(204).build();
		}
	

}
