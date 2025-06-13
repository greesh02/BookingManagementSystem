package com.greeshwar.BookingManagementSystem.Configurations;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.greeshwar.BookingManagementSystem.Models.User;
import com.greeshwar.BookingManagementSystem.Services.AuthServices.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final HandlerExceptionResolver handlerExceptionResolver;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    private JwtAuthenticationFilter(
            HandlerExceptionResolver handlerExceptionResolver,
            JwtService jwtService,
            UserDetailsService userDetailsService
    ){
        this.handlerExceptionResolver = handlerExceptionResolver;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
            ) throws ServletException, IOException {
        System.out.println("in auth");
        // this function handles all core logics of jWT auth filter for each incoming http req
        final String authHeader = request.getHeader("Authorization");

        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }



        try{
            final String jwt = authHeader.substring(7);
            final String userEmail = jwtService.extractUserName(jwt);
            System.out.println(userEmail);
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if(userEmail != null && authentication == null){
                System.out.println("user details ---");
                // user info fetched from DB
//                UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
//                UserDetails userDetails = null; // avoiding DB call to fetch user data
                // fetching user info from the token itself
                User user = new User();
                user.setEmail(jwtService.extractUserName(jwt));
                user.setRoles(jwtService.extractRoles(jwt));
                UserDetails userDetails = user;


                System.out.println(userDetails);
                if(jwtService.isTokenVaild(jwt,userDetails)){
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()

                    );
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }

            filterChain.doFilter(request,response);

        }
        catch(Exception e){
            Map<String ,String> responseMap = new HashMap<>();
            responseMap.put("error","Invalid token");
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(responseMap);

            response.getWriter().write(jsonString);

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            handlerExceptionResolver.resolveException(request,response,null,e);

        }

    }
}
