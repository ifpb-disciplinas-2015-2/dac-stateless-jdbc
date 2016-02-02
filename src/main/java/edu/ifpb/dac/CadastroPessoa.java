package edu.ifpb.dac;

import edu.ifpb.dac.Pessoa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo Job
 */

public interface CadastroPessoa {

    public void salvar(Pessoa pessoa);

    public List<Pessoa> pessoas();
}
