package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection getConexao() throws SQLException {
        String usuario = "postgres";
        String senha = "postgres";
        String caminho = "jdbc:postgresql://localhost:5432/TerefasESIG";
        DriverManager.registerDriver(new org.postgresql.Driver());
        return DriverManager.getConnection(caminho, usuario, senha);
    }
}
