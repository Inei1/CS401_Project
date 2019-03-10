// Vincent Rusca

public class Address {
    // address fields
    String streetAddress;
    String cityAddress;
    String stateAddress;
    String zipAddress;

    // constructors
    public Address() {
        streetAddress = "";
        cityAddress = "";
        stateAddress = "";
        zipAddress = "";
    }
    public Address(String _streetAddress, String _cityAddress, String _stateAddress, String _zipAddress) {
        streetAddress = _streetAddress;
        cityAddress = _cityAddress;
        stateAddress = _stateAddress;
        zipAddress = _zipAddress;
    }

    // getters
    public String getStreetAddress() {
        return streetAddress;
    }
    public String getCityAddress() {
        return cityAddress;
    }
    public String getStateAddress() {
        return stateAddress;
    }
    public String getZipAddress() {
        return zipAddress;
    }

    // setters
    public void setStreetAddress(String _streetAddress) {
        streetAddress = _streetAddress;
    }
    public void setCityAddress(String _cityAddress) {
        cityAddress = _cityAddress;
    }
    public void setStateAddress(String _stateAddress) {
        stateAddress = _stateAddress;
    }
    public void setZipAddress(String _zipAddress) {
        zipAddress = _zipAddress;
    }

    public String toString() {
        return streetAddress + " " + cityAddress + ", " + stateAddress + " " + zipAddress;
    }
}
