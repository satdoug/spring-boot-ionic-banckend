package com.douglassantos.cursomc.repositories;

import com.douglassantos.cursomc.domain.Categoria;
import com.douglassantos.cursomc.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
