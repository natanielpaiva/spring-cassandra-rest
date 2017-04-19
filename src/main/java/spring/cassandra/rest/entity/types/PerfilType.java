package spring.cassandra.rest.entity.types;

import org.springframework.data.cassandra.mapping.UserDefinedType;

/**
 *
 * @author Nataniel Paiva
 */
@UserDefinedType("perfil")
public class PerfilType {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
