package ubilapaz.edu.bo.clasetaller.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Integer id;

    @Column(name = "CODIGO")
    public String codigo;

    @Column(name = "NOMBRE")
    public String nombre;

    @Column(name = "PRECIO")
    public Integer precio;

    @Column(name = "FECHA_REGISTRO")
    public LocalDateTime fechaRegistro;

    @Column(name = "FECHA_MODIFICACION")
    public LocalDateTime fechaModificacion;


    public void setCodigo(String codigo) {
        this.codigo = codigo.toUpperCase();
    }

}