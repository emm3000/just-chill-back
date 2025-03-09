package com.emm.justchill.features.user.infra

import com.emm.justchill.features.user.domain.User
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.security.core.userdetails.UserDetails
import java.util.Date
import javax.crypto.SecretKey

class JwtUtils(private val secret: String) {

    fun createToken(user: User): String {
        val roles: String = user.role.name
        val claims: Claims = Jwts.claims()
            .add("roles", roles)
            .build()
        val subject = Jwts.builder()
            .subject(user.email)
            .claims(claims)
            .issuedAt(Date(System.currentTimeMillis()))
            .expiration(Date(System.currentTimeMillis() + 1000 * 60 * 24))
            .signWith(createSignKey())
            .compact()
        return subject
    }

    fun isTokenValid(token: String, user: UserDetails): Boolean {
        val email: String = extractClaim(token, Claims::getSubject) ?: return true
        return email == user.username && isTokenExpired(token).not()
    }

    private fun isTokenExpired(token: String): Boolean {
        val extractClaim: Date = extractClaim(token, Claims::getExpiration) ?: return true
        return extractClaim.before(Date())
    }

    private fun createSignKey(): SecretKey {
        val decode = Decoders.BASE64.decode(secret)
        val key: SecretKey = Keys.hmacShaKeyFor(decode)
        return key
    }

    fun <T> extractClaim(token: String, extract: (Claims) -> T): T? {
        val claims = extractClaimsFromToken(token)
        return extract(claims)
    }

    private fun extractClaimsFromToken(token: String): Claims {
        return Jwts.parser()
            .verifyWith(createSignKey())
            .build()
            .parseSignedClaims(token)
            .payload
    }
}