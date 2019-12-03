package exception;

public class IDCardException extends Exception {
    public IDCardException(String message) {
        super(message);
    }

    public static String idCardException(String idCard) throws IDCardException {
        String regex="^\\d{3}\\s\\d{3}\\s\\d{3}$";
        if (idCard.matches(regex)) {
            return idCard;
        } else {
            throw new IDCardException("ID Card không hợp lệ");
        }
    }
}
