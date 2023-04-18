import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CykloVylet {
    String cil;
    int delka;
    Date datum;



    public CykloVylet(String cil, int delka, Date datum) {
        this.cil = cil;
        this.delka = delka;
        this.datum = datum;
    }
public static void zeRadku(String text){

        String[] splitRadku = text.split(",");
        String cil = splitRadku[0];
        int delka = Integer.parseInt(splitRadku[1]);
        Date datum = new Date(Long.parseLong(splitRadku[2]));

}
}
