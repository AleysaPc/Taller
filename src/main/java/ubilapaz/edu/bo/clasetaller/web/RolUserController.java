package ubilapaz.edu.bo.clasetaller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubilapaz.edu.bo.clasetaller.domain.Rol_User;
import ubilapaz.edu.bo.clasetaller.dto.RolUserDto;
import ubilapaz.edu.bo.clasetaller.dto.UsuarioDto;
import ubilapaz.edu.bo.clasetaller.persistence.RolUserRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/rolUser")
public class RolUserController {
    @Autowired
    private RolUserRepository rolUserRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Rol_User>> list(){
        List<Rol_User> rolUserList = rolUserRepository.findAll();
        return new ResponseEntity<List<Rol_User>>(rolUserList, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<String> crear(@RequestBody RolUserDto rolUserDto){
        try {
            Rol_User rolUser = new Rol_User();
            rolUser.setId_user(rolUserDto.id_user);
            rolUser.setCodigo(rolUserDto.cod);
            rolUser.setFechaRegistro(LocalDateTime.now());
            if(rolUser.codigo.equals("ADM") || rolUser.codigo.equals("USU") || rolUser.codigo.equals("JEF")){
                rolUserRepository.save(rolUser);
                return new ResponseEntity<String>("Registro Exitoso", HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("No se pudo registrar el campo CODIGO", HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return new ResponseEntity<String>("Registro Fallido", HttpStatus.OK);
        }
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editar(@PathVariable("id") int id,@RequestBody RolUserDto rolUserDto){
        try {
            Rol_User rolUser = new Rol_User();
            rolUser.setId(id);
            rolUser.setId_user(rolUserDto.id_user);
            rolUser.setCodigo(rolUserDto.cod);
            rolUser.setFechaModificacion(LocalDateTime.now());
            if(rolUser.codigo.equals("ADM") || rolUser.codigo.equals("USU") || rolUser.codigo.equals("JEF")){
                rolUserRepository.save(rolUser);
                return new ResponseEntity<String>("Rol de Ususario Modificado",HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Error al modificar el Rol de Usuario", HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return new ResponseEntity<String>("Error al Modificar",HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") int id){
        try {
            rolUserRepository.deleteById(id);
            return new ResponseEntity<String>("Rol de usuario Eliminado",HttpStatus.OK);
        } catch (Exception e){
            System.out.println("Error: "+e);
            return new ResponseEntity<String>("Error al Eliminar", HttpStatus.OK);
        }
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioDto>> consulta(){
        List<UsuarioDto> usuarioList = rolUserRepository.obtenerUsuarios();
        return  new ResponseEntity<List<UsuarioDto>>(usuarioList, HttpStatus.OK);
    }

}
