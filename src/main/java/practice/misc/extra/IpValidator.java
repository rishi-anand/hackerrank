package practice.misc.extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpValidator {

    private static final int MAX_OCTET_VALUE_IPV4 = 255;
    private static final String IPV4_REGEX = "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$";

    private static final int IPV6_MAX_HEX = 8;
    private static final int BASE_16 = 16;
    private static final int MAX_HEX_DIGITS_PER_GROUP_IPV6 = 4;
    private static final int MAX_UNSIGNED_SHORT_IPV6 = 0xffff;

    private static final String IPV4_RESULT_STRING = "IPv4";
    private static final String IPV6_RESULT_STRING = "IPv6";
    private static final String DEFAULT_RESULT_STRING = "Neither";

    public static List<String> validateAddresses(List<String> addresses) {
        List<String> result = new ArrayList<>();
        if(addresses != null && !addresses.isEmpty()){
            addresses.stream()
                    .forEach(ip -> {
                        if(isValidInet4Address(ip)) {
                            result.add(IPV4_RESULT_STRING);
                        } else if(isValidInet6Address(ip)) {
                            result.add(IPV6_RESULT_STRING);
                        } else {
                            result.add(DEFAULT_RESULT_STRING);
                        }
                    });
        }
        return result;
    }

    public static boolean isValidInet4Address(String inet4Address) {
        String[] ipv4Cells = match(inet4Address);
        if (ipv4Cells == null) {
            return false;
        }

        for (String ipv4Cell : ipv4Cells) {
            if (ipv4Cell == null || ipv4Cell.length() == 0) {
                return false;
            }

            int iIpSegment = 0;

            try {
                iIpSegment = Integer.parseInt(ipv4Cell);
            } catch(NumberFormatException e) {
                return false;
            }

            if (iIpSegment > MAX_OCTET_VALUE_IPV4) {
                return false;
            }

            if (ipv4Cell.length() > 1 && ipv4Cell.startsWith("0")) {
                return false;
            }

        }

        return true;
    }


    public static boolean isValidInet6Address(String inet6Address) {
        boolean containsCompressedZeroes = inet6Address.contains("::");
        if (containsCompressedZeroes && inet6Address.indexOf("::") != inet6Address.lastIndexOf("::")) {
            return false;
        }
        if (inet6Address.startsWith(":") && !inet6Address.startsWith("::")
                || inet6Address.endsWith(":") && !inet6Address.endsWith("::")) {
            return false;
        }
        String[] ipv6Cell = inet6Address.split(":");
        if (containsCompressedZeroes) {
            List<String> octetList = new ArrayList<String>(Arrays.asList(ipv6Cell));
            if (inet6Address.endsWith("::")) {
                octetList.add("");
            } else if (inet6Address.startsWith("::") && !octetList.isEmpty()) {
                octetList.remove(0);
            }
            ipv6Cell = octetList.toArray(new String[octetList.size()]);
        }
        if (ipv6Cell.length > IPV6_MAX_HEX) {
            return false;
        }

        int validOctets = 0;
        int emptyOctets = 0;
        for (int index = 0; index < ipv6Cell.length; index++) {
            String octet = ipv6Cell[index];
            if (octet.length() == 0) {
                emptyOctets++;
                if (emptyOctets > 1) {
                    return false;
                }
            } else {
                emptyOctets = 0;
                if (octet.contains(".")) {
                    if (!inet6Address.endsWith(octet)) {
                        return false;
                    }
                    if (index > ipv6Cell.length - 1 || index > 6) {
                        return false;
                    }
                    if (!isValidInet4Address(octet)) {
                        return false;
                    }
                    validOctets += 2;
                    continue;
                }
                if (octet.length() > MAX_HEX_DIGITS_PER_GROUP_IPV6) {
                    return false;
                }
                int octetInt = 0;
                try {
                    octetInt = Integer.valueOf(octet, BASE_16).intValue();
                } catch (NumberFormatException e) {
                    return false;
                }
                if (octetInt < 0 || octetInt > MAX_UNSIGNED_SHORT_IPV6) {
                    return false;
                }
            }
            validOctets++;
        }
        if (validOctets < IPV6_MAX_HEX && !containsCompressedZeroes) {
            return false;
        }
        return true;
    }

    public static String[] match(String value) {
        if (value == null) {
            return null;
        }

        Pattern pattern = Pattern.compile(IPV4_REGEX);
        Matcher matcher = pattern.matcher(value);
        if (matcher.matches()) {
            int count = matcher.groupCount();
            String[] groups = new String[count];
            for (int j = 0; j < count; j++) {
                groups[j] = matcher.group(j+1);
            }
            return groups;
        }
        return null;
    }

    public static void main(String[] args){

        List<String> input = new ArrayList<>();
        input.add("2001:0db8:0000:0000:0000:ff00:0042:8329");
        input.add("2001:db8:0:0:0:ff00:42:8329");
        input.add("2001:db8::ff00:42:8329");
        input.add("0000:0000:0000:0000:0000:0000:0000:0001");
        input.add("::1");


//        for(String ss : input){
//            System.out.println(isValidInet6Address(ss));
//        }

        System.out.println(isValidInet6Address("1:22:333:4444."));
    }



}
