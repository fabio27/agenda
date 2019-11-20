
package br.com.ftec.agenda.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


 /* @author 018904
 */
public class ContatoDAO {
    public void SalvarContato(Contato contato) throws ClassNotFoundException, SQLException{
        
        String sql ="insert into agenda(nome,telefone,email)"+
                "values (?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        conn =  Conexao.criaConexao();
        pstm = conn.prepareStatement(sql);
        pstm.setString(1,contato.getNome());
        pstm.setString(2,contato.getTelefone());
        pstm.setString(3,contato.getEmail());
        pstm.execute();
        
    }
    public ArrayList<Contato> listarcontatos() throws ClassNotFoundException, SQLException{
        String sql = "Select * from agenda order by nome";//ordenar por nome
        
        Connection conn = null;//classe que aux para conexâo aqui tudo é java
        PreparedStatement pstm = null;//
        ResultSet rset = null;//
        
        
        conn = Conexao.criaConexao();
        pstm = conn.prepareStatement(sql);//?o que faz PrepareS...
        rset = pstm.executeQuery();
        ArrayList<Contato> listaContatos = new ArrayList<>();
        
        while(rset.next()){
            Contato contato = new Contato();
        contato.setId(rset.getInt("Id"));
        contato.setNome(rset.getString("nome"));
        contato.setEmail(rset.getString("email"));
        contato.setTelefone(rset.getString("telefone"));
        listaContatos.add(contato);
            
        }
        
       return listaContatos; 
    }
    
    public void excluirContato(int Id) throws ClassNotFoundException, SQLException{
        
        String sql = "delete from agenda where id="+Id;
        Connection conn = null;
        PreparedStatement pstm = null;
        conn = Conexao.criaConexao();
        pstm = conn.prepareStatement(sql);
        pstm.executeUpdate();
        
        
    }

    public Contato listarcontatosPorId(int valor) throws ClassNotFoundException, SQLException {
         String sql = "Select * from agenda where Id="+valor;//ordenar por nome
        
        Connection conn = null;//classe que aux para conexâo aqui tudo é java
        PreparedStatement pstm = null;//
        ResultSet rset = null;//
        
        
        conn = Conexao.criaConexao();
        pstm = conn.prepareStatement(sql);//?o que faz PrepareS...
        rset = pstm.executeQuery();
       Contato contato = new Contato();
        while(rset.next()){
            
        contato.setId(rset.getInt("Id"));
        contato.setNome(rset.getString("nome"));
        contato.setEmail(rset.getString("email"));
        contato.setTelefone(rset.getString("telefone"));
        
            
        }
        
       return contato; 
    }
}
