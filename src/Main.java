import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Person>people;
    static ArrayList<Melk>melks;
    static ArrayList<Hesab_banki>hesab_bankiArrayList;
    static ArrayList<Vam>vamArrayList=new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        people=PersonController.read_person_file();
        melks=MelkController.read_melk_file();
        hesab_bankiArrayList=BankController.read_bank_file();

        while (true){
            System.out.println("1- samane sabt ahval");
            System.out.println("2- samane sabt asnad");
            System.out.println("3- samane bank");
            System.out.println("4- exit");

            int n = scanner.nextInt();

            if (n == 1){

                PersonController.samane_sabt_ahval(scanner);

            }else if (n == 2){

                MelkController.samane_sabt_asnad(scanner);

            }else if (n == 3){

                BankController.samabe_bank(scanner);

            }else {
                PersonController.write_person_file();
                MelkController.write_melk_file();
                BankController.write_bank_file();
                break;
            }


        }

    }
}
