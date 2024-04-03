import java.util.Scanner;

public class Card implements Billing
{
    public PaymentInfo paymentInfo;
    Scanner scan = new Scanner(System.in);
    public Card(PaymentInfo paymentInfo)
    {
        this.paymentInfo = paymentInfo;
    }

    @Override
    public void PaymentNumber()
    {
        System.out.print("CardNumber:");
        var cardNumber = scan.nextBigInteger();
    }
}
