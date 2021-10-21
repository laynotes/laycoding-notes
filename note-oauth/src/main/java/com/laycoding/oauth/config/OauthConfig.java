package com.laycoding.oauth.config;

import com.laycoding.common.util.ResultUtil;
import com.laycoding.service.impl.RedisServiceImpl;
import com.laycoding.service.impl.UserDetailsServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Configuration
@EnableAuthorizationServer
public class OauthConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private CustomAccessTokenConverter customAccessTokenConverter;

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private JwtTokenEnhancer jwtTokenEnhancer;

    @Autowired
    private DataSource dataSource;

    @Autowired
    RedisServiceImpl redisService;

    @Bean
    public JdbcClientDetailsService jdbcClientDetailsService() {
        return new JdbcClientDetailsService(dataSource);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(jdbcClientDetailsService());
    }

    @Bean
    @Primary
    @Order(0)
    public DefaultTokenServices defaultTokenServices(){
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = new ArrayList<>();
        delegates.add(jwtTokenEnhancer);
        delegates.add(accessTokenConverter());
        enhancerChain.setTokenEnhancers(delegates); //配置JWT的内容增强器

        CustomTokenService tokenService = new CustomTokenService(redisService);
        tokenService.setTokenStore(jwtTokenStore());
        tokenService.setSupportRefreshToken(true);
        tokenService.setTokenEnhancer(enhancerChain);

        return tokenService;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        endpoints.tokenServices(defaultTokenServices()).authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService) //配置加载用户信息的服务
                .accessTokenConverter(accessTokenConverter())
                .exceptionTranslator(new OAuthWebResponseExceptionTranslator())
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);
    }



    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        .allowFormAuthenticationForClients()
//                .checkTokenAccess("permitAll()")
      //  security.allowFormAuthenticationForClients();
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        //简单对称加密，可使用
        jwtAccessTokenConverter.setAccessTokenConverter(customAccessTokenConverter);
        jwtAccessTokenConverter.setSigningKey("123456");

        return jwtAccessTokenConverter;
    }
    @Bean
    public JwtTokenStore jwtTokenStore(){
        return new JwtTokenStore(accessTokenConverter());
    }
}

