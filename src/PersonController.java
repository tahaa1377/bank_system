import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonController {

    public static void samane_sabt_ahval(Scanner scanner){

        while (true){


            System.out.println("1- add person");
            System.out.println("2- edit person");
            System.out.println("3- delete person");
            System.out.println("4- show person");
            System.out.println("5- exit");

            int samane_sabt_ahval = scanner.nextInt();

            if (samane_sabt_ahval == 1){

                System.out.println("enter name :");
                String name = scanner.next();
                System.out.println("enter age :");
                int age = scanner.nextInt();
                System.out.println("enter code meli :");
                String code_meli = scanner.next();
                System.out.println("male or female :");
                String sex = scanner.next();
                System.out.println("enter price in wallet :");
                double wallet = scanner.nextDouble();

                Main.people.add(new Person(code_meli,name,sex,age,wallet));
                System.out.println("person added suseesfully");

            }else if (samane_sabt_ahval == 2){

                System.out.println("enter code meli :");
                String code_meli = scanner.next();

                for (Person p:Main.people) {
                   if (p.code_meli.equals(code_meli)){

                       System.out.println("enter name :");
                       String name = scanner.next();
                       System.out.println("enter age :");
                       int age = scanner.nextInt();

                       System.out.println("male or female :");
                       String sex = scanner.next();
                       System.out.println("enter price in wallet :");
                       double wallet = scanner.nextDouble();

                       p.name=name;
                       p.age=age;
                       p.sex=sex;
                       p.wallet=wallet;

                       System.out.println("update person suseesfully");

                       break;
                   }
                }


            }else if (samane_sabt_ahval == 3){

                System.out.println("enter code meli :");
                String code_meli = scanner.next();

                for (int i = 0; i <Main.people.size() ; i++) {

                    if (Main.people.get(i).code_meli.equals(code_meli)){
                        Main.people.remove(i);
                        System.out.println("delete person suseesfully");

                    }
                }

            }else if (samane_sabt_ahval == 4){

                for (Person p:Main.people) {
                    System.out.println(p.toString());
                }

            }else {
                break;
            }

        }

    }

    public static void write_person_file(){
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new
                    FileWriter("C:\\Users\\Taha\\IdeaProjects\\project\\src\\person.txt"));

            for (Person p:Main.people) {
                String str = p.code_meli +" "+ p.name +" "+p.sex +" "+p.age +" "+ p.wallet+"\n";
                writer.write(str);
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Person> read_person_file() {

        ArrayList<Person>people= new ArrayList<>();

        try
        {
            File file=new File("C:\\Users\\Taha\\IdeaProjects\\project\\src\\person.txt");    //creates a new file instance
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String line;
            while((line=br.readLine())!=null)
            {
                String []strings = line.split(" ");
                people.add(new Person(strings[0],strings[1],strings[2],
                        Integer.parseInt(strings[3]),Double.parseDouble(strings[4])));

            }
            fr.close();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }


        return people;
    }

}
