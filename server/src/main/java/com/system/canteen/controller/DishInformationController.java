package com.system.canteen.controller;

import com.system.canteen.entity.DishInformation;
import com.system.canteen.service.DishInformationService;
import com.system.canteen.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;


/**
 * 菜品信息：(DishInformation)表控制层
 *
 */
@RestController
@RequestMapping("/dish_information")
public class DishInformationController extends BaseController<DishInformation, DishInformationService> {

    /**
     * 菜品信息对象
     */
    @Autowired
    public DishInformationController(DishInformationService service) {
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
