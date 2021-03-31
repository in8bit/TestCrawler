public class ContactDetails {
    private String Tile;
    private String name;
    private String phone_number;
    private String address;
    private String email;

    public ContactDetails(){

    }

    public String getTile() {
        return Tile;
    }

    public void setTile(String tile) {
        Tile = tile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactDetails(){
        return "Page Title: "+ this.Tile+
                "Name: "+ this.name +
                "Phone Number: "+ this.phone_number+
                "Email Address: "+ this.email +
                "Mailing Address: "+ this.address;

    }
}
