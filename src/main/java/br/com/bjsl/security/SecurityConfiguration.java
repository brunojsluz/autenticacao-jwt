package br.com.bjsl.security;

import br.com.bjsl.security.filter.TokenFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class    SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String URL_PRODUTO = "/produto";
    private static final String URL_PRODUTO_DETALHES = "/produto/*";
    private static final String URL_ACTUATOR = "/actuator/**";

    @Value("${produto.jwt.secret}")
    private String secret;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, URL_PRODUTO).permitAll()
                .antMatchers(HttpMethod.GET, URL_PRODUTO_DETALHES).permitAll()
                .antMatchers(HttpMethod.GET, URL_ACTUATOR).permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(new TokenFilter(secret), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**.html", "/v2/api-docs", "webjars/**", "/configuration/**", "/swagger-resources/**");
    }
}
