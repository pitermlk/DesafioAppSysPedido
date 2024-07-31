package br.com.desafio.service;

import br.com.desafio.model.Pedido;
import br.com.desafio.repository.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class PedidoServiceTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @InjectMocks
    private PedidoService pedidoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllPedidos_ShouldReturnAllPedidos() {
        // Arrange
        Pedido pedido1 = new Pedido();
        Pedido pedido2 = new Pedido();
        when(pedidoRepository.findAll()).thenReturn(Arrays.asList(pedido1, pedido2));

        // Act
        List<Pedido> result = pedidoService.getAllPedidos();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(pedidoRepository).findAll();
    }

    @Test
    void getPedidoById_ShouldReturnPedidoWhenExists() {
        // Arrange
        Long id = 1L;
        Optional<Pedido> expectedPedido = Optional.of(new Pedido());
        when(pedidoRepository.findById(id)).thenReturn(expectedPedido);

        // Act
        Optional<Pedido> result = pedidoService.getPedidoById(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(expectedPedido, result);
        verify(pedidoRepository).findById(id);
    }

    @Test
    void createPedido_ShouldCreateAndReturnPedido() {
        // Arrange
        Pedido pedido = new Pedido();
        when(pedidoRepository.save(pedido)).thenReturn(pedido);

        // Act
        Pedido createdPedido = pedidoService.createPedido(pedido);

        // Assert
        assertNotNull(createdPedido);
        verify(pedidoRepository).save(pedido);
    }
}