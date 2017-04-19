package spring.cassandra.rest.controller;

import com.datastax.driver.core.utils.UUIDs;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.cassandra.rest.entity.Perfil;
import spring.cassandra.rest.repository.PerfilRepository;

/**
 *
 * @author Nataniel Paiva
 */
@RestController
public class PerfilController {

    @Autowired
    PerfilRepository repository;

    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public List<Perfil> list() {
        return (List<Perfil>) repository.findAll();
    }

    @RequestMapping(value = "/perfil", method = RequestMethod.POST)
    public Perfil save(@RequestBody Perfil perfil) {
        perfil.setId(UUIDs.timeBased().toString());
        return repository.save(perfil);
    }

    @RequestMapping(value = "/perfil", method = RequestMethod.PUT)
    public Perfil update(@RequestBody Perfil perfil) {
        return repository.save(perfil);
    }

    @RequestMapping(value = "/perfil/{id}", method = RequestMethod.GET)
    public Perfil getById(@PathVariable String id) {
        Perfil perfil = repository.findOne(id);
        return perfil;
    }

    @RequestMapping(value = "/perfil/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        repository.delete(id);
    }

}
