import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {
    private static final String VALIDATE_PATTERN = "^[A-Za-z0-9_]+$";
    public static void main(String[] args) {
        check("login","pass","pass");
        check("login###","pass","pass");
        check("login","pass^^^^^","pass");
        check("log213231dfsafgsdfgaqeweqwein","pass","pass");
        check("login","pass","pass12312");

    }
    public static boolean check(String login,String pass,String confirmPass){
        boolean isValid = true;

        try {
            checkLogin(login);
        } catch (WrongLoginException e) {
            System.out.printf("Ошибка с введением логина: " +e.getLocalizedMessage() );
            isValid = false;
        }
        try {
            checkPass(pass,confirmPass);
        } catch (WrongPasswordException e) {
            System.out.printf("Ошибка с введением пароля: " +e.getLocalizedMessage() );
            isValid = false;
        }
        return isValid;

    }

    private static void checkLogin(String login)throws WrongLoginException {
if (!login.matches(VALIDATE_PATTERN)){
    throw new WrongLoginException("Логин должен содержит в себе только латинские буквы, цифры и знак подчеркивания");
} else if (login.length()>20){
    throw new WrongLoginException("Логин не может быть длинее 20 символов");
}
    }
    private static void checkPass(String pass,String confirmPass) throws WrongPasswordException {
        if (!pass.matches(VALIDATE_PATTERN)){
            throw new WrongPasswordException("Пароль должен содержит в себе только латинские буквы, цифры и знак подчеркивания");
        }else if (pass.length()>20){
            throw new WrongPasswordException("Пароль не может быть длинее 20 символов");
        }
        else if (!pass.equals(confirmPass)){
            throw new WrongPasswordException("Пароль не совподает");
        }

    }
}