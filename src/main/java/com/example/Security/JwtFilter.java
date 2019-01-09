package com.example.Security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
public class JwtFilter extends GenericFilterBean{

    public void doFilter( final ServletRequest servletRequest, final ServletResponse servletResponse,
                          final FilterChain filterChain )throws IOException, ServletException{

        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final String authHeader = request.getHeader( "authorization" );

        System.err.println("AuthHeader: "+authHeader);
        System.err.println("Method: "+request.getMethod());
        
        if ( "OPTIONS".equals( request.getMethod() ) ){
            response.setStatus( HttpServletResponse.SC_OK );
            filterChain.doFilter( servletRequest, response );
        }
        else{
            
            if ( authHeader == null || !authHeader.startsWith( "Bearer " ) ){
                throw new ServletException( SecurityToken.NOT_AUTHORIZED_MESSAGE);
            }

            final String token = authHeader.substring( 7 );

            final Claims claims = Jwts.parser().setSigningKey(SecurityToken.SECRET_KEY).parseClaimsJws( token ).getBody();
            request.setAttribute( "claims", claims );
            filterChain.doFilter( servletRequest, response );
        }
    }
}
