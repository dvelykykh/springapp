package springapp.web;

import java.util.Map;

import junit.framework.TestCase;

import org.springframework.web.servlet.ModelAndView;

import springapp.service.SimpleProductManager;
import springapp.web.InventoryController;

public class InventoryControllerTests extends TestCase {

    public void testHandleRequestView() throws Exception{		
        InventoryController controller = new InventoryController();
        SimpleProductManager spm = new SimpleProductManager();
        spm.setProductDao(new InMemoryProductDao(new ArrayList<Product>()));
        controller.setProductManager(spm);
        //controller.setProductManager(new SimpleProductManager());
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        Map<String, Object> modelMap = (Map<String, Object>)modelAndView.getModel().get("model");
        String nowValue = (String)modelMap.get("now");
        assertNotNull(nowValue);
    }
}