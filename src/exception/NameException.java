package exception;

public class NameException extends Exception {
    public NameException(String s) {
        super(s);
    }
    public static String nameException(String name) throws NameException {
        String regex = "^((\\p{Lu})(\\p{Ll}*))( (\\p{Lu})(\\p{Ll}*))*$";
        if (name.matches(regex)) {
            return name;
        } else {
            throw new NameException("Tên không hợp lệ");
        }
    }
}
