package spring.cassandra.rest.entity;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
import spring.cassandra.rest.entity.types.PerfilType;

@Table
public class Usuario {

    @PrimaryKey
    private String id;

    @Column(value = "nome")
    private String nome;

    @Column(value = "idade")
    private int idade;

    private PerfilType perfil;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public PerfilType getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilType perfil) {
        this.perfil = perfil;
    }

}
