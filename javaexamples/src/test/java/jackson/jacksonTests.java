package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class jacksonTests {


    @Test //Jackson ObjectMapper Example
    public void loadDataFromJsonToObjectWithNoGetterOrSetters() {
        ObjectMapper objectMapper = new ObjectMapper();

        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

        try {

            Car car = objectMapper.readValue(carJson, Car.class);

            System.out.println("car.brand = " + car.brand);
            System.out.println("car.doors = " + car.doors);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test //Jackson ObjectMapper Example using getters and setters
    public void loadDataFromJsonToObject() {
        ObjectMapper objectMapper = new ObjectMapper();

        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

        try {

            Car2 car = objectMapper.readValue(carJson, Car2.class);

            System.out.println("car.brand = " + car.getBrand());
            System.out.println("car.doors = " + car.getDoors());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test //Jackson Tree Model Example
    public void loadDataFromJsonWithoutClassDetails(){

        JsonNode node;
        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

        ObjectMapper objectMapper = new ObjectMapper();

        try {

            node = objectMapper.readValue(carJson, JsonNode.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void naviagateJsonTree(){

        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5," +
                        "  \"owners\" : [\"John\", \"Jack\", \"Jill\"]," +
                        "  \"nestedObject\" : { \"field\" : \"value\" } }";

        ObjectMapper objectMapper = new ObjectMapper();


        try {

            JsonNode node = objectMapper.readValue(carJson, JsonNode.class);

            JsonNode brandNode = node.get("brand");
            String brand = brandNode.asText();
            System.out.println("brand = " + brand);

            JsonNode doorsNode = node.get("doors");
            int doors = doorsNode.asInt();
            System.out.println("doors = " + doors);

            JsonNode array = node.get("owners");
            JsonNode jsonNode = array.get(0);
            String john = jsonNode.asText();
            System.out.println("john  = " + john);

            JsonNode child = node.get("nestedObject");
            JsonNode childField = child.get("field");
            String field = childField.asText();
            System.out.println("field = " + field);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jsonFromAReader() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 4 }";
        Reader reader = new StringReader(carJson);

        Car car = objectMapper.readValue(reader, Car.class);
    }

    @Test
    public void readJsonFromAFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File("src/test/data/car.json");

        Car car = objectMapper.readValue(file, Car.class);

    }

    @Test
    public void readJsonFromURL() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        URL url = new URL("file:src/test/data/car.json");

        Car car = objectMapper.readValue(url, Car.class);
    }

    @Test
    public void readJsonFromInputStream() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        InputStream input = new FileInputStream("src/test/data/car.json");

        Car car = objectMapper.readValue(input, Car.class);
    }

    @Test
    public void readJsonFromByteArray() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

        byte[] bytes = carJson.getBytes("UTF-8");

        Car car = objectMapper.readValue(bytes, Car.class);
    }

    @Test
    public void generateJsonFromObjects() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Car car = new Car();
        car.brand = "BMW";
        car.doors = 4;

        objectMapper.writeValue(
                new FileOutputStream("src/test/data/output-2.json"), car);
    }

    @Test
    public void generateJsonUsingWriteValueAsString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Car car = new Car();
        car.brand = "BMW";
        car.doors = 4;

        String json = objectMapper.writeValueAsString(car);
        System.out.println(json);
    }
}