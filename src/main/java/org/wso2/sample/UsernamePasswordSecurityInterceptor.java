package org.wso2.sample;

import org.wso2.msf4j.security.basic.AbstractBasicAuthSecurityInterceptor;

public class UsernamePasswordSecurityInterceptor extends AbstractBasicAuthSecurityInterceptor {

    public static final String DEFAULT_APPLICATION_USER = "application_user";
    public static final String DEFAULT_APPLICATION_PASSWORD = "P@ssword1";

    @Override
    protected boolean authenticate(String username, String password) {

        String applicationUsername = System.getProperty("hospital.backend.username");
        String applicationPassword = System.getProperty("hospital.backend.password");

        if(applicationUsername == null){
            applicationUsername = DEFAULT_APPLICATION_USER;
        }

        if(applicationPassword == null){
            applicationPassword = DEFAULT_APPLICATION_PASSWORD;
        }


        if(applicationUsername.equals(username) && applicationPassword.equals(password)){
            return true;
        }else{
            return false;
        }
    }
}
