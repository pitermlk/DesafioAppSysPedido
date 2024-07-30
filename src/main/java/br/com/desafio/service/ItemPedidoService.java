package br.com.desafio.service;


import br.com.desafio.model.ItemPedido;
import br.com.desafio.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> getAllItens() {
        return itemPedidoRepository.findAll();
    }

    public List<ItemPedido> getItensByPedidoId(Long pedidoId) {
        return itemPedidoRepository.findByPedidoId(pedidoId);
    }

    public ItemPedido createItemPedido(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }
}