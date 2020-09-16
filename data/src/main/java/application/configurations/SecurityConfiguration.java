package application.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity()
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public SecurityFilter securityFilter() {
        return new SecurityFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/data/").permitAll()
                .antMatchers(HttpMethod.POST, "/data/").permitAll()
                .antMatchers(HttpMethod.PUT, "/data/").permitAll()
                .antMatchers(HttpMethod.DELETE, "/data/").permitAll()

                .antMatchers(HttpMethod.GET, "/").permitAll()
                .antMatchers(HttpMethod.POST, "/").permitAll()
                .antMatchers(HttpMethod.PUT, "/").permitAll()
                .antMatchers(HttpMethod.DELETE, "/").permitAll()
                .anyRequest().permitAll();
        http.addFilterBefore(securityFilter(), UsernamePasswordAuthenticationFilter.class);
    }


}
