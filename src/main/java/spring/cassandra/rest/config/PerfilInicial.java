package spring.cassandra.rest.config;

import com.datastax.driver.core.utils.UUIDs;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import spring.cassandra.rest.entity.Perfil;
import spring.cassandra.rest.repository.PerfilRepository;

/**
 *
 * @author Nataniel Paiva
 */
@Component
public class PerfilInicial implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    PerfilRepository perfilRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {

        Perfil perfil = new Perfil();
        
        perfil.setId(UUIDs.timeBased().toString());
        perfil.setNome("ROLE_ADMIN");

        List<Perfil> perfis = (List<Perfil>) perfilRepository.findAll();

        if (perfis.isEmpty()) {
            perfilRepository.save(perfil);
        }

    }

}
