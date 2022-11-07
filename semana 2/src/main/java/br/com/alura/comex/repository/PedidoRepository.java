package br.com.alura.comex.repository;

import br.com.alura.comex.dto.RelatorioCategoriaDTO;
import br.com.alura.comex.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {

    @Query(value =
            " select " +
            "   c.nome as nomeCategoria," +
            "   sum(ip.quantidade) as quantidadeProdutos," +
            "   sum(ip.preco_unitario * ip.quantidade) as montanteVendido " +
            " from itens_pedido ip " +
            " inner join produtos pr on (ip.produto_id = pr.id) " +
            " inner join categorias c on (pr.categoria_id = c.id) " +
            " group by c.nome",nativeQuery = true)
    public List<RelatorioCategoriaDTO> relatorio();
}
