package com.server.eureka.eurekaserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Testing {

    public void testingMethod() throws JsonProcessingException {
        /*ObjectMapper mapper = new ObjectMapper();
        Set<Long> set = new HashSet<>();

        set.add(1L);
        set.add(2L);
        set.add(3L);

        String setStr = mapper.writeValueAsString(set);

        System.out.println("\n*************************************");
        System.out.println(setStr);
        System.out.println(mapper.readValue(setStr, Set.class));
        System.out.println(mapper.readValue(setStr, Set.class).contains(1L));
        System.out.println("*************************************\n");

        System.out.println("\n*************************************");
        System.out.println(getDateValueForTpn("29-08-2021 20:41"));
        System.out.println("*************************************\n");

        //String value = "<p><strong><span style=\"color: #ff0000;\">ISO</span></strong>tretinoin 20 mg capsule</p> / Xeractan 20 mg capsule";
        String value = "ISOtretinoin 20 mg capsule / Xeractan 20 mg capsule";
        System.out.println("Before removing HTML Tags: " + value);
        value = value.replaceAll("\\<.*?\\>", "");
        System.out.println("After removing HTML Tags: " + value);*/
    }

    public Date getDateValueForTpn(String dateTime) {
        Date returnDate = null;

        try {
            returnDate = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(dateTime);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnDate;
    }
}
