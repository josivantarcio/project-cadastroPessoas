package com.sinerji.service;

import com.sinerji.model.Pessoa;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Teste da classe PessoaService.
 * Contém testes para os métodos de criação, busca, atualização e deleção de
 * Pessoa.
 */
class PessoaServiceTest {

    private PessoaService pessoaService;
    private EntityManager entityManager;

    /**
     * Configura o ambiente de teste, criando uma instância de PessoaService e
     * mockando o EntityManager.
     */
    @BeforeEach
    void setUp() {
        // Criação do mock do EntityManager
        entityManager = Mockito.mock(EntityManager.class);

        // Instanciando o serviço e injetando o mock
        pessoaService = new PessoaService();
        pessoaService.entityManager = entityManager; // Injeção manual do mock
    }

    /**
     * Testa a criação de uma nova pessoa.
     */
    @Test
    void testCriarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("José");

        // Chama o método para persistir a pessoa
        pessoaService.criar(pessoa);

        // Verifica se o método persist foi chamado uma vez
        Mockito.verify(entityManager, Mockito.times(1)).persist(pessoa);
    }

    /**
     * Testa a busca de uma pessoa por ID.
     */
    @Test
    void testBuscarPessoaPorId() {
        Long id = 1L;
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        pessoa.setNome("José");

        // Quando buscar por ID, retornar a pessoa mockada
        Mockito.when(entityManager.find(Pessoa.class, id)).thenReturn(pessoa);

        // Executa o método de busca
        Pessoa result = pessoaService.buscarPorId(id);

        // Verifica se o resultado não é nulo e se os dados estão corretos
        Assertions.assertNotNull(result, "A pessoa não deve ser nula.");
        Assertions.assertEquals("José", result.getNome(), "O nome da pessoa deve ser 'José'.");
        Assertions.assertEquals(id, result.getId(), "O ID da pessoa deve ser 1L.");
    }

    /**
     * Testa a atualização de uma pessoa.
     */
    @Test
    void testAtualizarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("José");

        // Chama o método para atualizar a pessoa
        pessoaService.atualizar(pessoa);

        // Verifica se o método merge foi chamado uma vez
        Mockito.verify(entityManager, Mockito.times(1)).merge(pessoa);
    }

    /**
     * Testa a deleção de uma pessoa.
     */
    @Test
    void testDeletarPessoa() {
        Long id = 1L;
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);

        // Quando buscar a pessoa pelo ID, retorna a pessoa mockada
        Mockito.when(entityManager.find(Pessoa.class, id)).thenReturn(pessoa);

        // Chama o método de deletar
        pessoaService.deletar(id);

        // Verifica se o método remove foi chamado uma vez
        Mockito.verify(entityManager, Mockito.times(1)).remove(pessoa);
    }
}
