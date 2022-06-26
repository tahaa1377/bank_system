import java.time.LocalDate;

public class Melk {

    String code_sabt_asnad,code_meli_saheb,address_melk;
    LocalDate tarikh_kharid;
    double price;

    public Melk(String code_sabt_asnad, String code_meli_saheb, String address_melk, LocalDate tarikh_kharid, double price) {
        this.code_sabt_asnad = code_sabt_asnad;
        this.code_meli_saheb = code_meli_saheb;
        this.address_melk = address_melk;
        this.tarikh_kharid = tarikh_kharid;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Melk{" +
                "code_sabt_asnad='" + code_sabt_asnad + '\'' +
                ", address_melk='" + address_melk + '\'' +
                ", tarikh_kharid=" + tarikh_kharid +
                ", price=" + price +
                '}';
    }
}
