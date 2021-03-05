package com.example.springredditclone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.mail.internet.MimeMessage;
import java.io.InputStream;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
            .authorizeRequests()
            .antMatchers("/api/auth/**")
            .permitAll()
            .anyRequest()
            .authenticated()
        ;
    }

    @Bean
    public JavaMailSender javaMailSender() {
        return new JavaMailSender() {
            @Override
            public MimeMessage createMimeMessage() {
                return null;
            }

            @Override
            public MimeMessage createMimeMessage(InputStream inputStream) throws MailException {
                return null;
            }

            @Override
            public void send(MimeMessage mimeMessage) throws MailException {

            }

            @Override
            public void send(MimeMessage... mimeMessages) throws MailException {

            }

            @Override
            public void send(MimeMessagePreparator mimeMessagePreparator) throws MailException {

            }

            @Override
            public void send(MimeMessagePreparator... mimeMessagePreparators) throws MailException {

            }

            @Override
            public void send(SimpleMailMessage simpleMailMessage) throws MailException {

            }

            @Override
            public void send(SimpleMailMessage... simpleMailMessages) throws MailException {

            }
        };
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /*@Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }*/
}
