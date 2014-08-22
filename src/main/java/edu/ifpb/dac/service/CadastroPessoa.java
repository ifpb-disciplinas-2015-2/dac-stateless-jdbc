package edu.ifpb.dac.service;

import edu.ifpb.dac.Pessoa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo Job
 */
@Local
public interface CadastroPessoa {

    public void salvar(Pessoa pessoa);

}
