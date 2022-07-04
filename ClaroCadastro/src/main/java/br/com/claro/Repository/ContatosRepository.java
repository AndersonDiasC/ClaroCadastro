package br.com.claro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.claro.Model.Contatos;

public interface ContatosRepository extends JpaRepository<Contatos, String>{

}
