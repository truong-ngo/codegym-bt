package string_regex.validate_phone_number;

public class PhoneNumberExampleTest {
    public static final String[] validPhoneNumber = new String[] {"(84)-(0978489648)", "(83)-(0978489656)", "(47)-(0978489656)"};
    public static final String[] invalidPhoneNumber = new String[] {"(a8)-(22222222)", "(843)-(0978489648)", "(84)-(9978489648)"};

    public static void main(String[] args) {
        PhoneNumberExample phoneNumberExample = new PhoneNumberExample();
        for (String phoneNumber : validPhoneNumber) {
            boolean isValid = phoneNumberExample.validatePhoneNumber(phoneNumber);
            System.out.println("Phone number is " + phoneNumber +" is valid: "+ isValid);
        }
        for (String phoneNumber : invalidPhoneNumber) {
            boolean isValid = phoneNumberExample.validatePhoneNumber(phoneNumber);
            System.out.println("Phone number is " + phoneNumber +" is valid: "+ isValid);
        }
    }
}
