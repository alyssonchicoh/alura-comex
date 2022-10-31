package br.com.alura.comex.dto.entrada;

import br.com.alura.comex.model.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoriaEDTO {
    @NotNull
    @NotEmpty
    @Length(min = 2)
    private String nome;

    public Categoria toCategoria(){
        Categoria categoria = new Categoria();

        categoria.setNome(nome);
        return categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
