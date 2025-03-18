package com.sinerji.service;

import com.sinerji.model.Pessoa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Serviço responsável pelas operações CRUD (Create, Read, Update, Delete) para
 * a entidade Pessoa.
 */
@Stateless
public class PessoaService {

    /**
     * Gerenciador de entidades para interagir com o banco de dados.
     */
    @PersistenceContext(unitName = "cadastroPU")
    private EntityManager entityManager;

    /**
     * Cria uma nova pessoa no banco de dados.
     *
     * @param pessoa A pessoa a ser salva.
     */
    public void criar(Pessoa pessoa) {
        entityManager.persist(pessoa);
    }

    /**
     * Método que delega a criação de uma pessoa no banco de dados.
     * Também pode ser utilizado para salvar uma pessoa, criando ou atualizando.
     *
     * @param pessoa A pessoa a ser salva.
     */
    public void salvar(Pessoa pessoa) {
        if (pessoa.getId() == null) {
            criar(pessoa); // Cria uma nova pessoa
        } else {
            atualizar(pessoa); // Atualiza a pessoa existente
        }
    }

    /**
     * Busca uma pessoa pelo seu ID.
     *
     * @param id O ID da pessoa a ser buscada.
     * @return A pessoa encontrada ou null se não encontrada.
     */
    public Pessoa buscarPorId(Long id) {
        return entityManager.find(Pessoa.class, id);
    }

    /**
     * Lista todas as pessoas cadastradas no banco de dados.
     *
     * @return Uma lista contendo todas as pessoas.
     */
    public List<Pessoa> listarTodas() {
        return entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
    }

    /**
     * Atualiza os dados de uma pessoa no banco de dados.
     *
     * @param pessoa A pessoa com os dados atualizados.
     */
    public void atualizar(Pessoa pessoa) {
        entityManager.merge(pessoa);
    }

    /**
     * Deleta uma pessoa pelo seu ID.
     *
     * @param id O ID da pessoa a ser excluída.
     */
    public void deletar(Long id) {
        Pessoa pessoa = buscarPorId(id);
        if (pessoa != null) {
            entityManager.remove(pessoa);
        }
    }
}
