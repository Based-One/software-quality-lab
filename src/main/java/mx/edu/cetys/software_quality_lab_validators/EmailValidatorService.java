package mx.edu.cetys.software_quality_lab_validators;

public class EmailValidatorService {

    private static final String[] DIPTONGOS = {
            "ai", "au", "ei", "ey", "ie", "oi", "ou", "oy"
    };

    public boolean isValid(String inputEmail) {
        if (inputEmail == null) return false;

        String email = inputEmail.toLowerCase();

        return isEmpty(email)
                && hasValidFormat(email)
                && doesNotContainDiphthongs(email)
                && hasValidLength(email)
                && doesContainNumberFour(email);
    }

    public boolean isEmpty(String email) {
        return !email.isEmpty();
    }

    public boolean hasValidFormat(String inputEmail) {
        String email = inputEmail.toLowerCase();

        return email.matches("^[a-z0-9]{1,10}#[a-z]{1,20}\\.[a-z]{1,5}$");
    }

    public boolean doesNotContainDiphthongs(String email) {
        for (String dip : DIPTONGOS) {
            if (email.contains(dip)) {
                return false;
            }
        }
        return true;
    }
    public boolean doesContainNumberFour(String email){
        for (int i = 0; i < email.length(); i++) {
           if(email.charAt(i) == '4'){
               return true;
           }
        }
        return false;
    }

    public boolean hasValidLength(String inputEmail) {
        String email = inputEmail.toLowerCase();

        return email.length() < 47;
    }



}