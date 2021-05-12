package Service;

public interface ILoginService {
    boolean verifyCredentials(String username, String password);

    boolean logout();

    boolean isLoggedin();
}
