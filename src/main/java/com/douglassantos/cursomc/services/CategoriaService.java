package com.douglassantos.cursomc.services;

import com.douglassantos.cursomc.domain.Categoria;

import com.douglassantos.cursomc.repositories.CategoriaRepository;
import com.douglassantos.cursomc.services.exceptions.DataIntegrityServiceException;
import com.douglassantos.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria find(Integer id){
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria insert(Categoria categoria){
        categoria.setId(null);
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Categoria categoria){
        find(categoria.getId());
        return categoriaRepository.save(categoria);
    }

    public void delete(Integer id){
        find(id);
        try {
            categoriaRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw  new DataIntegrityServiceException("Não é possível excluir uma categoria que possui produtos associados.");
        }
    }

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }
}
