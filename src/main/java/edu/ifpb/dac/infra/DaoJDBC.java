package edu.ifpb.dac.infra;

import edu.ifpb.dac.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author Ricardo Job
 */
@Stateless
public class DaoJDBC {

    @Resource(name = "exemploDataSource")
//    @Resource(name = "jdbc/stateless")
    private DataSource dataSource;
    
    private Connection connection;

    public void salvar(Pessoa entity) {
        try {
//           Connection connection = dataSource.getConnection();
            String sql = "insert into Pessoa(id, nome) values(?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, entity.getId());
            ps.setString(2, entity.getNome());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Pessoa> listar() {
        try {
//            Connection connection = dataSource.getConnection();
            String sql = "select * FROM Pessoa order by ID";
//            String sql = "select * FROM STATELESS.PESSOA order by ID";
            PreparedStatement ps = connection.prepareStatement(sql);
            return createPessoa(ps.executeQuery());

        } catch (SQLException ex) {
            Logger.getLogger(DaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<Pessoa> createPessoa(ResultSet rs) throws SQLException {
        List<Pessoa> lista = new ArrayList<>();
        while (rs.next()) {
            long id = rs.getLong("ID");
            String nome = rs.getString("NOME");
            lista.add(new Pessoa(id, nome));
        }
        return lista;
    }

    @PostConstruct
    public void init() {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PreDestroy
    public void fechar() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
