package Server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

public class AdminCoins extends LogIn implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        try {
            if(isCookieTypeAsAcces("admin",httpExchange)) {

                JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/admincoins.twig");
                JtwigModel model = JtwigModel.newModel();
                String response = template.render(model);
                sendResponse(response, httpExchange);

            }
            else{
                loadLoginSite(httpExchange);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}