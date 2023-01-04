package snail.springboot3jwt.auth.payload.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    @NonNull
    @NotEmpty
    private String email;

    @NonNull
    @NotEmpty
    private String password;
}
