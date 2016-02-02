/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.infra;

import edu.ifpb.dac.Pessoa;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ricardo Job
 */
@Stateless
public class DaoJPA  {

    @PersistenceContext(unitName = "av4")
    private EntityManager em;

    
    public void salvar(Pessoa entity) {
        em.persist(entity);
    }
    
    public List<Pessoa> pessoas(){
        return em.createQuery("Select p From Pessoa p", Pessoa.class).getResultList();
    }

}
