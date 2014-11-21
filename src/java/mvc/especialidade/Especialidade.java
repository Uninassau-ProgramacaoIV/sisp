
package mvc.especialidade;

public class Especialidade {
    private int codigo;
    private String descricao;
    
    public Especialidade() {
    }
    
    public Especialidade(int codigo, String descricao) {
        this.setCodigo(codigo);
        this.setDescricao(descricao);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
