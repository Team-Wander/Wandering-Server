package com.wandering.Do.global.security.config;

import com.wandering.Do.global.security.filter.JwtFilter;
import com.wandering.Do.global.security.handler.JwtAccessDeniedHandler;
import com.wandering.Do.global.security.handler.JwtAuthenticationEntryPoint;
import com.wandering.Do.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http

                .csrf(AbstractHttpConfigurer::disable) // csrf 비활성화
                .cors(AbstractHttpConfigurer::disable)

                .formLogin(AbstractHttpConfigurer::disable) // 기본 login form 비활성화
                .logout(AbstractHttpConfigurer::disable) // 기본 logout 비활성화

                // X-Frame-Options 비활성화
                .headers(c -> c.frameOptions(
                        HeadersConfigurer.FrameOptionsConfig::disable).disable())

                // 인증 예외 핸들링
                .exceptionHandling((exceptionHandling) ->
                        exceptionHandling.authenticationEntryPoint(jwtAuthenticationEntryPoint)
                                .accessDeniedHandler(jwtAccessDeniedHandler))

                .sessionManagement((sessionManagement) ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests((authorizeRequests) ->
                        authorizeRequests
                                       
                                .requestMatchers(HttpMethod.POST, "/auth").permitAll()
                                .requestMatchers(HttpMethod.PATCH, "/auth").permitAll()
                                .requestMatchers(HttpMethod.DELETE, "/auth").authenticated()
                                .requestMatchers(HttpMethod.POST, "/auth/info").authenticated()

                                .requestMatchers(HttpMethod.GET, "/home/{pro_id}").authenticated()
                                .requestMatchers(HttpMethod.GET, "/home/filter").authenticated()
                                .requestMatchers(HttpMethod.GET, "/home").authenticated()
                                .requestMatchers(HttpMethod.POST, "/home").authenticated()
                                .requestMatchers(HttpMethod.POST, "/home/{pro_id}/declare").authenticated()
                                .requestMatchers(HttpMethod.POST, "/home/{pro_id}").authenticated()
                                .requestMatchers(HttpMethod.GET, "/home/search").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/home/{pro_id}").authenticated()
                                .requestMatchers(HttpMethod.PATCH, "/home/{pro_id}").authenticated()

                                .requestMatchers(HttpMethod.GET, "/my").authenticated()
                                .requestMatchers(HttpMethod.GET, "/my/reservation").authenticated()
                                .requestMatchers(HttpMethod.GET, "/my/{pro_id}/info").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/my/{pro_id}").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/my/{pro_id}/{user_id}").authenticated()

                                .requestMatchers(HttpMethod.GET, "/admin/dec_info").authenticated()
                                .requestMatchers(HttpMethod.GET, "/admin/{dec_id}").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/admin/{dec_id}").authenticated()
                                .requestMatchers(HttpMethod.GET, "/admin/user_info").authenticated()
                                .requestMatchers(HttpMethod.GET, "/admin").authenticated()
                                .requestMatchers(HttpMethod.PATCH, "/admin/{user_id}").authenticated()
                )

                .addFilterBefore(new JwtFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
