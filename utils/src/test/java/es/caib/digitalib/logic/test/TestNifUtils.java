package es.caib.digitalib.logic.test;

import es.caib.digitalib.utils.NifUtils;
import es.caib.digitalib.utils.NifUtils.CheckNifResult;
import es.caib.digitalib.utils.NifUtils.NifInfo;

/**
 * 
 * @author anadal (u80067)
 *
 */
public class TestNifUtils {

    public static void main(String[] args) {
        
        try {
            

        final String OK = "OK";
        final String ERROR = "ERROR";

        final String[][] nif = {
                
                { "0193471T", ERROR },
                { "20193882C,20202999Y22743586J", ERROR }, 
                { "52324829T,9036746X,E21122379", ERROR },
                

                { "Q0700739F", OK }, { "X0523821F,50849679Z,Q0767004E", ERROR },
                { "X0523821F", ERROR }, { "50849679Z", OK }, { "", ERROR },

                { "29497716D,Y5213182Q,F94819604", OK },
                { "95258159W,U10139004,X8101597P", OK }, { "Q0700739F", OK },

                { "48347626Q", OK }, { "18038110S", OK },

                { "16074910A", OK }, { "47715408E", OK },

                { "B21179569,27740931X,B04776852", OK }, { "B21025846,J93098937", OK },
                { "E21286489,31313306W,29699884F", OK },
                { "E21272349,29475491W,29476133T,29470720S,31631599K,48889412Z", OK },

                { "29794981E,75811733F,B11477742", OK },
                { "29476837Z,31595422T,297/61195T,B900-46707,B72157910,29484089 K,29484157.C,E21344460,E11452430",
                        OK },
                { "E72226467,52319615C", OK }, { "E11540770", OK }, { "44225004Y", OK },
                { "J92946615", OK }, { "J92269950", OK },

                { "13796786A", ERROR }, { "13796786B", ERROR }, { "13796786C", ERROR },
                { "13796786D", ERROR }, { "13796786E", ERROR }, { "13796786F", ERROR },
                { "13796786G", ERROR }, { "13796786H", ERROR }, { "13796786I", ERROR },
                { "13796786J", ERROR }, { "13796786K", ERROR }, { "13796786L", ERROR },
                { "13796786M", ERROR }, { "13796786N", ERROR }, { "13796786O", ERROR },
                { "13796786P", ERROR }, { "13796786Q", ERROR }, { "13796786R", ERROR },
                { "13796786S", ERROR }, { "13796786T", ERROR }, { "13796786U", ERROR },
                { "13796786V", ERROR }, { "13796786W", ERROR }, { "13796786X", ERROR },
                { "13796786Z", ERROR },

                { "13796786Y", OK },

                { "13796786Y", OK }, { "20209407C", OK }, { "13774572X", OK },
                { "13796329D", OK }, { "20209673X", OK }, { "11428588A", OK },
                { "72030964R", OK }, { "13795067N", OK }, { "07984452W", OK },
                { "20194909N", OK }, { "10851624V", OK }, { "22726985H", OK },
                { "14261693Z", OK }, { "13980100X", OK }, { "13940004A", OK },
                { "20203964M", OK },

                { ",Q0767004E", ERROR },

                { "00000001R, 00000014Z ", OK }

        };

        for (String[] valors : nif) {

            CheckNifResult cnr = NifUtils.validateNifsSeparatedByCommas(valors[0]);

            boolean isValid = cnr.isValid();

            if ((isValid && OK.equals(valors[1]))
                    || (!isValid && ERROR.equals(valors[1]))) {
                System.out.println(valors[0] + " => Pass Test");
            } else {
                String msg = valors[0] + " => Don't Pass Test: ";
                if (cnr.getNifs() != null) {
                for (NifInfo error : cnr.getNifs()) {
                    msg = msg +  "\n   * " + error.getNif() + " => " + error.getError();
                }
                }
                throw new Exception(msg);
            }

        }
        

        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

    }

}
