package ubilapaz.edu.bo.clasetaller.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ubilapaz.edu.bo.clasetaller.domain.Producto;
import ubilapaz.edu.bo.clasetaller.dto.UsuarioDto;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    /*@Query(value = "")
    List<Producto> obtenerUsuarios();*/
}