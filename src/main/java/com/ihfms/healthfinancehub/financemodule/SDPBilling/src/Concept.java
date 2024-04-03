public class Concept
{ 
    public static CaptureBasic basic = new CaptureBasic(new PaymentInfo());
    public static ChooseMode mode = new ChooseMode();
    public static ConfirmPayment confirm = new ConfirmPayment();
    private Billing bill;
    public Concept(Billing billing)
    {
        this.bill = billing;
    }
    public void CallMode()
    {
        bill.PaymentNumber();
    }
}
