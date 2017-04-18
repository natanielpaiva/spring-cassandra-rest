
package spring.cassandra.rest.repository;

import org.springframework.data.repository.CrudRepository;
import spring.cassandra.rest.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {


}
