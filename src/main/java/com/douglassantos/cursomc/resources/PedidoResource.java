package com.douglassantos.cursomc.resources;

import com.douglassantos.cursomc.domain.Categoria;
import com.douglassantos.cursomc.domain.Pedido;
import com.douglassantos.cursomc.services.CategoriaService;
import com.douglassantos.cursomc.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pedido> find(@PathVariable Integer id){

        Pedido obj = pedidoService.buscar(id);
        return ResponseEntity.ok().body(obj);
    }
}
