package jackson;

import com.fasterxml.jackson.core.*;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Test on 3/28/2017.
 */
public class jacksonJsonParserTests {

    @Test
    public void createJsonParser() throws IOException {
        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

        JsonFactory factory = new JsonFactory();
        JsonParser parser  = factory.createParser(carJson);
    }

    @Test
    public void parseJsonWithJsonParser() throws IOException {
        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

        JsonFactory factory = new JsonFactory();
        JsonParser parser  = factory.createParser(carJson);

        while(!parser.isClosed()) {
            JsonToken jsonToken = parser.nextToken();

            System.out.println("jsonToken = " + jsonToken);
        }
    }

    @Test
    public void findOutTypeOfJsonToken() throws IOException {
        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

        JsonFactory factory = new JsonFactory();
        JsonParser  parser  = factory.createParser(carJson);

        Car car = new Car();
        while(!parser.isClosed()){
            JsonToken jsonToken = parser.nextToken();

            if(JsonToken.FIELD_NAME.equals(jsonToken)){
                String fieldName = parser.getCurrentName();
                System.out.println(fieldName);

                jsonToken = parser.nextToken();

                if("brand".equals(fieldName)){
                    car.brand = parser.getValueAsString();
                } else if ("doors".equals(fieldName)){
                    car.doors = parser.getValueAsInt();
                }
            }
        }

        System.out.println("car.brand = " + car.brand);
        System.out.println("car.doors = " + car.doors);

    }

    @Test
    public void createAJsonGenerator() throws IOException {
        JsonFactory factory = new JsonFactory();

        JsonGenerator generator = factory.createGenerator(
                new File("src/test/data/output.json"), JsonEncoding.UTF8);

    }

    @Test
    public void generateJsonWithGenerator() throws IOException {
        JsonFactory factory = new JsonFactory();

        JsonGenerator generator = factory.createGenerator(
                new File("src/test/data/output.json"), JsonEncoding.UTF8);

        generator.writeStartObject();
        generator.writeStringField("brand", "Mercedes");
        generator.writeNumberField("doors", 5);
        generator.writeEndObject();

        generator.close();
    }
}
