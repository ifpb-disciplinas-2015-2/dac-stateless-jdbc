/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.service;

import edu.ifpb.dac.Pessoa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ricardo Job
 */
@Stateless
public class PessoaFacade implements CadastroPessoa {

    @PersistenceContext(unitName = "av4")
    private EntityManager em;

    @Override
    public void salvar(Pessoa entity) {
        em.persist(entity);
    }

    
    /**Informações:   EJB5181:Portable JNDI 
    names for EJB PessoaFacade: [java:global/ExemploSessionBean/PessoaFacade, 
    * java:global/ExemploSessionBean/PessoaFacade!edu.ifpb.dac.service.CadastroPessoa]*/
}
