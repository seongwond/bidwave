package com.bidwave.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().permitAll()  // 모든 요청에 대해 인증 없이 접근 허용
                )
                .formLogin(form -> form
                        .loginPage("/login")  // 로그인 페이지 URL 설정
                        .loginProcessingUrl("/login")  // 로그인 처리 URL
                        .defaultSuccessUrl("/main", true)  // 로그인 성공 후 /main으로 이동
                        .failureUrl("/login?error=true")  // 로그인 실패 시 에러 메시지 표시용 URL
                        .permitAll()  // 로그인 페이지는 누구나 접근 가능
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")  // 로그아웃 URL
                        .logoutSuccessUrl("/login?logout")  // 로그아웃 후 리다이렉트 URL
                        .invalidateHttpSession(true)  // 세션 무효화
                        .deleteCookies("JSESSIONID")  // 쿠키 삭제
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
