package com.ibm.cic.br.seeds;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        App $app = new App();
        String json = $app.getProspectJson();

        List<Prospect> prospects = $app.convertToProspectList(json);
        prospects.forEach(System.out::println);

        Optional<Prospect> optionalProspect = $app.example1(prospects);
        System.out.println(optionalProspect);

        optionalProspect = $app.example2(prospects);
        System.out.println(optionalProspect);

        Map<String, Long> residentStateMap = $app.example3(prospects);
        residentStateMap.forEach((k, v) ->
                System.out.println((k + ":" + v))
        );

        prospects = $app.example4(prospects);
        prospects.forEach(System.out::println);

        List<Customer> customers = $app.example5(prospects, "MS");
        customers.forEach(System.out::println);
    }

    /**
     * @param json
     * @return List<Prospect>
     * @throws IOException
     * @description This method converts the JSON string to a list of Prospect.
     */
    public List<Prospect> convertToProspectList(String json) throws IOException {
        ObjectMapper objectMapper;
        objectMapper = new ObjectMapper();

        List<Prospect> prospects = objectMapper.readValue(json, new TypeReference<List<Prospect>>() {
        });
        return prospects;
    }

    /**
     * @param -
     * @return String
     * @throws IOException
     * @description This method reads ths prospects.json from the resources directory.
     */
    public String getProspectJson() throws IOException {
        String json;
        ClassLoader classLoader = getClass().getClassLoader();
        json = IOUtils.toString(classLoader.getResourceAsStream("prospects.json"));
        return json;
    }

    /**
     * @param prospects
     * @return Optional<Prospect>
     * @throws
     * @description This methods filters the list of prospects for any where the last name begins with "S".
     */
    public Optional<Prospect> example1(List<Prospect> prospects) {
        return prospects.stream().
                filter(prospect -> prospect.getLastName().startsWith("S"))
                .findAny();
    }

    /**
     * @param prospects
     * @return Optional<Prospect>
     * @throws
     * @description This methods filters the list of prospects for any with where the add date year equals 2018.
     */
    public Optional<Prospect> example2(List<Prospect> prospects) {
        return prospects.stream().
                filter(prospect -> 2018 == LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd")
                        .format(prospect.getAddDate())).getYear())
                .findAny();
    }

    /**
     * @param prospects
     * @return Optional<Prospect>
     * @throws
     * @description This methods collects the list of prospects as a map of states by count.
     */
    public Map<String, Long> example3(List<Prospect> prospects) {
        Map<String, Long> countByResidentState = prospects
                .stream()
                .collect(groupingBy(Prospect::getResidentState, Collectors.counting()));
        return countByResidentState;
    }

    /**
     * @param prospects
     * @return Optional<Prospect>
     * @throws
     * @description This methods collects the list of prospects as a map of states by count.
     */
    public List<Prospect> example4(List<Prospect> prospects) {
        Stream<Prospect> stream = prospects.stream()
                .filter(prospect -> "LA".equalsIgnoreCase(prospect.getResidentState()));
        return stream.collect(Collectors.toList());
    }

    /**
     * @param prospects, stateCode
     * @return List<Customer>
     * @throws
     * @description This methods filters the list of prospects by state and converts the prospect to a customer.
     */
    public List<Customer> example5(List<Prospect> prospects, String stateCode) throws Exception {
        Stream<Customer> stream = prospects.stream()
                .filter(prospect -> stateCode.equalsIgnoreCase(prospect.getResidentState()))
                .map(new Function<Prospect, Customer>() {
                    @Override
                    public Customer apply(Prospect person) {
                        return new Customer(person);
                    }
                });

        return stream.collect(Collectors.toList());
    }

    /**
     * To Do: Using map, create a list of Strings for the prospects' fullName
     */
    public List<String> example6(List<Prospect> prospects) {
        throw new NotImplementedException();
    }

    /**
     * To Do: Using filter, return a list of prospects with subnet /13 or /24
     */
    public List<Prospect> example7(List<Prospect> prospects) {
        throw new NotImplementedException();
    }


    /**
     * To Do: Using filter and map, convert prospects to customer where last name ends with "son" and return a list of customers
     */

    public List<Customer> example8(List<Prospect> prospects) {
        throw new NotImplementedException();
    }

    /**
     * To Do: Using map, convert prospects to customer and return Map<String, Long> where String is subnet and Long is count
     */

    public Map<String, Long> example9(List<Prospect> prospects) {
        throw new NotImplementedException();
    }

    /**
     * To Do: Convert list of prospects to a list customers adding 30 days to the prospects' add date and setting the new date as the customers' conversion data, return the list of customerss
     */

    public List<Customer> example10(List<Prospect> prospects) {
        throw new NotImplementedException();
    }
}
