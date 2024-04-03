import java.util.Scanner;
public class CaptureBasic
{
    Scanner scan = new Scanner(System.in);
    public PaymentInfo paymentInfo;
    public CaptureBasic(PaymentInfo payInfo)
    {
        this.paymentInfo = payInfo;
    }
    public void CaptureInfo()
    {
        System.out.print("Patient Name:");
        var patientName = scan.next();

        System.out.print("Payment for:");
        var payFor = scan.next();

        System.out.print("Amount:");
        var amount = scan.nextInt();
    }
}
