package Ejercicio.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private PasswordEncoder passwordEncoder;  // cifrador de Password

  @Autowired
  private DataSource dataSource;  // clase sql para la conexión con BD

  // consultas específicas para comprobar los ususarios y roles ( que están en properties )
  @Value("${spring.queries.users-query}")
  private String usersQuery;

  @Value("${spring.queries.roles-query}")
  private String rolesQuery;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.
            jdbcAuthentication()
            .usersByUsernameQuery(usersQuery)
            .authoritiesByUsernameQuery(rolesQuery)
            .dataSource(dataSource)
            .passwordEncoder(passwordEncoder);
  }

  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    http.
            authorizeRequests()
            .antMatchers("/", "/login", "/registeruser", "/chart").permitAll()
            .antMatchers("/public/**", "/motor/listar", "/motor/ver/**").permitAll()
            .antMatchers("/admin/enviarcorreo/adjunto", "/admin/enviarcorreo*", "/admin/upload").hasAnyAuthority("USER", "ADMIN")
            .antMatchers("/clientes/update/**").hasAnyAuthority("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/login?iniciado=true")
            .failureUrl("/login?error=true")
            .usernameParameter("username")
            .passwordParameter("password")
            .and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/")
            .and()
            .exceptionHandling()
            .accessDeniedPage("/access-denied");
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web
            .ignoring()
            .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/nuevo", "/webjars/**");
  }

}
