package edu.ifpb.dac.view;

import edu.ifpb.dac.Pessoa;
import edu.ifpb.dac.CadastroPessoa;
import edu.ifpb.dac.util.JsfUtil;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB; 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "controlador")
@SessionScoped
public class PessoaController implements Serializable {

    private Pessoa pessoa = new Pessoa();
    private List<Pessoa> list;
    
    @EJB
    private CadastroPessoa ejbFacade;

    public PessoaController() {
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String salvar() {
        try {
            ejbFacade.salvar(pessoa);
            JsfUtil.addSuccessMessage("Pessoa Salva Com Sucesso!!");
            pessoa = new Pessoa();
            return null;
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "Erro ao salvar");
            return null;
        }
    }
    
    

    public List<Pessoa> getList() {
        list=ejbFacade.pessoas();
        return list;
    }

    public void setList(List<Pessoa> list) {
        this.list = list;
    }

}
