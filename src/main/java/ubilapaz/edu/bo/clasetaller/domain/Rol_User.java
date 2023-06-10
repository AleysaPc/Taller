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
@Table(name = "rol_user")

public class Rol_User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Integer id;

    @Column(name = "ID_USER")
    public Integer id_user;

    @Column(name = "CODIGO")
    public String codigo;

    @Column(name = "FECHA_REGISTRO")
    public LocalDateTime fechaRegistro;
    @Column(name = "FECHA_MODIFICACION")
    public LocalDateTime fechaModificacion;
}
