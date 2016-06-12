package model.security;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.util.Map;

/**
 * Created by Denis-pc on 03.06.2016.
 */
public class MyLoginModule implements LoginModule {
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        
    }

    public boolean login() throws LoginException {
        return false;
    }

    public boolean commit() throws LoginException {
        return false;
    }

    public boolean abort() throws LoginException {
        return false;
    }

    public boolean logout() throws LoginException {
        return false;
    }
}
