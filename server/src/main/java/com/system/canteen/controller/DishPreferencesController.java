package com.system.canteen.controller;

import com.system.canteen.entity.DishPreferences;
import com.system.canteen.service.DishPreferencesService;
import com.system.canteen.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;


/**
 * 菜品偏好：(DishPreferences)表控制层
 *
 */
@RestController
@RequestMapping("/dish_preferences")
public class DishPreferencesController extends BaseController<DishPreferences, DishPreferencesService> {

    /**
     * 菜品偏好对象
     */
    @Autowired
    public DishPreferencesController(DishPreferencesService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
