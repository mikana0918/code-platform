package com.interfacex.codeplace.entity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="i_user")
data class IUser (
    @Id
    var id: Int = 0,

    @Column(name="email")
    var email: String = "",

    @Column(name="password")
    var pass: String? = "",

    @Column(name = "role_type")
    var roleType: String = ""
): UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
        return AuthorityUtils.createAuthorityList(this.roleType)
    }

    override fun getUsername(): String? {
        return this.email
    }


    override fun getPassword(): String? {
        return this.pass
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }
}



