import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
    public static void main(String[] args) throws IOException {
//        String dis = "unifiedLocationContext_ALL_00";
//
//        final String PATTERN = "(.*)_(.*)_(.*)";
//        Pattern pattern = Pattern.compile(PATTERN);
//        Matcher matcher = pattern.matcher(dis);
//        System.out.println(matcher.matches());
//
//        System.out.println(matcher.groupCount());
//        System.out.println(matcher.group(1));
//        System.out.println(matcher.group());
//        System.out.println(matcher.group(2));
//        System.out.println(matcher.group(3));

//        System.out.println(createSessionIdFromCustomerId("12345"));

        ObjectMapper mapper = new ObjectMapper();

        CustomerLocationData data = new CustomerLocationData();
        data.eventType = EventType.CUSTOMER_LOCATION_DATA;
        data.marketplaceId = new MarketplaceId("ATVPDKIKX0DER");
        data.customerId = "A36NJBPMDXYFFL";
        data.sessionId = "145-0155562-7196542";
        data.contextId = "unifiedLocationContext";
        data.ipAddress = "54.240.196.171";

        Location userOverride = new Location(DataStatus.DATA_NOT_EXIST);
        Location defaultAddress = new Location(DataStatus.DATA_EXIST);
        defaultAddress.addressId = "GWJRVMD2LWQGW5UZBSQAG13M1DLWGQYSMKAKMSYQGWLD1MEPXTQ2FQA2OXT5YTUF";
        defaultAddress.countryCode = "US";
        defaultAddress.postalCode = "98134";


        data.userOverride = userOverride;
        data.defaultAddress = defaultAddress;
        data.pastPurchases = new ListWithStatus<>(DataStatus.UNKNOWN);

        ListWithStatus<Location> allAddress = new ListWithStatus<>(DataStatus.DATA_EXIST);
        allAddress.dataList.add(defaultAddress);
        data.allAddresses = allAddress;


        System.out.println(mapper.writeValueAsString(data));



//        CustomerLocationData locData = mapper.readValue(str, CustomerLocationData.class);
    }

     public static String createSessionIdFromCustomerId(final String customerId) {
         BigInteger id = new BigInteger(customerId, 36);
         String base10 = id.toString(10);
         StringBuilder session = new StringBuilder("00000000000000000");  // 17 times the '0' character
         session.replace(Math.max(0, 17 - base10.length()), 17, base10);
         session.insert(3, '-');//put the hyphens in the correct position for a 3-7-7 session ID
         session.insert(11, '-');
         return session.substring(0, 19);
    }
}
