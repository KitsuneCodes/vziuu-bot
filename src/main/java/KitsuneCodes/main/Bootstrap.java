package KitsuneCodes.main;

import KitsuneCodes.VziuuBOT;

import javax.security.auth.login.LoginException;

/**
 * @author Paqlio
 * @since 07.26.2023 - 11:32
 **/

public class Bootstrap extends LoginException {
    public static void main(String[] args) throws LoginException {
        new VziuuBOT().start();
    }
}