package ubilapaz.edu.bo.clasetaller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    public String username;
    public String nombre;
    public String password;
}
