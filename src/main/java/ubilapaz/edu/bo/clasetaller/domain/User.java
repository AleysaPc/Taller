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
@Table(name = "user")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Integer id;

    @Column(name = "USERNAME")
    public String username;

    @Column(name = "NOMBRE")
    public String nombre;
    @Column(name = "PASSWORD")
    public String password;
    @Column(name = "FECHA_REGISTRO")
    public LocalDateTime fechaRegistro;
    @Column(name = "FECHA_MODIFICACION")
    public LocalDateTime fechaModificacion;

}
