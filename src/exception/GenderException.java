package exception;

public class GenderException extends Exception {
    public GenderException(String s) {
        super(s);
    }

    public static String genderException(String gender) throws GenderException {
      String regex="^male$|^female$";
      gender=gender.toLowerCase();
        if (gender.matches(regex)) {
           char[] characters=gender.toCharArray();
           characters[0]=Character.toUpperCase(characters[0]);
           gender=new String(characters);
            return gender;
        } else {
            throw new GenderException("Gender không hợp lệ");
        }
    }
}
