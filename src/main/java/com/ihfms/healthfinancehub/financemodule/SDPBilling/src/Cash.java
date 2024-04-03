import java.util.Scanner;

public class Cash implements Billing
{
    public PaymentInfo paymentInfo;
    Scanner scan = new Scanner(System.in);
    public Cash(PaymentInfo paymentInfo)
    {
        this.paymentInfo = paymentInfo;
    }

    @Override
    public void PaymentNumber()
    {
    }
}
