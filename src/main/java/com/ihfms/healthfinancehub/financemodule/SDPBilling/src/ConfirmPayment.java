import java.util.Scanner;

public class ConfirmPayment
{
    public void Finish()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("OK to Proceed:");
        var confirmation = scan.nextLine();

        switch(confirmation)
        {
            case "OK":
                System.out.print("Payment confirmed.");
                break;
            default:
                System.out.print("Payment cancelled.");
        }
    }
}
