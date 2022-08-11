package login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Set up to allow hashing and git past the login thing
 */
@Configuration
@EnableWebSecurity
public class Security
{

    /**
     * @param httpSecurity http object
     * @throws Exception I'm not 100% sure
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    {
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .requiresChannel(channel -> channel.anyRequest().requiresSecure())
                .authorizeRequests(request -> request.anyRequest().permitAll())
                .getOrBuild();
    }

    /**
     * Creates PasswordEncoder
     * @return BCrypt password encoder
     */
    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
