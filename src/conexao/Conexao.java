package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String url = "jdbc:mysql://localhost:3306/senai_alunos?useSSL=false";
    private static final String user = "root";
    private static final String password = "1234";

    public static Connection conectar() throws SQLException {
        return (Connection) DriverManager.getConnection(url, user, password);
    }
}
