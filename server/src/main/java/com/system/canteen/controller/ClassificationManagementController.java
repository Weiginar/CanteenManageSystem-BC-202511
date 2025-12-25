package com.system.canteen.controller;

import com.system.canteen.entity.ClassificationManagement;
import com.system.canteen.service.ClassificationManagementService;
import com.system.canteen.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;


/**
 * 分类管理：(ClassificationManagement)表控制层
 *
 */
@RestController
@RequestMapping("/classification_management")
public class ClassificationManagementController extends BaseController<ClassificationManagement, ClassificationManagementService> {

    /**
     * 分类管理对象
     */
    @Autowired
    public ClassificationManagementController(ClassificationManagementService service) {
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
