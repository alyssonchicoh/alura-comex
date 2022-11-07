package br.com.alura.comex.service;

import br.com.alura.comex.dto.RelatorioCategoriaDTO;
import br.com.alura.comex.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    public List<RelatorioCategoriaDTO> relatorioTotalPedidoPorCategoria(){
        return this.pedidoRepository.relatorio();
    }
}
