import java.util.Date;

public class PaymentInfo
{
    private String patientName;
    private int amount;
    private String payFor;
    private Date date;
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPayFor(String payFor) {
        this.payFor = payFor;
    }

    public String getPayFor() {
        return payFor;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
