package br.com.bjsl.security.filter;

import br.com.bjsl.security.service.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class TokenFilter extends OncePerRequestFilter {

    private static final String AUTORIZATION_HEADER = "Authorization";
    private String secret;

    public TokenFilter(String secret) {
        this.secret = secret;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(AUTORIZATION_HEADER);

        Optional.ofNullable(token).ifPresent(s -> {
            if(TokenService.isTokenValid(s, secret)) {
                Authentication authentication = new UsernamePasswordAuthenticationToken(TokenService.obterIdUsuario(s, secret), null, null);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        });

        filterChain.doFilter(request, response);
    }
}
