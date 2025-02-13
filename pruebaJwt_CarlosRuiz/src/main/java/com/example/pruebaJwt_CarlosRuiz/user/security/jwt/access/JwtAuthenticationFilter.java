package com.example.pruebaJwt_CarlosRuiz.user.security.jwt.access;

import com.example.pruebaJwt_CarlosRuiz.user.model.User;
import com.example.pruebaJwt_CarlosRuiz.user.repo.UserRepository;
import com.example.pruebaJwt_CarlosRuiz.user.security.exceptionhandling.JwtAuthenticationEntryPoint;
import com.example.pruebaJwt_CarlosRuiz.user.service.UserService;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserRepository userRepository;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = getJwtAccessTokenFromRequest(request);

        //Validar token
        //Si es válido, autenticar al usuario

        try {
            if (StringUtils.hasText(token) && jwtService.validateAccessToken(token)) {

                //Obtener el sub del token, que es el id del usuario
                //Buscar el usuario por id
                //Colocar al usuario autenticado en el contexto de seguridad

                UUID id = jwtService.getUserIdFromAccessToken(token);

                Optional<User> result = userRepository.findById(id);

                if (result.isPresent()) {
                    User user = result.get();
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(
                                    user,
                                    null,
                                    user.getAuthorities()
                            );

                    authenticationToken.setDetails(new WebAuthenticationDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }

        }catch (JwtException ex){
            resolver.resolveException();
        }

            filterChain.doFilter(request, response);
    }

    private String getJwtAccessTokenFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader(JwtService.TOKEN_HARDER);
        //Bearer kjsakdsaknjnadjcndjndjcnsjdcnj.dkckdsncds.cdkcjdkscnsd
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(JwtService.TOKEN_PREFIX)){
            return bearerToken.substring(JwtService.TOKEN_PREFIX.length());
        }

        return null;
    }
}
