package pl.maro.wypok.client.home;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.maro.wypok.domain.api.CategoryName;
import pl.maro.wypok.domain.api.CategoryService;
import pl.maro.wypok.domain.api.DiscoveryBasicInfo;
import pl.maro.wypok.domain.api.DiscoveryService;


import java.io.IOException;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {
    private final DiscoveryService discoveryService = new DiscoveryService();
    private final CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DiscoveryBasicInfo> discoveries = discoveryService.findAll();
        request.setAttribute("discoveries", discoveries);
        List<CategoryName> categories = categoryService.findAllCategoryNames();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }
}