import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location {

    DataStatus dataStatus;
    String addressId;
    String postalCode;
    String countryCode;
    String state;
    String province;
    String city;
    String district;

    public Location() {

    }

    public Location(DataStatus status) {
        this.dataStatus = status;
    }

    public DataStatus getDataStatus() {
        return dataStatus;
    }

    public String getAddressId() {
        return addressId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getState() {
        return state;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }
}
