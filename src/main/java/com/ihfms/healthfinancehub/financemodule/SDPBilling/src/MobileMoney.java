import java.util.Scanner;

public class MobileMoney implements Billing
{
    Scanner scan = new Scanner(System.in);
    @Override
    public void PaymentNumber()
    {
        System.out.print("PhoneNumber:");
        var phoneNumber = scan.nextBigInteger();
    }
}
