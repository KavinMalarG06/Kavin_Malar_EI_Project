package sessionmanager;

import java.time.LocalDateTime;

public class Session {
    private final User user;
    private final LocalDateTime loginTime;

    public Session(User user) {
        this.user = user;
        this.loginTime = LocalDateTime.now();
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }
}
