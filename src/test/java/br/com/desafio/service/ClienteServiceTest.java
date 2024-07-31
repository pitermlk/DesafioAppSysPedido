package br.com.desafio.service;

import br.com.desafio.model.Cliente;
import br.com.desafio.repository.ClienteRepository;
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

class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllClientes_ShouldReturnAllClients() {
        // Arrange
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente1, cliente2));

        // Act
        List<Cliente> result = clienteService.getAllClientes();

        // Assert
        assertNotNull(result);
        assertEquals(2, ((List<?>) result).size());
        verify(clienteRepository).findAll();
    }

    @Test
    void getClienteById_ShouldReturnClientWhenExists() {
        // Arrange
        Long id = 1L;
        Optional<Cliente> cliente = Optional.of(new Cliente());
        when(clienteRepository.findById(id)).thenReturn(cliente);

        // Act
        Optional<Cliente> result = clienteService.getClienteById(id);

        // Assert
        assertTrue(result.isPresent());
        verify(clienteRepository).findById(id);
    }

    @Test
    void createCliente_ShouldCreateAndReturnClient() {
        // Arrange
        Cliente cliente = new Cliente();
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        // Act
        Cliente createdCliente = clienteService.createCliente(cliente);

        // Assert
        assertNotNull(createdCliente);
        verify(clienteRepository).save(cliente);
    }
}