package model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Alunos;
import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import raven.toast.Notifications;


public class AlunosDAO {
    
    public List<Alunos> leitura(){
        List<Alunos> alunos = new ArrayList<>();
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement("SELECT * FROM alunos");
            rs = stmt.executeQuery();
            while(rs.next()){
                Alunos aluno = new Alunos();
                aluno.setIdAluno(rs.getInt("idAluno"));
                aluno.setNomeCompleto(rs.getString("nomeCompleto"));
                aluno.setNota1(rs.getFloat("nota1"));
                aluno.setNota2(rs.getFloat("nota2"));
                aluno.setMedia(rs.getFloat("media"));
                aluno.setRecuperacao(rs.getFloat("recuperacao"));
                aluno.setAprovado(rs.getBoolean("aprovado"));
                aluno.setDisciplina(rs.getString("disciplina"));
                alunos.add(aluno);          
            }
            rs.close();
            stmt.close();
            conexao.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunos;
    }
    
    public void cadastrarAluno(Alunos objAluno){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("INSERT INTO alunos(nomeCompleto,nota1,nota2,media,aprovado,disciplina)VALUES(?,?,?,?,?,?)");
            stmt.setString(1, objAluno.getNomeCompleto());
            stmt.setFloat(2, objAluno.getNota1());
            stmt.setFloat(3, objAluno.getNota2());
            stmt.setFloat(4, objAluno.getMedia());
            stmt.setBoolean(5, objAluno.isAprovado());
            stmt.setString(6, objAluno.getDisciplina());
            
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "ALUNO CADASTRADO COM SUCESSO!");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deletarCampo(Alunos objAluno){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("DELETE FROM alunos WHERE idAluno = ?");
            stmt.setInt(1, objAluno.getIdAluno());
            
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "CAMPO DELETADO COM SUCESSO!");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void alterarCampo(Alunos objAluno){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("UPDATE alunos SET nomeCompleto = ?,nota1 = ?,nota2 = ?,media = ?,recuperacao = ?,aprovado = ? WHERE idAluno = ?");
            stmt.setString(1,objAluno.getNomeCompleto());
            stmt.setFloat(2, objAluno.getNota1());
            stmt.setFloat(3, objAluno.getNota2());
            stmt.setFloat(4, objAluno.getMedia());
            stmt.setFloat(5, objAluno.getRecuperacao());
            stmt.setBoolean(6, objAluno.isAprovado());
            stmt.setInt(7, objAluno.getIdAluno());
            
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "CAMPO EDITADO COM SUCESSO!");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
