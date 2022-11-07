package br.com.alura.comex.dto.saida;

import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.StatusCategoria;

public class CategoriaSDTO {

    private Long id;
    private String nome;
    private StatusCategoria status;


    public CategoriaSDTO(Categoria categoria){
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.status = categoria.getStatus();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public StatusCategoria getStatus() {
        return status;
    }
}
