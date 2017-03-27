package jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Test on 3/27/2017.
 */
public class Car{

    @JsonProperty("brand")
    String brand;

    @JsonProperty("doors")
    Integer doors;
}
