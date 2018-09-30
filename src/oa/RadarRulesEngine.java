package oa;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RadarRulesEngine {


}

class Transaction {

    private static final String PATTERN = "^CHARGE\\s*:\\s*card_country=([a-zA-Z]+)&currency=([a-zA-Z]+)&amount=([0-9]+)&ip_country=([a-zA-Z]+)";

    String cardCountry;
    String currency;
    String ipCountry;
    int amount;

    // "CHARGE:...."
    public Transaction(String str) {
        Pattern pattern = Pattern.compile(PATTERN);

        Matcher matcher = pattern.matcher(str);

        if (matcher.matches()) {
            this.cardCountry = matcher.group(1);
            this.currency = matcher.group(2);
            this.amount = Integer.parseInt(matcher.group(3));
            this.ipCountry = matcher.group(4);
        }
    }

    @Override
    public String toString() {
        return "oa.Transaction{" +
                "cardCountry='" + cardCountry + '\'' +
                ", currency='" + currency + '\'' +
                ", ipCountry='" + ipCountry + '\'' +
                ", amount=" + amount +
                '}';
    }

    public String getCardCountry() {
        return cardCountry;
    }

    public String getCurrency() {
        return currency;
    }

    public String getIpCountry() {
        return ipCountry;
    }

    public int getAmount() {
        return amount;
    }

    public static void main(String[] args) {
        Transaction tra = new Transaction("CHARGE: card_country=US&currency=USD&amount=150&ip_country=CA");
        System.out.println(tra);
    }
}

class Rule {
    String attribute;
    String operator;
    String value;

    final String RULE_PATTERN = "^(ALLOW|BLOCK):([a-zA-Z_]*)(<|<=|>|>=|=|!=)([a-zA-Z0-9_]*)((AND|OR)([a-zA-Z_]*)(<|<=|>|>=|=|!=)([a-zA-Z0-9_]*))*$";

    public Rule(String str) {
        Pattern pattern = Pattern.compile(RULE_PATTERN);

        System.out.println(str.replaceAll("\\s", ""));
        Matcher matcher = pattern.matcher(str.replaceAll("\\s", ""));
        System.out.println(matcher.matches());

        System.out.println(matcher.groupCount());
        matcher.start();
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
        System.out.println(matcher.group(3));
        System.out.println(matcher.group(4));
        System.out.println(matcher.group(5));
        System.out.println(matcher.group(6));
        System.out.println(matcher.group(7));
        System.out.println(matcher.group(8));
        System.out.println(matcher.group(9));
    }

    public static void main(String[] args) {
        Rule rule = new Rule("BLOCK: card_country != ip_country ");
    }
}
