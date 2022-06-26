import com.sun.jdi.InvalidTypeException;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BankController {

    public static void samabe_bank(Scanner scanner) {


        while (true){

            System.out.println("1- eftetah hesab");
            System.out.println("2- show hesab ha");
            System.out.println("3- enteghal vajh");
            System.out.println("4- darkhast vam");
            System.out.println("0- exit");
            int n = scanner.nextInt();

             if (n == 4) {

                 System.out.println("enter type vam :");
                 System.out.println("1- 6 gheste");
                 System.out.println("2- 12 gheste");
                 int vam = scanner.nextInt();
                 VamType type = vam == 1 ? VamType.SIX_GHESTEH : VamType.TWELE_GHESTEH;

                 System.out.println("enter meghdar vam :");
                 double d= scanner.nextDouble();
                 System.out.println("enter darsad sood :");
                 int sood= scanner.nextInt();

                 System.out.println("enter shomare hesab :");
                 String shomare_hesab=scanner.next();

                 for (Hesab_banki p:Main.hesab_bankiArrayList) {
                     if (p.shomare_hesab.equals(shomare_hesab)){
                         if (p.nomre_manfi < 5) {
                             p.mojoodi += d;
                             Vam v=new Vam(shomare_hesab,sood,d,type);
                             Main.vamArrayList.add(v);
                             System.out.println("vam pardakht shod.");
                             System.out.println("meghdar har ghest :");
                             int tedad = vam == 1 ? 6 : 12;
                             v.meghdar_har_ghest = (d * (sood+1)) / tedad;
                             System.out.println(v.meghdar_har_ghest);
                             break;
                         }else {
                             System.out.println("vam be shoma taalogh nemigirad");
                             break;
                         }
                     }
                 }


             }else if (n == 0){

                break;

            }else if (n == 1){

                System.out.println("enter code meli :");
                String code_meli_saheb = scanner.next();

                System.out.println("which type of hesab ?");
                System.out.println("1- Jari");
                System.out.println("2- GharzolHahane");
                System.out.println("3- Seporde");

                int type = scanner.nextInt();

                if (type == 1){

                    String shomare_hesab = generateRandomNumber(5);
                    System.out.println("enter mojoodi avalieh :");
                    double mojoodi = scanner.nextDouble();

                    Jari jari = new Jari(shomare_hesab,code_meli_saheb,mojoodi, LocalDate.now(),0);
                    Main.hesab_bankiArrayList.add(jari);
                    System.out.println("shomare hesab shoma :"+jari.shomare_hesab);

                }else if (type == 2){

                    String shomare_hesab = generateRandomNumber(5);
                    System.out.println("enter mojoodi avalieh :");
                    double mojoodi = scanner.nextDouble();

                    GharzolHahane gharzolHahane = new GharzolHahane(shomare_hesab,code_meli_saheb,mojoodi, LocalDate.now(),0);
                    Main.hesab_bankiArrayList.add(gharzolHahane);
                    System.out.println("shomare hesab shoma :"+gharzolHahane.shomare_hesab);

                }else if (type == 3){

                    String shomare_hesab = generateRandomNumber(5);
                    System.out.println("enter mojoodi avalieh :");
                    double mojoodi = scanner.nextDouble();

                    System.out.println("enter type seporder :");
                    System.out.println("1- kotah modat :");
                    System.out.println("2- boland modat :");
                    System.out.println("3- vizheh :");

                    int g = scanner.nextInt();

                    if (g == 1){

                        Seporde gharzolHahane = new Seporde(shomare_hesab,code_meli_saheb,mojoodi,
                                LocalDate.now(),0,TypeSeporde.KOTAH_MODAT);

                        Main.hesab_bankiArrayList.add(gharzolHahane);
                        System.out.println("shomare hesab shoma :"+gharzolHahane.shomare_hesab);

                    }else if (g == 2){

                        Seporde gharzolHahane = new Seporde(shomare_hesab,code_meli_saheb,mojoodi,
                                LocalDate.now(),0,TypeSeporde.BOLAND_MODAT);

                        Main.hesab_bankiArrayList.add(gharzolHahane);
                        System.out.println("shomare hesab shoma :"+gharzolHahane.shomare_hesab);

                    }else if (g == 3){

                        Seporde gharzolHahane = new Seporde(shomare_hesab,code_meli_saheb,mojoodi,
                                LocalDate.now(),0,TypeSeporde.VIZHEH);

                        Main.hesab_bankiArrayList.add(gharzolHahane);
                        System.out.println("shomare hesab shoma :"+gharzolHahane.shomare_hesab);


                    }else {
                        try {
                            throw new InvalidTypeException("Invalid Type Exception");
                        } catch (InvalidTypeException e) {
                            e.printStackTrace();
                        }
                    }

                }else {
                    try {
                        throw new InvalidTypeException("Invalid Type Exception");
                    } catch (InvalidTypeException e) {
                        e.printStackTrace();
                    }
                }

            }else if (n == 2){

                System.out.println("enter code meli :");
                String code_meli_saheb = scanner.next();

                for (Hesab_banki p:Main.hesab_bankiArrayList) {
                    if (p.code_meli_saheb.equals(code_meli_saheb)){
                        System.out.println(p.toString());
                    }
                }

            }else if (n == 3){

                System.out.println("enter shomare hesab manda :");
                String shomare_hesab_manda=scanner.next();

                System.out.println("enter shomare hesab maghsad :");
                String shomare_hesab_maghsad=scanner.next();

                System.out.println("enter mizan pool enteghali");
                double pool = scanner.nextDouble();

                if (is_exist(shomare_hesab_manda) && is_exist(shomare_hesab_maghsad)){

                    Hesab_banki src = get_info_hesab(shomare_hesab_manda);
                    Hesab_banki dest = get_info_hesab(shomare_hesab_maghsad);


                    if (src != null && dest != null) {

                        if (src.mojoodi >= pool){

                            src.mojoodi-= pool;
                            dest.mojoodi+=pool;

                            System.out.println("money transmite succssfully");

                        }else {

                            try {
                                throw new NotEnoughMoneyException("Not Enough Money Exception");
                            } catch (NotEnoughMoneyException e) {
                                e.printStackTrace();
                            }

                        }

                    }


                }else {
                    System.out.println("shomare hesab manda or shomare hesab maghsad not exist");
                }


            }

        }


    }

    private static Hesab_banki get_info_hesab(String shomare_hesab_manda) {
        for (Hesab_banki g:Main.hesab_bankiArrayList) {
            if (g.shomare_hesab.equals(shomare_hesab_manda)){
                return g;
            }
        }
        return null;
    }

    private static boolean is_exist(String shomare_hesab) {

        for (Hesab_banki g:Main.hesab_bankiArrayList) {
            if (g.shomare_hesab.equals(shomare_hesab)){
//                System.out.println(shomare_hesab);
                return true;
            }
        }

        return false;
    }


    public static ArrayList<Hesab_banki> read_bank_file() {

        ArrayList<Hesab_banki>bankis = new ArrayList<>();

        try
        {
            File file=new File("C:\\Users\\Taha\\IdeaProjects\\project\\src\\hesab_banki.txt");
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String line;
            while((line=br.readLine())!=null)
            {
                String []strings = line.split(" ");

                if (strings[0].equals("Jari")){

                    bankis.add(new Jari(strings[1],strings[2],Double.parseDouble(strings[3]),
                            LocalDate.parse(strings[4]),Integer.parseInt(strings[5])));


                }else if (strings[0].equals("GharzolHahane")){
                    bankis.add(new GharzolHahane(strings[1],strings[2],Double.parseDouble(strings[3]),
                            LocalDate.parse(strings[4]),Integer.parseInt(strings[5])));

                }else if (strings[0].equals("Seporde")){
                    bankis.add(new Seporde(strings[1],strings[2],Double.parseDouble(strings[3]),
                            LocalDate.parse(strings[4]),Integer.parseInt(strings[5]),TypeSeporde.valueOf(strings[6])));
                }

            }
            fr.close();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }


        return bankis;
    }


    public static void write_bank_file() {

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new
                    FileWriter("C:\\Users\\Taha\\IdeaProjects\\project\\src\\hesab_banki.txt"));

            for (Hesab_banki p:Main.hesab_bankiArrayList) {

                if (p.getClass().getName().equals("Jari")){

                    String str = "Jari"+" "+p.shomare_hesab +" "+ p.code_meli_saheb +" "+p.mojoodi
                            +" "+p.tarikh_sakht +" "+ p.nomre_manfi+"\n";
                    writer.write(str);

                }else if (p.getClass().getName().equals("GharzolHahane")){

                    String str = "GharzolHahane"+" "+p.shomare_hesab +" "+ p.code_meli_saheb +" "+p.mojoodi
                            +" "+p.tarikh_sakht +" "+ p.nomre_manfi+"\n";
                    writer.write(str);

                }else if (p.getClass().getName().equals("Seporde")){

                    Seporde seporde = (Seporde) p;
                    String str = "Seporde"+" "+p.shomare_hesab +" "+ p.code_meli_saheb +" "+p.mojoodi
                            +" "+p.tarikh_sakht +" "+ p.nomre_manfi+" "+ seporde.typeSeporde+"\n";
                    writer.write(str);

                }


            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static String generateRandomNumber(int charLength) {
        return String.valueOf(charLength < 1 ? 0 : new Random()
                .nextInt((9 * (int) Math.pow(10, charLength - 1)) - 1)
                + (int) Math.pow(10, charLength - 1));
    }

}
