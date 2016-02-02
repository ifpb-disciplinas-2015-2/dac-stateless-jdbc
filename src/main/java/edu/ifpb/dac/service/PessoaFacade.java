/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.service;

import edu.ifpb.dac.CadastroPessoa;
import edu.ifpb.dac.infra.DaoJDBC;
import edu.ifpb.dac.Pessoa;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author Ricardo Job
 */
@Stateless
@Local(CadastroPessoa.class)
public class PessoaFacade implements CadastroPessoa {

    @EJB
    private DaoJDBC dao;

    @Override
    public void salvar(Pessoa entity) {
        dao.salvar(entity);
    }

    public List<Pessoa> pessoas() {
        return dao.listar();
    }

}
