package com.sinerji.bean;

import com.sinerji.model.Pessoa;
import com.sinerji.service.PessoaService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * ManagedBean responsável pela manipulação dos dados de pessoa.
 * Este bean gerencia as operações de criação, edição, exclusão e listagem de
 * pessoas.
 */
@ManagedBean
@RequestScoped
public class PessoaBean {

    /**
     * Representa uma pessoa a ser manipulada.
     */
    private Pessoa pessoaAtual = new Pessoa(); // Renomeado para 'pessoaAtual'

    /**
     * Serviço para realizar operações sobre a pessoa.
     */
    private PessoaService pessoaService = new PessoaService();

    /**
     * Lista de todas as pessoas cadastradas.
     */
    private List<Pessoa> pessoas;

    /**
     * Salva a pessoa e redireciona para a página de listagem.
     *
     * @return A string de navegação para a página de listagem.
     */
    public String salvar() {
        pessoaService.salvar(pessoaAtual); // Alterado para 'pessoaAtual'
        return "listagemPessoas?faces-redirect=true"; // Redireciona para a lista após salvar
    }

    /**
     * Obtém a lista de todas as pessoas cadastradas.
     *
     * @return A lista de pessoas.
     */
    public List<Pessoa> getPessoas() {
        return pessoaService.listarTodas();
    }

    /**
     * Edita a pessoa e redireciona para a página de listagem.
     *
     * @return A string de navegação para a página de listagem.
     */
    public String editar() {
        pessoaService.atualizar(pessoaAtual); // Alterado para 'pessoaAtual'
        return "listagemPessoas?faces-redirect=true"; // Redireciona para a lista após editar
    }

    /**
     * Exclui a pessoa e não retorna nada, já que o redirecionamento é feito na
     * lista.
     *
     * @param pessoa A pessoa a ser excluída.
     */
    public void excluir(Pessoa pessoa) {
        pessoaService.deletar(pessoa.getId());
    }

    // Getters e Setters

    /**
     * Obtém a pessoa a ser manipulada.
     *
     * @return A pessoa.
     */
    public Pessoa getPessoa() {
        return pessoaAtual; // Alterado para 'pessoaAtual'
    }

    /**
     * Define a pessoa a ser manipulada.
     *
     * @param pessoa A pessoa a ser definida.
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoaAtual = pessoa; // Alterado para 'pessoaAtual'
    }
}
