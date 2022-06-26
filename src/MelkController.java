import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MelkController {



    public static void write_melk_file(){
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new
                    FileWriter("C:\\Users\\Taha\\IdeaProjects\\project\\src\\melk.txt"));

            for (Melk p:Main.melks) {
                String str = p.code_sabt_asnad +" "+ p.code_meli_saheb +" "+p.address_melk +" "+p.tarikh_kharid +" "+ p.price+"\n";
                writer.write(str);
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<Melk> read_melk_file() {

        ArrayList<Melk>melks= new ArrayList<>();

        try
        {
            File file=new File("C:\\Users\\Taha\\IdeaProjects\\project\\src\\melk.txt");
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String line;
            while((line=br.readLine())!=null)
            {
                String []strings = line.split(" ");
                melks.add(new Melk(strings[0],strings[1],strings[2],
                        LocalDate.parse(strings[3]),Double.parseDouble(strings[4])));

            }
            fr.close();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return melks;

    }

    public static void samane_sabt_asnad(Scanner scanner) {


        while (true){

            System.out.println("1- add melk");
            System.out.println("2- edit melk");
            System.out.println("3- delete melk");
            System.out.println("4- show melks");
            System.out.println("5- exit");

            int samane_sabt_ahval = scanner.nextInt();

            if (samane_sabt_ahval == 1){

                System.out.println("enter code_sabt_asnad :");
                String code_sabt_asnad = scanner.next();
                System.out.println("enter code_meli_saheb :");
                String code_meli_saheb = scanner.next();
                System.out.println("enter address_melk :");
                String address_melk = scanner.next();

                System.out.println("enter year");
                int year = scanner.nextInt();
                System.out.println("enter month");
                int month = scanner.nextInt();
                System.out.println("enter day");
                int day = scanner.nextInt();

                LocalDate localDate = LocalDate.of(year,month,day);

                System.out.println("enter price of melk :");
                double wallet = scanner.nextDouble();

                Main.melks.add(new Melk(code_sabt_asnad,code_meli_saheb,address_melk,localDate,wallet));
                System.out.println("melk added suseesfully");

            }else if (samane_sabt_ahval == 2){

                System.out.println("enter code_meli_saheb :");
                String code_meli = scanner.next();
                System.out.println("enter code_sabt_asnad :");
                String code_sabt_asnad = scanner.next();

                for (Melk p:Main.melks) {
                    if (p.code_meli_saheb.equals(code_meli) && p.code_sabt_asnad.equals(code_sabt_asnad)){


                        System.out.println("enter address_melk :");
                        String address_melk = scanner.next();
                        System.out.println("enter year");
                        int year = scanner.nextInt();
                        System.out.println("enter month");
                        int month = scanner.nextInt();
                        System.out.println("enter day");
                        int day = scanner.nextInt();

                        LocalDate localDate = LocalDate.of(year,month,day);

                        System.out.println("enter price of melk :");

                        p.price= scanner.nextDouble();
                        p.tarikh_kharid=localDate;
                        p.address_melk=address_melk;


                        System.out.println("update melk suseesfully");

                        break;
                    }
                }


            }else if (samane_sabt_ahval == 3){

                System.out.println("enter code meli :");
                String code_meli = scanner.next();
                System.out.println("enter code_sabt_asnad :");
                String code_sabt_asnad = scanner.next();

                double pool=0;

                for (int i = 0; i <Main.melks.size() ; i++) {

                    if (Main.melks.get(i).code_meli_saheb.equals(code_meli)
                    &&
                        Main.melks.get(i).code_sabt_asnad.equals(code_sabt_asnad)
                    ){
                        pool=Main.melks.get(i).price;
                        Main.melks.remove(i);
                        System.out.println("melk delete suseesfully");

                    }
                }

                for (Person p:Main.people) {

                    if (p.code_meli.equals(code_meli)) {

                        p.wallet +=pool;
                    }

                }

            }else if (samane_sabt_ahval == 4){

                System.out.println("enter code meli :");
                String code_meli = scanner.next();

                for (Melk p:Main.melks) {
                    if (p.code_meli_saheb.equals(code_meli))
                        System.out.println(p.toString());
                }

            }else {
                break;
            }

        }

    }


}
