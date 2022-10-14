import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.List;

public class Main {
    public static final String URL = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";

    public static void main(String[] args) {

        //получим строку json с указанного URL:
        String json;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(URL);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                json = new String(response.getEntity().getContent().readAllBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Преобразуем строку json в список java-объектов:
        List<DataCats> resultList;
        try {
            resultList = JsonToDataCats.convert(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //Отфильтруем полученный список и выведем на экран:
        System.out.println("Вот факты, за которые кто-то проголосовал: ");
        resultList.stream()
                .filter(dataCats -> dataCats.getUpvotes() != null)
                .filter(dataCats -> !dataCats.getUpvotes().equals("0"))
                .forEach(System.out::println);

    }
}
