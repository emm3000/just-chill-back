package com.emm.justchill.features.user.infra

import io.jsonwebtoken.Claims
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtFilter(
    private val jwtUtils: JwtUtils,
    private val crudUserRepository: CrudUserRepository,
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        val authHeader = request.getHeader(HttpHeaders.AUTHORIZATION)

        val token = extractBearerToken(authHeader) ?: return filterChain.doFilter(request, response)
        val email = jwtUtils.extractClaim(token, Claims::getSubject) ?: return filterChain.doFilter(request, response)

        val user: UserDetails = crudUserRepository.findByEmail(email) ?: return filterChain.doFilter(request, response)

        if (jwtUtils.isTokenValid(token, user)) {
            authenticateUser(user, request)
        }

        filterChain.doFilter(request, response)
    }

    private fun extractBearerToken(header: String?): String? {
        return header?.takeIf { it.startsWith("Bearer ") }?.substringAfter("Bearer ")?.trim()
    }

    private fun authenticateUser(user: UserDetails, request: HttpServletRequest) {
        val authenticationToken = UsernamePasswordAuthenticationToken(user, null, user.authorities)
        authenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)
        SecurityContextHolder.getContext().authentication = authenticationToken
    }
}