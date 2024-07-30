package br.com.desafio.controller;


import br.com.desafio.model.ItemPedido;
import br.com.desafio.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens-pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public List<ItemPedido> getAllItens() {
        return itemPedidoService.getAllItens();
    }

    @GetMapping("/pedido/{pedidoId}")
    public List<ItemPedido> getItensByPedidoId(@PathVariable Long pedidoId) {
        return itemPedidoService.getItensByPedidoId(pedidoId);
    }

    @PostMapping
    public ItemPedido createItemPedido(@RequestBody ItemPedido itemPedido) {
        return itemPedidoService.createItemPedido(itemPedido);
    }
}