package ao.com.angotech.service.impl;

import ao.com.angotech.dto.AuthRequest;
import ao.com.angotech.enums.RoleEnum;
import ao.com.angotech.exception.CustomAuthenticationException;
import ao.com.angotech.model.User;
import ao.com.angotech.repository.UserRepository;
import ao.com.angotech.service.AuthService;
import ao.com.angotech.service.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public String register(AuthRequest request, RoleEnum role) {

        if (repository.findByEmail(request.getEmail()).isPresent() ) {
            throw new RuntimeException("Usuário já existe");
        }

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(role);

        repository.save(user);

        return "Usuário " + role.name() + " registrado com sucesso!";
    }

    @Override
    public String login(String email, String password) {

        return repository.findByEmail(email)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()))
                .map(user -> jwtTokenProvider.createTokenString(user.getEmail(), user.getRole()))
                .orElseThrow(() -> new CustomAuthenticationException("Usuário ou senha inválida."));
    }
}
