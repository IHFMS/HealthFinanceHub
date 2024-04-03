import java.util.Scanner;
public class ChooseMode
{
    Scanner scan = new Scanner(System.in);
    public Concept SetMode()
    {
        System.out.print("Choose MM, CASH or CARD:");
        var mode = scan.nextLine();

        switch(mode)
        {
            case "mm":
                return new Concept(new MobileMoney());
            case "card":
                return new Concept(new Card(new PaymentInfo()));
            default:
                return new Concept(new Cash(new PaymentInfo()));
        }
    }
}
