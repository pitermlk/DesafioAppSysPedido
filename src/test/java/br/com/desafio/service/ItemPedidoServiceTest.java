package br.com.desafio.service;

import br.com.desafio.model.ItemPedido;
import br.com.desafio.repository.ItemPedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemPedidoServiceTest {

    @Mock
    private ItemPedidoRepository itemPedidoRepository;

    @InjectMocks
    private ItemPedidoService itemPedidoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllItens_ShouldReturnAllItems() {
        // Arrange
        ItemPedido item1 = new ItemPedido();
        ItemPedido item2 = new ItemPedido();
        when(itemPedidoRepository.findAll()).thenReturn(Arrays.asList(item1, item2));

        // Act
        List<ItemPedido> result = itemPedidoService.getAllItens();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(itemPedidoRepository).findAll();
    }

    @Test
    void getItensByPedidoId_ShouldReturnItemsForGivenPedidoId() {
        // Arrange
        Long pedidoId = 1L;
        ItemPedido item1 = new ItemPedido();
        ItemPedido item2 = new ItemPedido();
        when(itemPedidoRepository.findByPedidoId(pedidoId)).thenReturn(Arrays.asList(item1, item2));

        // Act
        List<ItemPedido> result = itemPedidoService.getItensByPedidoId(pedidoId);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(itemPedidoRepository).findByPedidoId(pedidoId);
    }

    @Test
    void createItemPedido_ShouldCreateAndReturnItemPedido() {
        // Arrange
        ItemPedido itemPedido = new ItemPedido();
        when(itemPedidoRepository.save(itemPedido)).thenReturn(itemPedido);

        // Act
        ItemPedido createdItemPedido = itemPedidoService.createItemPedido(itemPedido);

        // Assert
        assertNotNull(createdItemPedido);
        verify(itemPedidoRepository).save(itemPedido);
    }
}