import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerLocationData {

    EventType eventType;
    String marketplaceId;
    String customerId;
    String sessionId;
    String contextId;
    String ipAddress;


    Location userOverride;
    Location defaultAddress;
    ListWithStatus<Location> allAddresses;
    ListWithStatus<PastPurchase> pastPurchases;
    Location quovaLocation;
    Location maxMindLocation;
//    Map<String, String> weblabTreatments;

    public EventType getEventType() {
        return eventType;
    }

    public String getMarketplaceId() {
        return marketplaceId;
    }

    public Location getUserOverride() {
        return userOverride;
    }

    public Location getDefaultAddress() {
        return defaultAddress;
    }

    public ListWithStatus getAllAddresses() {
        return allAddresses;
    }

    public ListWithStatus<PastPurchase> getPastPurchases() {
        return pastPurchases;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getContextId() {
        return contextId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Location getQuovaLocation() {
        return quovaLocation;
    }

    public Location getMaxMindLocation() {
        return maxMindLocation;
    }
}
