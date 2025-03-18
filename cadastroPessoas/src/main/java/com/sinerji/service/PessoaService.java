package com.sinerji.service;

import com.sinerji.model.Pessoa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PessoaService {

    @PersistenceContext(unitName = "cadastroPU")
    private EntityManager entityManager;

    public void criar(Pessoa pessoa) {
        entityManager.persist(pessoa);
    }

    public Pessoa buscarPorId(Long id) {
        return entityManager.find(Pessoa.class, id);
    }

    public List<Pessoa> listarTodas() {
        return entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
    }

    public void atualizar(Pessoa pessoa) {
        entityManager.merge(pessoa);
    }

    public void deletar(Long id) {
        Pessoa pessoa = buscarPorId(id);
        if (pessoa != null) {
            entityManager.remove(pessoa);
        }
    }
}
