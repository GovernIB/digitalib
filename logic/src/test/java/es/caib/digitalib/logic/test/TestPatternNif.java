package es.caib.digitalib.logic.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author anadal (u80067)
 *
 */
public class TestPatternNif {

    public static void main(String[] args) {
        
        
        Pattern pattern = Pattern.compile("^([0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]|[A-Z][0-9]{7}[0-9A-J]|[XYZ][0-9]{7}[0-9A-Z])(,([0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]|[A-Z][0-9]{7}[0-9A-J]|[XYZ][0-9]{7}[0-9A-Z]))*$");
        
       
        final String OK = "OK";
        final String ERROR = "ERROR";
        
        final String[][] nif =  {
                
                
                { "20193882C,20202999Y22743586J", ERROR },
                { "AA767004E", ERROR },
                { "52324829T,9036746X,E21122379", ERROR },
                { "0193471T", ERROR }, 

                {"Q0700739F", OK },
                {"X0523821F,50849679Z,Q0767004E", OK },
                {"X0523821F", OK },
                {"50849679Z", OK },
                {"Q0767004E", OK },

                {"29497716D,Y5213182Q,F94819604",  OK },
                {"95258159W,U10139004,X8101597P" ,  OK },
                {"Q0700739F",  OK },
                {"X0523821F",  OK },
                
                
                {"48347626Q",  OK },
                {"18038110S",  OK },
                
                {"16074910A",  OK },
                {"47715408E",  OK },
                
                { "B21179569,27740931X,B04776852", OK }, 
                { "B21025846,J93098937", OK }, 
                { "E21286489,31313306W,29699884F", OK }, 
                { "E21272349,29475491W,29476133T,29470720S,31631599K,48889412Z", OK }, 
                 
                { "29794981E,75811733F,B11477742", OK }, 
                { "29476837Z,31595422T,29761195T,B90046707,B72157910,29484089K,29484157C,E21344460,E11452430", OK }, 
                { "E72226467,52319615C", OK }, 
                { "E11540770", OK }, 
                { "44225004Y", OK }, 
                { "J92946615", OK }, 
                { "J92269950", OK }, 
                
                
                
                
                { "13796786Y", OK }, 
                { "20209407C", OK }, 
                { "13774572X", OK }, 
                { "13796329D", OK }, 
                { "20209673X", OK }, 
                { "11428588A", OK }, 
                { "72030964R", OK }, 
                { "13795067N", OK }, 
                { "07984452W", OK }, 
                { "20194909N", OK }, 
                { "10851624V", OK }, 
                { "22726985H", OK }, 
                { "14261693Z", OK }, 
                { "13980100X", OK }, 
                { "13940004A", OK }, 
                { "20203964M", OK }, 

        };
        
        
        for (String[] valors : nif) {
            Matcher matcher = pattern.matcher(valors[0]);
            boolean matchFound = matcher.find();
            
            if((matchFound && OK.equals(valors[1])) || (!matchFound && ERROR.equals(valors[1]))) {
              System.out.println(valors[0] + " => Pass Test");
            } else {
              System.err.println(valors[0] + " => Don't Pass Test");
            }
        }
        
        
        
    }
    
}
