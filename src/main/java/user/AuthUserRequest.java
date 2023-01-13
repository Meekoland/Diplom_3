package user;

import org.apache.commons.lang3.RandomStringUtils;

public class AuthUserRequest {

    private String email;
    private String password;

    public AuthUserRequest() {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private static final String RANDOM_PASSWORD = RandomStringUtils.randomAlphanumeric(6);

    public static AuthUserRequest getCorrectUserLoginAndPassword(CreateUserRequest createUserRequest) {
        AuthUserRequest authUserRequest = new AuthUserRequest();
        authUserRequest.setEmail(createUserRequest.getEmail());
        authUserRequest.setPassword(createUserRequest.getPassword());
        return authUserRequest;
    }
}