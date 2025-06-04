package Arrays2;

public class LogPasValidator {
    public static void main(String[] args) {
        System.out.println(validate("user_name", "Password1_", "Password1_"));
    }

    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            if (!isValidLogin(login)) {
                throw new WrongLoginException();
            }
            if (!isValidPassword(password, confirmPassword)) {
                throw new WrongPasswordException();
            }
            return true;
        } catch (WrongLoginException e) {
            System.out.println("Логин должен содержать только латинские буквы, цифры и знак подчеркивания, длина не менее 5 символов.");
            return false;
        } catch (WrongPasswordException e) {
            System.out.println("Пароль должен содержать не менее 8 символов, три из четырех групп символов (латинские буквы, цифры, знак подчеркивания) и совпадать с подтверждением.");
            return false;
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка: " + e.getMessage());
            return false;
        }
    }

    private static boolean isValidLogin(String login) {
        return login.length() >= 5 && login.matches("^[a-zA-Z0-9_]+$");
    }

    private static boolean isValidPassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword) || password.length() < 8) {
            return false;
        }
        int groupCount = 0;
        if (password.matches(".*[a-z].*")) {
            groupCount++;
        }
        if (password.matches(".*[A-Z].*")) {
            groupCount++;
        }
        if (password.matches(".*[0-9].*")) {
            groupCount++;
        }
        if (password.contains("_")) {
            groupCount++;
        }

        return groupCount >= 3;
    }
}

class WrongLoginException extends Exception {
    public WrongLoginException() {
        super();
    }

    public WrongLoginException(String message) {
        super(message);
    }
}

class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super();
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}

