package com.acme.ecommerce.controller;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class WebConstants {
    public static final List<String> LIST_STATES = Arrays.asList("AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY");
    public static final List<String> LIST_COUNTRIES = Arrays.asList("USA", "Canada", "Mexico");
    public static final List<String> LIST_MONTHS = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
    public static final List<Integer> LIST_YEARS = IntStream.range(Year.now().getValue(),Year.now().getValue() + 5).boxed().collect(Collectors.toList());
    public static final BigDecimal COST_PER_ITEM = new BigDecimal(2.58);
    public static final String REDIRECT_TO_BASE = "redirect:/product/";
}
