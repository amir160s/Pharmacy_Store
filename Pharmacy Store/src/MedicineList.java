import javax.imageio.IIOException;
import java.io.File;
public class MedicineList extends Medicine{
    private String medicineName, expDate,genericName,companyName;
    private int totalQuantity;
    private double price;
    public MedicineList(String medicineName, String genericName, String companyName, double price, String expDate, int totalQuantity)
    {
        this.companyName=companyName;
        this.price=price;
        this.totalQuantity=totalQuantity;
        this.medicineName=medicineName;
        this.genericName=genericName;
        this.expDate=expDate;
    }

    public void file_notFound()throws IIOException{
        System.out.println("File not found");
    }


    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getTotalQuantity() {
        System.out.println(12);
        return totalQuantity;
    }

    public String getCompanyName() {
        System.out.println("ACI");
        return companyName;
    }

    public String getExpDate() {
        System.out.println("12/12/2025");
        return expDate;
    }

    public String getMedicineName() {
        System.out.println("AAAA");
        return medicineName;
    }

    public double getPrice() {
        System.out.println(145.3);
        return price;
    }

    public String getGenericName() {
        System.out.println("BBBB");
        return genericName;
    }

    @Override
    public String toString() {
        return "MedicineList:"+"\n" +
                " Medicine Name= " + medicineName + "\n" +
                " Exp Date= " + expDate + "\n" +
                " Generic Name= " + genericName + "\n" +
                " CompanyName= " + companyName + "\n" +
                " TotalQuantity= " + totalQuantity +"\n"+
                " price=" + price ;
    }
}
