import java.time.LocalDate;

public class Hesab_banki {

    String shomare_hesab,code_meli_saheb;
    double mojoodi;
    LocalDate tarikh_sakht;
    int nomre_manfi;

    public Hesab_banki(String shomare_hesab, String code_meli_saheb, double mojoodi, LocalDate tarikh_sakht, int nomre_manfi) {
        this.shomare_hesab = shomare_hesab;
        this.code_meli_saheb = code_meli_saheb;
        this.mojoodi = mojoodi;
        this.tarikh_sakht = tarikh_sakht;
        this.nomre_manfi = nomre_manfi;
    }
}
