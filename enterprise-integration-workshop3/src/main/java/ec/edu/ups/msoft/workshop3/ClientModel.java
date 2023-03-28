package ec.edu.ups.msoft.workshop3;

public class ClientModel {
    private String uid;
    private String names;
    private String address;
    private String phone;
    private String buyingChannel;

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

    public String getBuyingChannel() {
        return buyingChannel;
    }

    public void setBuyingChannel(String buyingChannel) {
        this.buyingChannel = buyingChannel;
    }
}