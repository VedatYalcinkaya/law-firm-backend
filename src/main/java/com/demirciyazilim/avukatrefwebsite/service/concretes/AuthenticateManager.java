package com.demirciyazilim.avukatrefwebsite.service.concretes;


import com.demirciyazilim.avukatrefwebsite.core.services.JwtService;
import com.demirciyazilim.avukatrefwebsite.core.utilities.mapper.ModelMapperService;
import com.demirciyazilim.avukatrefwebsite.dto.auth.requests.AuthRequest;
import com.demirciyazilim.avukatrefwebsite.dto.auth.requests.RegisterUserRequest;
import com.demirciyazilim.avukatrefwebsite.dto.auth.response.AuthResponse;
import com.demirciyazilim.avukatrefwebsite.dto.user.requests.AddUserRequest;
import com.demirciyazilim.avukatrefwebsite.repository.UserRepository;
import com.demirciyazilim.avukatrefwebsite.service.abstracts.AuthenticationService;
import com.demirciyazilim.avukatrefwebsite.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.demirciyazilim.avukatrefwebsite.entity.User;


@Service
@AllArgsConstructor
public class AuthenticateManager implements AuthenticationService {


    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapperService modelMapperService;
    private final JwtService jwtService;
    private final AuthenticationManager manager;
    @Override
    public AuthResponse register(RegisterUserRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .authorities(request.getAuthorities())
                .build();

        AddUserRequest addUserRequest = modelMapperService.forRequest().map(user, AddUserRequest.class);
        User savedUser = userService.add(addUserRequest);


        var jwtToken = jwtService.generateToken(user);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }


    @Override
    public AuthResponse authenticate(AuthRequest request) {
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userService.getByEmail(request.getEmail());
        var jwtToken = jwtService.generateToken(modelMapperService.forResponse().map(user, User.class));
        return AuthResponse.builder()
                .token(jwtToken )
                .build();
    }
}
