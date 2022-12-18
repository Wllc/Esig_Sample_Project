package persistencia;
import dominio.Tarefa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TarefaDAO {
	public static void inserir(Tarefa tarefa) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = Conexao.getConexao();
			preparedStatement = con.prepareStatement("insert into tarefas (id, titulo, descricao, responsavel, prioridade, data, situacao) values (default,?,?,?,?,?,?)");
			preparedStatement.setString(1, tarefa.getTitulo());
			preparedStatement.setString(2, tarefa.getDescricao());
			preparedStatement.setString(3, tarefa.getResponsavel());
			preparedStatement.setString(4, tarefa.getPrioridade());
			preparedStatement.setString(5,  tarefa.getData());
			preparedStatement.setString(6, tarefa.getSituacao());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println("\nTarefa cadastrada!");
		} catch (Exception e) {
				System.out.println("\nErro: " + e);
		}
	}
	
	public static Tarefa buscarId(Tarefa tarefa) {
		Connection con = null;
		ResultSet resultSet = null;
		Tarefa t = null;
		try {
			con = Conexao.getConexao();
			resultSet = con.createStatement().executeQuery("select * from tarefas where id = " + tarefa.getId());
			while(resultSet.next()) {
				t = new Tarefa(resultSet.getLong("id") ,resultSet.getString("titulo"), resultSet.getString("descricao"), resultSet.getString("responsavel"), resultSet.getString("prioridade"), resultSet.getString("data"), resultSet.getString("situacao"));
			}
			con.close();
		} catch (Exception e) {
			System.out.println("\nErro: " + e);
		}
		return t;
	}
	
	
	public static ArrayList<Tarefa> listar(){
		Connection con = null;
        ResultSet resultSet = null;
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        try{
            con = Conexao.getConexao();
            resultSet = con.createStatement().executeQuery("select * from tarefas");
            while (resultSet.next()){
                tarefas.add(new Tarefa(resultSet.getLong("id") ,resultSet.getString("titulo"), resultSet.getString("descricao"), resultSet.getString("responsavel"), resultSet.getString("prioridade"), resultSet.getString("data"), resultSet.getString("situacao")));
            }
            con.close();
        }catch(SQLException e){
            System.out.println("\nErro: " + e);
        }
        return tarefas;
	}
	
	public static void atualizar(Tarefa tarefa) {
		 Connection con = null;
	     PreparedStatement preparedStatement = null;
	     
	     try {
			con = Conexao.getConexao();
			preparedStatement = con.prepareStatement("update tarefas set titulo = ?, descricao = ?, responsavel = ?, prioridade = ?, data = ? where id = ?");
			preparedStatement.setString(1, tarefa.getTitulo());
			preparedStatement.setString(2, tarefa.getDescricao());
			preparedStatement.setString(3, tarefa.getResponsavel());
			preparedStatement.setString(4, tarefa.getPrioridade());
			preparedStatement.setString(5, tarefa.getData());
			preparedStatement.setLong(6, tarefa.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println("\nTarefa atualizada!");
		} catch (Exception e) {
			System.out.println("\nErro: " + e);
		}
	}
	
	public static void remover(Tarefa tarefa) {
		Connection con = null;
		PreparedStatement preparedStatment = null;
		try {
			con = Conexao.getConexao();
			preparedStatment = con.prepareStatement("delete from tarefas where id = ?");
			preparedStatment.setLong(1, tarefa.getId());
			preparedStatment.executeUpdate();
			preparedStatment.close();
		} catch (Exception e) {
			System.out.println("\nErro: " + e);
		}
	}
	
	public static void concluir(Tarefa tarefa) {
		Connection con = null;
		PreparedStatement preparedStatment = null;
		String s = "completada";
		try {
			con = Conexao.getConexao();
			preparedStatment = con.prepareStatement("update tarefas set situacao = ? where id = ?");
			preparedStatment.setString(1, s);
			preparedStatment.setLong(2, tarefa.getId());
			preparedStatment.executeUpdate();
			preparedStatment.close();
		} catch (Exception e) {
			System.out.println("\nErro " + e);
		}
	}
}
