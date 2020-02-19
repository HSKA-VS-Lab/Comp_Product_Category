package de.hska.iwi.vslab.Comp_Product_Category.ConsumingREST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


public class ConsumeCoreCategory {
    
    //private String urlCoreCategory = "http://localhost:8082/category";

    private static final Logger log = LoggerFactory.getLogger(ConsumeCoreCategory.class);
    RestTemplate restTemplate = new RestTemplate();

    public OAuth2ProtectedResourceDetails oAuth2ResourceDetails() {
        //BaseOAuth2ProtectedResourceDetails details = new BaseOAuth2ProtectedResourceDetails();
        //ResourceOwnerPasswordResourceDetails details = new ResourceOwnerPasswordResourceDetails();
        ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();

        details.setClientId("coreCategoryId");
        details.setClientSecret("coreCategorySecret");
        details.setAccessTokenUri("http://oauthserver:8094/oauth/token");
        //details.setGrantType("client_credentials");
        List<String> scope = new ArrayList<>();
        scope.add("read");scope.add("write");
        details.setScope(scope);
        details.setAuthenticationScheme(AuthenticationScheme.header);
        details.setClientAuthenticationScheme(AuthenticationScheme.header);
        details.setId("1");
        details.setTokenName("Core_Category");

        //log.info("OAUTH DETAILS" + clientId + clientSecret + details.getAccessTokenUri() + details.getGrantType());
        //details.set
        return details;
    }

    @Bean // has to be done at runtime because the authorization server would not be up otherwise
    public OAuth2RestTemplate foo() {
        //OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(oAuth2ResourceDetails());
        AccessTokenRequest atr = new DefaultAccessTokenRequest();
        return new OAuth2RestTemplate(oAuth2ResourceDetails(), new DefaultOAuth2ClientContext(atr));
        /* To validate if required configurations are in place during startup */
        //oAuth2RestTemplate.getAccessToken();
        //return oAuth2RestTemplate;
    }

    public Category[] getCategories() {
        try {
            UrlBuilder urlBuilder = new UrlBuilder();
            log.info("URL:" + urlBuilder.getCategoryUrl());
            OAuth2RestTemplate restTemplate3 = foo();
            Category [] categories = restTemplate3.getForObject(urlBuilder.getCategoryUrl(), Category[].class);
            //Category [] categories = restTemplate.getForObject(urlBuilder.getCategoryUrl(), Category[].class);
            return categories;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public void deleteCategory(int id) {
        try {
            UrlBuilder urlBuilder = new UrlBuilder();
            log.info("URL:" + urlBuilder.getCategoryDeleteByIdUrl(id));
            OAuth2RestTemplate restTemplate3 = foo();
            restTemplate3.delete(urlBuilder.getCategoryDeleteByIdUrl(id));
            //restTemplate.delete(urlBuilder.getCategoryDeleteByIdUrl(id));
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

}