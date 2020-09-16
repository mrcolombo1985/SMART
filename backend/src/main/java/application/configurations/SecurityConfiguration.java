package application.configurations;
/* для тестирования функциональной части системы разрешены все действия с контроллерами */

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

                .antMatchers(HttpMethod.GET, "/sensor/").permitAll()
                .antMatchers(HttpMethod.POST, "/sensor/").permitAll()
                .antMatchers(HttpMethod.PUT, "/sensor/").permitAll()
                .antMatchers(HttpMethod.DELETE, "/sensor/").permitAll()

                .antMatchers(HttpMethod.GET, "/option/").permitAll()
                .antMatchers(HttpMethod.POST, "/option/").permitAll()
                .antMatchers(HttpMethod.PUT, "/option/").permitAll()
                .antMatchers(HttpMethod.DELETE, "/option/").permitAll()

                .antMatchers(HttpMethod.GET, "/device/").permitAll()
                .antMatchers(HttpMethod.POST, "/device/").permitAll()
                .antMatchers(HttpMethod.PUT, "/device/").permitAll()
                .antMatchers(HttpMethod.DELETE, "/device/").permitAll()

                .antMatchers(HttpMethod.GET, "/arduino/").permitAll()
                .antMatchers(HttpMethod.POST, "/arduino/").permitAll()
                .antMatchers(HttpMethod.DELETE, "/arduino/").permitAll()
                .antMatchers(HttpMethod.PUT, "/arduino/").permitAll()

                .antMatchers(HttpMethod.POST, "/login/").anonymous()

                .antMatchers(HttpMethod.POST, "/logout/").permitAll()

                .antMatchers(HttpMethod.GET, "/user/").permitAll()
                .antMatchers(HttpMethod.POST, "/user/").permitAll()
                .antMatchers(HttpMethod.PUT, "/user/").permitAll()
                .antMatchers(HttpMethod.DELETE, "/user/").permitAll()

                .antMatchers(HttpMethod.GET, "/camera/").permitAll()
                .antMatchers(HttpMethod.POST, "/camera/").permitAll()
                .antMatchers(HttpMethod.PUT, "/camera/").permitAll()
                .antMatchers(HttpMethod.DELETE, "/camera/").permitAll()

                .antMatchers(HttpMethod.GET, "/role/").permitAll()
                .antMatchers(HttpMethod.POST, "/role/").permitAll()
                .antMatchers(HttpMethod.PUT, "/role/").permitAll()
                .antMatchers(HttpMethod.DELETE, "/role/").permitAll()

                .anyRequest().permitAll();
        http.addFilterBefore(securityFilter(), UsernamePasswordAuthenticationFilter.class);
    }


}
