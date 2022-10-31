package br.com.alura.comex.dto.saida;

import br.com.alura.comex.model.Produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoSDTO {

    private String nome;
    private String descricao;
    private BigDecimal precoUnitario;
    private Integer quantidadeEstoque;
    private Long idCategoria;
    private String nomeCategoria;

    public ProdutoSDTO(Produto produto){
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.precoUnitario = produto.getPrecoUnitario();
        this.quantidadeEstoque = produto.getQuantidadeEstoque();
        this.idCategoria = produto.getCategoria().getId();
        this.nomeCategoria = produto.getCategoria().getNome();
    }

    public static List<ProdutoSDTO> converter(List<Produto> produtos){
        return produtos.stream().map(ProdutoSDTO::new).collect(Collectors.toList());

    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }
}
