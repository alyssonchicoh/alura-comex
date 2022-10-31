package br.com.alura.comex.service;

import br.com.alura.comex.exception.ObjetoNaoEncontradoException;
import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.Produto;
import br.com.alura.comex.repository.CategoriaRepository;
import br.com.alura.comex.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository,CategoriaRepository categoriaRepository){
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional
    public Produto salvar (Produto produto) throws ObjetoNaoEncontradoException{
        if(!categoriaRepository.findById(produto.getCategoria().getId()).isPresent()){
            throw new ObjetoNaoEncontradoException("Categoria");
        }

        return this.produtoRepository.save(produto);
    }

    @Transactional
    public Page<Produto> listar(int page, int size){
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "nome"
        );

        return this.produtoRepository.findAll(pageRequest);

    }

}
