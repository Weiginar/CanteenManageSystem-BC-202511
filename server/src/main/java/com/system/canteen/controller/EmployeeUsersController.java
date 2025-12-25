package com.system.canteen.controller;

import com.system.canteen.entity.EmployeeUsers;
import com.system.canteen.service.EmployeeUsersService;
import com.system.canteen.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 员工用户：(EmployeeUsers)表控制层
 *
 */
@RestController
@RequestMapping("/employee_users")
public class EmployeeUsersController extends BaseController<EmployeeUsers, EmployeeUsersService> {

    /**
     * 员工用户对象
     */
    @Autowired
    public EmployeeUsersController(EmployeeUsersService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> mapemployee_id = new HashMap<>();
        mapemployee_id.put("employee_id",String.valueOf(paramMap.get("employee_id")));
        List listemployee_id = service.select(mapemployee_id, new HashMap<>()).getResultList();
        if (listemployee_id.size()>0){
            return error(30000, "字段员工工号内容不能重复");
        }
        this.addMap(paramMap);
        return success(1);
    }

}
