package br.com.alura.comex.controller;

import br.com.alura.comex.dto.entrada.ProdutoEDTO;
import br.com.alura.comex.dto.saida.ProdutoSDTO;
import br.com.alura.comex.exception.ObjetoNaoEncontradoException;
import br.com.alura.comex.model.Produto;
import br.com.alura.comex.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produto")
public class ProdutoController extends GenericController{

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoSDTO> inserir(@RequestBody @Valid ProdutoEDTO produtoEDTO, UriComponentsBuilder uriBuilder){
        Produto produto = this.produtoService.salvar(produtoEDTO.toProduto());
        return ResponseEntity
                .created(super.construirURI(uriBuilder,"/produto/{id}",produto.getId()))
                .body(new ProdutoSDTO(produto));

    }


    @GetMapping

    public List<ProdutoSDTO> listar(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size
    ) {

        Page<Produto> produtos = this.produtoService.listar(page,size);
        
        return ProdutoSDTO.converter(produtos.get().collect(Collectors.toList()));
    }
}
