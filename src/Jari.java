import java.time.LocalDate;

public class Jari extends Hesab_banki {


    String daste_check,cart_bank;

    public Jari(String shomare_hesab, String code_meli_saheb, double mojoodi, LocalDate tarikh_sakht, int nomre_manfi) {
        super(shomare_hesab, code_meli_saheb,
                mojoodi, tarikh_sakht, nomre_manfi);


    }


    @Override
    public String toString() {
        return "Jari{" +
                "shomare_hesab='" + shomare_hesab + '\'' +
                ", mojoodi=" + mojoodi +
                ", tarikh_sakht=" + tarikh_sakht +
                ", nomre_manfi=" + nomre_manfi +
                '}';
    }
}
