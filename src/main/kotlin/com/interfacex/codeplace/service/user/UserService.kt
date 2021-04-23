package com.interfacex.codeplace.service.user

import com.interfacex.codeplace.entity.IUser
import com.interfacex.codeplace.enum.UserRoleType
import com.interfacex.codeplace.repository.IUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
        private val userRepository: IUserRepository,
        val passwordEncoder: PasswordEncoder
    ){
    fun register(user: IUser) = userRepository.save(user)

    fun signUpUser(user: IUser): IUser {
        val encryptedPassword: String = passwordEncoder.encode(user.getPassword())
        return userRepository.save(
            user.copy(pass = encryptedPassword, roleType = UserRoleType.USER.toString())
        )
    }
}