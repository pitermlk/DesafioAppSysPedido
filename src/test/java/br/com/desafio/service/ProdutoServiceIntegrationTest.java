package br.com.desafio.service;

import br.com.desafio.model.Produto;
import br.com.desafio.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.containers.MySQLContainer;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@SpringBootTest
public class ProdutoServiceIntegrationTest {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Container
    public static MySQLContainer<?> mysqlContainer = new MySQLContainer<>("mysql:8.0.26")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");

    @BeforeEach
    void setUp() {
        // Clear the database between tests
        produtoRepository.deleteAll();
    }

    @Test
    public void testGetAllProdutos() {
        Produto prod1 = new Produto("Produto 1", 10.00);
        Produto prod2 = new Produto("Produto 2", 15.50);
        produtoRepository.save(prod1);
        produtoRepository.save(prod2);

        assertEquals(2, produtoService.getAllProdutos().size(), "Should return all products");
    }

    @Test
    public void testGetProdutoById() {
        Produto prod = new Produto("Produto X", 20.00);
        prod = produtoRepository.save(prod);

        assertTrue(produtoService.getProdutoById(prod.getId()).isPresent(), "Product should be found by ID");
    }
    
}