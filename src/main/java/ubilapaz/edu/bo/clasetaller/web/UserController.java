package ubilapaz.edu.bo.clasetaller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubilapaz.edu.bo.clasetaller.domain.User;
import ubilapaz.edu.bo.clasetaller.dto.UserDto;
import ubilapaz.edu.bo.clasetaller.dto.UsuarioDto;
import ubilapaz.edu.bo.clasetaller.persistence.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/list")
    public ResponseEntity<List<User>> list(){
        List<User> userList = userRepository.findAll();
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<String> crear(@RequestBody UserDto userDto){
        //Se crea un objeto de la tabla con los datos
        User user = new User();
        user.setNombre(userDto.nombre);
        user.setUsername(userDto.username);
        user.setPassword(userDto.password);
        user.setFechaRegistro(LocalDateTime.now());
        //registrar el objeto
        try{
            userRepository.save(user);
            return new ResponseEntity<String>("Registro Exitoso", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return new ResponseEntity<String>("Registro Fallido",HttpStatus.OK);
        }
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editar(@PathVariable("id") int id,@RequestBody UserDto userDto){
        User user = new User();
        user.setId(id);
        user.setNombre(userDto.nombre);
        user.setUsername(userDto.username);
        user.setPassword(userDto.password);
        user.setFechaModificacion(LocalDateTime.now());
        userRepository.save(user);
        return new ResponseEntity<String>("Usuario Modificado",HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<String> eliminar(@PathVariable("id") int id){
        userRepository.deleteById(id);
        return new ResponseEntity<String>("DELETE",HttpStatus.OK);
    }

    @GetMapping("/reporte")
    public ResponseEntity<List<UserDto>> reporte(){
        List<UserDto> userList = userRepository.obtenerLista();
        return new ResponseEntity<List<UserDto>>(userList, HttpStatus.OK);
    }
}
