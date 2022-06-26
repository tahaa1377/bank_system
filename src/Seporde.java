import java.time.LocalDate;

public class Seporde extends Hesab_banki{

    TypeSeporde typeSeporde;
    int rooz;

    public Seporde(String shomare_hesab, String code_meli_saheb, double mojoodi, LocalDate tarikh_sakht, int nomre_manfi, TypeSeporde typeSeporde) {
        super(shomare_hesab, code_meli_saheb, mojoodi, tarikh_sakht, nomre_manfi);
        this.typeSeporde = typeSeporde;
        set_sood();
    }

    public void set_sood(){
        if (TypeSeporde.KOTAH_MODAT == typeSeporde){
            mojoodi+=10/100*mojoodi;
            rooz=10;
        }else if (typeSeporde == TypeSeporde.BOLAND_MODAT){
            mojoodi+=30/100*mojoodi;
            rooz=30;
        }else if (typeSeporde == TypeSeporde.VIZHEH){
            mojoodi+=50/100*mojoodi;
            rooz=50;
        }
    }


    @Override
    public String toString() {
        return "Seporde{" +
                "typeSeporde=" + typeSeporde +
                ", rooz=" + rooz +
                ", shomare_hesab='" + shomare_hesab + '\'' +
                ", mojoodi=" + mojoodi +
                ", tarikh_sakht=" + tarikh_sakht +
                ", nomre_manfi=" + nomre_manfi +
                '}';
    }
}
