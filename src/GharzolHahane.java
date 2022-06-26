import java.time.LocalDate;
import java.util.Random;

public class GharzolHahane extends Hesab_banki{

    String shomare_cart;

    public GharzolHahane(String shomare_hesab, String code_meli_saheb, double mojoodi, LocalDate tarikh_sakht, int nomre_manfi) {
        super(shomare_hesab, code_meli_saheb, mojoodi, tarikh_sakht, nomre_manfi);

        generate_shomare_hesab_shomare_cart();

    }


    public void generate_shomare_hesab_shomare_cart(){

        shomare_cart = GenerateRandomNumber(8) + GenerateRandomNumber(8);
        shomare_hesab = GenerateRandomNumber(8)+ GenerateRandomNumber(8);


    }

    String GenerateRandomNumber(int charLength) {
        return String.valueOf(charLength < 1 ? 0 : new Random()
                .nextInt((9 * (int) Math.pow(10, charLength - 1)) - 1)
                + (int) Math.pow(10, charLength - 1));
    }

    @Override
    public String toString() {
        return "GharzolHahane{" +
                "shomare_cart='" + shomare_cart + '\'' +
                ", shomare_hesab='" + shomare_hesab + '\'' +
                ", mojoodi=" + mojoodi +
                ", tarikh_sakht=" + tarikh_sakht +
                ", nomre_manfi=" + nomre_manfi +
                '}';
    }
}
