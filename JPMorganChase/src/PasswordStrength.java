public class PasswordStrength {
    public static String getStrength(String line) {
        String valid = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,25}$";
        String strong = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=\\S+$).{10,}$";
        String medium = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^!@#$%^&*])(?=\\S+$).{8,10}$";


        if(!line.matches(valid)) {
            line = "invalid";
        }
        else {
            if(line.matches(strong)) {
                line = "strong";
            }
            else if(line.matches(medium)) {
                line = "medium";
            }
            else {
                line = "weak";
            }
        }

        return line;

    }
    public static void main(String[] args) {
        String input1 = "Nufu&YM21S";
        String input2 = "iT*2spX*8";
        String input3 = "gZAGe1";
        String input4 = "2N# 9k";
        String line = input3;

        System.out.println("Test 1:");
        System.out.println(PasswordStrength.getStrength(input1) + "\n");
        System.out.println("Test 2:");
        System.out.println(PasswordStrength.getStrength(input2)+ "\n");
        System.out.println("Test 3:");
        System.out.println(PasswordStrength.getStrength(input3)+ "\n");
        System.out.println("Test 4:");
        System.out.println(PasswordStrength.getStrength(input4)+ "\n");



    }
}
