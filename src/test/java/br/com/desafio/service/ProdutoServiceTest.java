package br.com.desafio.service;

import br.com.desafio.model.Produto;
import br.com.desafio.repository.ProdutoRepository;
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

class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllProdutos_ShouldReturnAllProdutos() {
        // Arrange
        Produto produto1 = new Produto();
        Produto produto2 = new Produto();
        when(produtoRepository.findAll()).thenReturn(Arrays.asList(produto1, produto2));

        // Act
        List<Produto> result = produtoService.getAllProdutos();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(produtoRepository).findAll();
    }

    @Test
    void getProdutoById_ShouldReturnProdutoWhenExists() {
        // Arrange
        Long id = 1L;
        Optional<Produto> expectedProduto = Optional.of(new Produto());
        when(produtoRepository.findById(id)).thenReturn(expectedProduto);

        // Act
        Optional<Produto> result = produtoService.getProdutoById(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(expectedProduto, result);
        verify(produtoRepository).findById(id);
    }

    @Test
    void createProduto_ShouldCreateAndReturnProduto() {
        // Arrange
        Produto produto = new Produto();
        when(produtoRepository.save(produto)).thenReturn(produto);

        // Act
        Produto createdProduto = produtoService.createProduto(produto);

        // Assert
        assertNotNull(createdProduto);
        verify(produtoRepository).save(produto);
    }
}
