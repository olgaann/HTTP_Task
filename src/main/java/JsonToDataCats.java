import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonToDataCats {
    public static ObjectMapper mapper = new ObjectMapper();

    public static List<DataCats> convert(String jsonString) throws JsonProcessingException {
        return mapper.readValue(jsonString, new TypeReference<>() {});
    }
}
