package com.example.Security;

import java.util.Date;

import com.example.model.Token;
import com.example.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
/**
 *
 * @author Administrador
 */
public class SecurityToken {
    public static final String SECRET_KEY = "#%Llkmf124G1Q#";
    public static final String TOKEN_HEADER = "Authorization";
    public static final String NOT_AUTHORIZED_MESSAGE = "NOT Authorized. HTTP Error 401. The requested resource requires user Authentication.";
    
    public static Token getToken(User usuario){
        String jwtToken = "";
        jwtToken = Jwts.builder()
                .setSubject(usuario.getName())
                .claim( "usuario", usuario.getName() )
                .setIssuedAt( new Date() ).signWith(SignatureAlgorithm.HS512,SECRET_KEY)
                .compact();
        return new Token(jwtToken);
    }
    
    public static String getIdUser(String token) throws Exception{
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token.replace("Bearer", "")) 
                    .getBody()
                    .getSubject();
            return user;
        }
        throw new Exception("Usuario no identificado.");
    }
    
    
}

