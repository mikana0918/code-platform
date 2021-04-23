package com.interfacex.codeplace.entity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User

open class LoginUser(
    username: String, password: String,  authorities: MutableCollection<out GrantedAuthority>?
): User(username, password, authorities) {}