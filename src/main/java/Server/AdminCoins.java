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
                sendResponse(createResponse(), httpExchange);
            }
            else{
                loadLoginSite(httpExchange);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    String createResponse() throws IOException {
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/admincoins.twig");
        JtwigModel model = JtwigModel.newModel();
        return template.render(model);
    }
}