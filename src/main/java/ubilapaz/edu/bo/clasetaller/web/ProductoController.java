package ubilapaz.edu.bo.clasetaller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubilapaz.edu.bo.clasetaller.domain.Producto;
import ubilapaz.edu.bo.clasetaller.domain.User;
import ubilapaz.edu.bo.clasetaller.dto.ProductoDto;
import ubilapaz.edu.bo.clasetaller.dto.UserDto;
import ubilapaz.edu.bo.clasetaller.dto.UsuarioDto;
import ubilapaz.edu.bo.clasetaller.persistence.ProductoRepository;
import ubilapaz.edu.bo.clasetaller.persistence.UserRepository;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Producto>> list() {
        List<Producto> productoList = productoRepository.findAll();
        return new ResponseEntity<List<Producto>>(productoList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> crear(@RequestBody ProductoDto productoDto) {
        //Se crea un objeto de la tabla con los datos

        Producto producto = new Producto();
        producto.setCodigo(String.valueOf(productoDto.codigo));

        producto.setNombre(productoDto.nombre);
        producto.setPrecio(productoDto.precio);
        producto.setFechaRegistro(LocalDateTime.now());
        //registrar el objeto
        try {
            productoRepository.save(producto);
            return new ResponseEntity<String>("Registro Exitoso", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return new ResponseEntity<String>("Registro Fallido", HttpStatus.OK);
        }
    }

}