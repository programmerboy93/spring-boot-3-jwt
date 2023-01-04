package snail.springboot3jwt.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import snail.springboot3jwt.auth.payload.request.AuthenticationRequest;
import snail.springboot3jwt.auth.payload.response.AuthenticationResponse;
import snail.springboot3jwt.auth.payload.request.RegisterRequest;
import snail.springboot3jwt.user.ERole;
import snail.springboot3jwt.user.RoleRepository;
import snail.springboot3jwt.user.User;
import snail.springboot3jwt.user.UserRepository;

import javax.management.relation.RoleNotFoundException;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final JwtTokenService jwtTokenService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) throws RoleNotFoundException {
        User user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Set.of(roleRepository.findByName(ERole.ROLE_USER).orElseThrow(RoleNotFoundException::new)))
                .build();

        repository.save(user);

        return new AuthenticationResponse(jwtTokenService.generateToken(new CustomUserDetails(user)));
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword())
        );
        User user = repository.findByEmail(request.getEmail()).orElseThrow();

        String jwtToken = jwtTokenService.generateToken(new CustomUserDetails(user));

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}

