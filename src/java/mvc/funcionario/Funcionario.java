package mvc.funcionario;

import mvc.cargo.Cargo;

public class Funcionario {
    
    private int codigo;
    private String nome;
    private Cargo cargo;
    private String nascimento;
    
    public Funcionario() {
        
    }
    
    public Funcionario(String nome, Cargo cargo, String nascimento) {
        this.nome = nome;
        this.cargo = cargo;
        this.nascimento = nascimento;
    }
    
    public Funcionario(int codigo, String nome, Cargo cargo, String nascimento) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.nascimento = nascimento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
}
