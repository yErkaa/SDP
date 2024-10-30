package task1;

public class Main {
    public static void main(String[] args) {
        LoginView view = new LoginViewImpl();
        LoginPresenter presenter = new LoginPresenter(view);

        presenter.login();
    }
}
