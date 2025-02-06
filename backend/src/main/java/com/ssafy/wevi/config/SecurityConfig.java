package com.ssafy.wevi.config;


import com.ssafy.wevi.config.security.HttpStatusAccessDeniedHandler;
import com.ssafy.wevi.config.security.HttpStatusAuthenticationSuccessHandler;
import com.ssafy.wevi.filter.LoggingFilter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationEntryPointFailureHandler;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationEventPublisher authenticationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        return new DefaultAuthenticationEventPublisher(applicationEventPublisher);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        var authenticationEntryPoint = new HttpStatusEntryPoint(HttpStatus.FORBIDDEN);
        var accessDeniedHandler = new HttpStatusAccessDeniedHandler(HttpStatus.FORBIDDEN);

        return http
                .formLogin(configurer -> configurer
                        // POSTMAN 테스트랑 프론트한테 /auth/login만 RequestBody가 form-data여야 한다고 전달하기
                        // parameter는 username, password임
                        .loginProcessingUrl("/api/auth/login")
                        .successHandler(new HttpStatusAuthenticationSuccessHandler(HttpStatus.OK))
                        .failureHandler(new AuthenticationEntryPointFailureHandler(authenticationEntryPoint))
                        .permitAll(true)
                ).logout(configurer -> configurer
                        .logoutRequestMatcher(new AntPathRequestMatcher("/api/auth/logout", "POST", true))
                        .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
                        .permitAll(true)
                )
                .authorizeHttpRequests(registry -> registry
                        .requestMatchers(
                                // 로그인 안했어도 요청 가능한 API는 여기 추가해주기
                                new AntPathRequestMatcher("/api/auth/login", "POST"),
                                new AntPathRequestMatcher("/api/customers/signup", "POST")
                        ).permitAll()
                        .anyRequest().authenticated())
                .exceptionHandling(customizer -> customizer
                        .authenticationEntryPoint(authenticationEntryPoint)
                        .accessDeniedHandler(accessDeniedHandler))
                .addFilterBefore(new LoggingFilter(), HeaderWriterFilter.class)
                .rememberMe(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .requestCache(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .build();
    }
}
