package br.com.alura.comex.service;

import br.com.alura.comex.dto.entrada.CategoriaEDTO;
import br.com.alura.comex.dto.saida.CategoriaSDTO;
import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;


    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional
    public Categoria salvar (Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }
}
