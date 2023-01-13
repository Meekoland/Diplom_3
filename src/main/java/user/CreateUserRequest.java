package user;

import org.apache.commons.lang3.RandomStringUtils;

public class CreateUserRequest {

    private String email;
    private String password;
    private String name;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static CreateUserRequest getUserCreds() {
        String name = RandomStringUtils.randomAlphabetic(8);
        String email = RandomStringUtils.randomAlphabetic(8) + "@gmail.ru";
        String password = RandomStringUtils.randomAlphabetic(10);
        return new CreateUserRequest(name, email, password);
    }

    public static CreateUserRequest getUserWrongPassword() {
        String name = RandomStringUtils.randomAlphabetic(8);
        String email = RandomStringUtils.randomAlphabetic(8) + "@gmail.ru";
        String password = RandomStringUtils.randomAlphabetic(4);
        return new CreateUserRequest(name, email, password);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}