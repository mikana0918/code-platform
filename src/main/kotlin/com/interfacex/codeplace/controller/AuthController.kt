package com.interfacex.codeplace.controller

import com.interfacex.codeplace.entity.IUser
import com.interfacex.codeplace.service.user.MyUserDetailsService
import com.interfacex.codeplace.service.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
class AuthController @Autowired constructor(private val userService: UserService) {
    /**
     * [View] [tmp] signup
     */
    @GetMapping("/signup")
    fun signupView(user: IUser): ModelAndView {
        return ModelAndView("/auth/signup").addObject(user)
    }

    /**
     * [API] [tmp] signup
     */
    @PostMapping("/signup")
    fun signup(
        user: IUser,
        redirectAttributes: RedirectAttributes
    ): String {
        userService.signUpUser(user) // アカウント作成
        return "redirect:/login"
    }
}