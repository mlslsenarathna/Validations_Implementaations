package icet.mlslsenarathna.model.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {
    private String firstName;
    private String lastName;

    private String email;
    private String password;
}
