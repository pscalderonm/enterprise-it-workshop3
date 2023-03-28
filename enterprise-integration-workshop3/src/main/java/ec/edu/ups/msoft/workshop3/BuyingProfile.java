package ec.edu.ups.msoft.workshop3;

public class BuyingProfile {
    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    private String channel;

    public BuyingProfile(String channel) {
        this.channel = channel;
    }
}
