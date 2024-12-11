package com.demirciyazilim.avukatrefwebsite.core.configurations;


import com.demirciyazilim.avukatrefwebsite.core.filters.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    private static final String[] WHITE_LIST_URLS = {
            "/swagger-ui/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/api/auth/**",
            "/api/fileUpload/upload",
    };
  

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeHttpRequests->
                        authorizeHttpRequests
                                // Bu URL'lere tüm kullanıcılar erişebilir
                                .requestMatchers(WHITE_LIST_URLS).permitAll()

                                // Admin erişimi gerektiren URL'ler
//                                .requestMatchers("/api/articles/**").hasRole("ADMIN")

                                // Kullanıcı ekleme, güncelleme, silme gibi işlemler için yetkilendirme
                                .requestMatchers(HttpMethod.POST, "/api/users/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/users/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")

                                //Contact görme, silme
                                .requestMatchers(HttpMethod.GET,"api/contacts/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"api/contacts/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE,"api/contacts/**").hasRole("ADMIN")



                                // Makale ekleme, düzenleme için admin yetkisi gerekli
                                .requestMatchers(HttpMethod.POST, "/api/articles/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/articles/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/articles/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET,"api/articles/**").permitAll()

                                // Diğer tüm isteklere kullanıcı girişi gereklidir.
                                .anyRequest().permitAll()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(Customizer.withDefaults())
                .logout(logout -> logout
                        .logoutUrl("/api/auth/logout")
                        .clearAuthentication(true)
                        .addLogoutHandler(logoutHandler)
                        .logoutSuccessHandler((request,response,authentication) -> SecurityContextHolder.clearContext())
                )
        ;

                return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*","http://localhost:5173"));
        configuration.setAllowedMethods(Arrays.asList("*","GET","POST","PUT","DELETE","OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization","Accept-Language","Accept","Content-Type","*"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
