package com.interfacex.codeplace.handler

import org.springframework.security.access.AccessDeniedException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.access.AccessDeniedHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 未認証のユーザーからのアクセスを拒否した場合のエラーレスポンスを返却
 */
class MyAuthenticationEntryPoint: AuthenticationEntryPoint {
    override fun commence(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authException: AuthenticationException?
    ) {
        // HTTPステータスのみ設定する
        response?.setStatus(HttpServletResponse.SC_UNAUTHORIZED)
    }
}

/**
 * 認証済みユーザーからのアクセスを拒否した際のエラーレスポンスを返却
 */
class MyAccessDeniedHandler: AccessDeniedHandler {
    override fun handle(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        accessDeniedException: AccessDeniedException?
    ) {
        // HTTPステータスのみ設定する
        response?.setStatus(HttpServletResponse.SC_FORBIDDEN)
    }
}