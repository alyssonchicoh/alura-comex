package br.com.alura.comex.controller;

import br.com.alura.comex.dto.RelatorioCategoriaDTO;
import br.com.alura.comex.dto.entrada.CategoriaEDTO;
import br.com.alura.comex.dto.saida.CategoriaSDTO;
import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.repository.PedidoRepository;
import br.com.alura.comex.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController extends  GenericController{

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public ResponseEntity<CategoriaSDTO> inserir(@RequestBody @Valid CategoriaEDTO categoriaEDTO, UriComponentsBuilder uriBuilder){
        Categoria categoria = this.categoriaService.salvar(categoriaEDTO.toCategoria());
        return ResponseEntity
                .created(super.construirURI(uriBuilder,"/topicos/{id}",categoria.getId()))
                .body(new CategoriaSDTO(categoria));

    }

    @GetMapping("/pedidos")
    public List<RelatorioCategoriaDTO> consultarRelatorioPedidoPorCategoria(){
        return this.pedidoRepository.relatorio();
    }
}
