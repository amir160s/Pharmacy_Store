public class AgentMediList extends MedicineList implements AgentMedicine {
    public AgentMediList(String medicineName, String genericName, String companyName,String expDate, double price, int totalQuantity) {
        super(medicineName, genericName, companyName, price, expDate, totalQuantity);
        super.toString();
    }

   /* public AgentMediList(String medicineName, String genericName, String expDate, double price, int totalQuantity) {
        super();
    }

    */
    /*public AgentMediList(String medicineName, String genericName, String companyName, double price, String expDate, int totalQuantity)
    {
        super(medicineName, genericName, companyName, price, expDate, totalQuantity);
    }

     */

    @Override
    public String getMedicineName() {
        return super.getMedicineName();
    }

    @Override
    public String getGenericName() {
        return super.getGenericName();
    }

    @Override
    public String getCompanyName() {
        return super.getCompanyName();
    }

    @Override
    public String getExpDate() {
        return super.getExpDate();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public int getTotalQuantity() {
        return super.getTotalQuantity();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
