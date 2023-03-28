package ec.edu.ups.msoft.workshop3;

public class ClientOutput {
    private String uid;
    private String names;
    private String address;
    private String phone;

    private BuyingProfile buyingProfile;

    public ClientOutput(){}

    public ClientOutput(ClientModel model){
        this.uid = model.getUid();
        this.names = model.getNames();
        this.address = model.getAddress();
        this.phone = model.getPhone();
        this.buyingProfile = new BuyingProfile(model.getBuyingChannel());
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BuyingProfile getBuyingProfile() {
        return buyingProfile;
    }

    public void setBuyingProfile(BuyingProfile buyingProfile) {
        this.buyingProfile = buyingProfile;
    }
}

