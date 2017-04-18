package spring.cassandra.rest.controller;

import com.datastax.driver.core.utils.UUIDs;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.cassandra.rest.entity.Usuario;
import spring.cassandra.rest.repository.UsuarioRepository;

/**
 *
 * @author Nataniel Paiva
 */
@RestController
public class UsuarioController {

    @Autowired
    UsuarioRepository repository;

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public List<Usuario> list() {
        return (List<Usuario>) repository.findAll();
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public Usuario save(@RequestBody Usuario usuario) {
        usuario.setId(UUIDs.timeBased().toString());
        return repository.save(usuario);
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.PUT)
    public Usuario update(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    public Usuario getById(@PathVariable String id) {
        Usuario usuario = repository.findOne(id);
        return usuario;
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        repository.delete(id);
    }

}
