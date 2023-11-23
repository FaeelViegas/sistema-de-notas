package model.bean;

public class Alunos {

    private int idAluno;
    private String nomeCompleto;
    private float nota1;
    private float nota2;
    private float media;
    private boolean aprovado;
    private float recuperacao;
    private String disciplina;

    public Alunos() {
    }

    public Alunos(int idAluno, String nomeCompleto, float nota1, float nota2, float media, float recuperacao,String disciplina, boolean aprovado) {
        this.idAluno = idAluno;
        this.nomeCompleto = nomeCompleto;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.media = media;
        this.recuperacao = recuperacao;
        this.disciplina = disciplina;
        this.aprovado = aprovado;

    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public float getRecuperacao() {
        return recuperacao;
    }

    public void setRecuperacao(float recuperacao) {
        this.recuperacao = recuperacao;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

}
