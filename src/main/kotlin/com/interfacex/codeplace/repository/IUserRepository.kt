package com.interfacex.codeplace.repository

import com.interfacex.codeplace.entity.IUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface  IUserRepository: JpaRepository<IUser, Long> {
    fun findByEmail(email: String?): IUser?
}