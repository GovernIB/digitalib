package es.caib.digitalib.jpa.tests;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchTester {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String base = "[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]|[KLMXYZ][0-9]{7}[TRWAGMYFPDXBNJZSQVHLCKE]|[TRWAGMYFPDXBNJZSQVHLCKE]{1}[0-9]{8}";
        String regex = "(" + base + ")(,(" + base + "))*";
        
        System.out.println(regex);
        System.out.println();
        System.out.println();
        

        String[] tests = new String[] { "12345678C", "43096845C,K12345678", "43096845C,K12345678,", "43096845C,K12345678, pep" };

        Pattern p = Pattern.compile(regex);

        for (int i = 0; i < tests.length; i++) {
            Matcher m = p.matcher(tests[i]);

            System.out.println(tests[i] + "\t" + m.matches());
        }

    }

}
