package br.com.alura.comex.dto.entrada;

import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.Produto;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProdutoEDTO {

    @NotNull @NotEmpty @Length(min = 2)
    private String nome;
    private String descricao;
    @NotNull @Min(value = 0)
    private BigDecimal precoUnitario;
    @NotNull
    private Integer quantidadeEstoque;
    @NotNull
    private Long idCategoria;

    public Produto toProduto(){
        Produto produto = new Produto();

        produto.setNome(this.nome);
        produto.setDescricao(this.descricao);
        produto.setPrecoUnitario(this.precoUnitario);
        produto.setQuantidadeEstoque(this.quantidadeEstoque);
        produto.setCategoria(new Categoria(this.idCategoria));

        return produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }
}
