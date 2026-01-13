package icet.mlslsenarathna.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthenticationDTO {
    private String email;
    private String password;
}
