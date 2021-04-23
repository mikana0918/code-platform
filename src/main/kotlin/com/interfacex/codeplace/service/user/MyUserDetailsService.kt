package com.interfacex.codeplace.service.user

import com.interfacex.codeplace.entity.IUser
import com.interfacex.codeplace.entity.LoginUser
import com.interfacex.codeplace.enum.UserRoleType
import com.interfacex.codeplace.repository.IUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import kotlin.jvm.Throws

@Service
open class MyUserDetailsService @Autowired constructor(private val userRepository: IUserRepository): UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String?): UserDetails? {
        var user: IUser? = userRepository.findByEmail(username)

        if(user?.email == null || user?.password == null) throw Exception("emailもしくはパスワードが見つかりませんでした")
        
        return LoginUser(
            user.email,
            user.password!!,
            user?.getAuthorities()
        )
    }
}