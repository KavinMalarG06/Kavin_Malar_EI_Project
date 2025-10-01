package sessionmanager;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AuthenticationManager {
    private static AuthenticationManager instance;
    private final Map<String, User> registeredUsers;
    private Session activeSession;

    private AuthenticationManager() {
        registeredUsers = new HashMap<>();
    }

    public static AuthenticationManager getInstance() {
        if(instance == null) {
            synchronized (AuthenticationManager.class) {
                if(instance == null) {
                    instance = new AuthenticationManager();
                }
            }
        }
        return instance;
    }

    public void registerUser(String username, String password) throws Exception {
        if(registeredUsers.containsKey(username)) {
            throw new Exception("Username already exists!");
        }
        registeredUsers.put(username, new User(username, password));
        Utils.logInfo("User registered: " + username);
    }

    public boolean loginUser(String username, String password) throws Exception {
        User user = registeredUsers.get(username);
        if(user == null || !user.checkPassword(password)) {
            Utils.logWarning("Failed login attempt for: " + username);
            return false;
        }
        activeSession = new Session(user);
        Utils.logInfo("User logged in: " + username);
        return true;
    }

    public void logout() {
        if(activeSession != null) {
            Utils.logInfo("User logged out: " + activeSession.getUser().getUsername());
            activeSession = null;
        } else {
            Utils.logWarning("No active session to logout");
        }
    }

    public Optional<Session> getActiveSession() {
        return Optional.ofNullable(activeSession);
    }
}
