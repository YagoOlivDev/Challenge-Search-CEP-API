import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        CEPQuery addressquery = new CEPQuery();

        FileGenerator generator = new FileGenerator();

        Scanner reading = new Scanner(System.in);

        String cep;
        int option;


        while (true)
        {
            System.out.println("""
                    =================
                          -Menu-
                    =================
                    1- check zip code
                    2- Exit
                    ==================
                    Enter your option: 
                    """);
            option = reading.nextInt();
            reading.nextLine();

            if(option == 1)
            {
                try {
                    System.out.println("write your zip code: ");
                    cep = reading.nextLine();
                    Address address = addressquery.AddressSearch(cep);
                    generator.GenerateJsonFile(address);
                    System.out.println(address);
                } catch (RuntimeException | IOException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Ffinalizing application");
                }
            }
            else if (option == 2)
            {
                System.out.println("Program closed!");
                break;
            }
            else
            {
                System.out.println("Please enter a valid option");
                continue;
            }
        }
    }
}