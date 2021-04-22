package com.interfacex.codeplace.service.user

import com.interfacex.codeplace.entity.IUser
import com.interfacex.codeplace.repository.IUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import kotlin.jvm.Throws

open class MyUserDetailsService @Autowired constructor(private val userRepository: IUserRepository): UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String?): UserDetails? {
        var iUser: IUser? = userRepository.findByEmail(username)

        return iUser
    }
}