package com.cereal.shine.utils;

import org.apache.commons.lang3.StringUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class CerealUtility {

    private static final Map<String, Set<String>> MAP_PARAMS = Map.of("POSD", Set.of("A", "B"));
    private static final Map<String, String> ALERT = new HashMap<>(){{put("300", "A");put("301","B" );}};
    private static final List<String> LIST = Arrays.asList("US", "CA");
    private static final Map<String, Integer> REASONS= Map.of("x",1,"y",2) ;

    public static void main(String[] args) {
        String x= "x";
        String id = ALERT.entrySet().stream().filter(entry -> entry.getKey().contains(x)).map(Map.Entry::getValue).findFirst().orElse(null);
        MAP_PARAMS.entrySet().stream().filter(entry -> entry.getKey().equalsIgnoreCase(id)).map(Map.Entry::getValue).flatMap(Set::stream).forEach(param -> {
            if (param.equalsIgnoreCase("A")) {
                String y = "2";
            }
        });
        ObjectMapper objectMapper = new ObjectMapper();
        readJson(objectMapper);


    }

    public static Rules readJson(ObjectMapper objectMapper) {
        Rules rules = null;
        try (InputStream inputStream = CerealUtility.class.getClassLoader().getResourceAsStream("rule.json")){
            rules = objectMapper.readValue(inputStream,Rules.class);
        } catch (IOException ioException){
            ioException.printStackTrace();
        }

        return rules;
    }

    public String readJson2(ObjectMapper objectMapper) throws IOException {
        String u = "US";
        String local = null;
        InputStream inputStream = this.getClass().getResourceAsStream("filename");
        List<String> pref = objectMapper.readValue(inputStream, new TypeReference<>(){});

        if (local == null || local.isEmpty()){
            for (String upref: pref){
                if (upref.contains(u)){
                    local = upref.toString();
                }
            }

        }

        Integer reasonId = REASONS.entrySet().stream().filter(entry->entry.getKey().contains(u)).map(Map.Entry::getValue).findFirst().orElse(9);
        Integer rId = LIST.stream().filter(rCode->rCode.contains(u)).map(this::util).findFirst().orElse(9);
        return local;

    }

    public Integer util (String c){
        return null;
    }
    public static List<UEvent> getEvent(String eventId,ObjectMapper objectMapper){
        Rules rules = readJson(objectMapper);
        List<UEvent> eventList = switch (eventId) {
            case "event1" -> rules.getEvent1();
            case "event2" -> rules.getEvent2();
            default -> null;
        };
return eventList;
    }

    public static String getHeader(String value){
        String eventId= "event1";
        ObjectMapper objectMapper = new ObjectMapper();
        List<UEvent> headerList = getEvent("event1", objectMapper);
        String header = null;
        for (UEvent event: headerList){
            if (StringUtils.isNotBlank(event.getKey().getCode())){
                if(event.getKey().getCode().equals(value)){
                    header = event.getValue().getHeader();
                }
            }
        }
        return header;
    }
}
