package sessionmanager;

public class User {
    private final String username;
    private final String password;

    public User(String username, String password) {
        if(username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if(password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
