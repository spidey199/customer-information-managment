// package com.customer.securityConfiguration;



// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration 
// @EnableWebSecurity 
// public class SecurityConfiguration {
    
//     @Bean 
//     public SecurityFilterChain securityFilterChain(HttpSecurity http){
//         http.csrf(AbstractHttpConfigurer::disable)
//             .authorizeHttpRequests(auth -> auth
//                         .requestMatchers("/*/admin/**").hasRole("ADMIN") 
//                         .requestMatchers("/user/**").hasRole("USER")
//                         .anyRequest().authenticated() 
//             )
//             .httpBasic(Customizer.withDefaults())
//             .formLogin(AbstractHttpConfigurer::disable);

//             return http.build();
//     }
//     @Bean
//     public UserDetailsService user(){
//         UserDetails ganeshji =  User.withUsername("ganesh").password("{noop}ganesh").roles("ADMIN").build();
//         UserDetails shivji = User.withUsername("shiv").password("{noop}shiv").roles("USER").build();
//         UserDetails hanumanji = User.withUsername("hanumanji").password("{noop}hanumaji").roles("USER").build();

//         return new InMemoryUserDetailsManager(ganeshji, shivji, hanumanji);
//     }


// }
