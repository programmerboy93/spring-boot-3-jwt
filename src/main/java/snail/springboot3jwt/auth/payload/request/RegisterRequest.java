package snail.springboot3jwt.auth.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import snail.springboot3jwt.auth.annotation.ValidPassword;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NonNull
    @NotEmpty
    private String firstname;

    @NonNull
    @NotEmpty
    private String lastname;

    @NonNull
    @NotEmpty
    @Email
    private String email;

    @NonNull
    @NotEmpty
    @ValidPassword
    private String password;

}
