package ubilapaz.edu.bo.clasetaller.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ubilapaz.edu.bo.clasetaller.domain.Rol_User;
import ubilapaz.edu.bo.clasetaller.dto.UsuarioDto;

import java.util.List;

@Repository
public interface RolUserRepository extends JpaRepository<Rol_User,Integer> {

    @Query(value = "SELECT new ubilapaz.edu.bo.clasetaller.dto.UsuarioDto(u.nombre, u.username, r.codigo) FROM User u JOIN Rol_User r ON r.id_user = u.id")
    List<UsuarioDto> obtenerUsuarios();
}
