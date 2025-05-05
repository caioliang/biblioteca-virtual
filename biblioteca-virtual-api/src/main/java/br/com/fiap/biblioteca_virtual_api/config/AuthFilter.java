package br.com.fiap.biblioteca_virtual_api.config;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthFilter extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                //Para toda requisição
                //Passando pelo filtro 

                //pegar o header
                var header = request.getHeader("Auhorization");
                if (header == null){
                    filterChain.doFilter(request, response);
                    return;
                }

                //verificar se é Bearer
                if(!header.startsWith("Bearer ")){
                    response.getStatus(401);
                    response.getWriter().write("""
                                {"message"}: "token deve começar com Bearer "
                            """);
                    return;
                }
                
                //validar JWT
                
                //autenticar
                
                filterChain.doFilter(request, response);
            }


    }
    
