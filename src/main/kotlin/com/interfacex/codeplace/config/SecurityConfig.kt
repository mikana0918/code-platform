package com.interfacex.codeplace.config

import com.interfacex.codeplace.repository.IUserRepository
import com.interfacex.codeplace.service.user.MyUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.NoOpPasswordEncoder




@EnableWebSecurity
class SecurityConfig @Autowired constructor(private val userRepository: IUserRepository) : WebSecurityConfigurerAdapter(){
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .mvcMatchers("/login").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth
            .userDetailsService(MyUserDetailsService(userRepository)) // ④
    }

    @SuppressWarnings("deprecation")
    @Bean
    fun passwordEncoder(): NoOpPasswordEncoder? {
        return NoOpPasswordEncoder.getInstance() as NoOpPasswordEncoder
    }
}