package com.project.demo.controller;

import com.project.demo.entity.TurnoverInformation;
import com.project.demo.service.TurnoverInformationService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 营业额信息：(TurnoverInformation)表控制层
 *
 */
@RestController
@RequestMapping("/turnover_information")
public class TurnoverInformationController extends BaseController<TurnoverInformation, TurnoverInformationService> {

    /**
     * 营业额信息对象
     */
    @Autowired
    public TurnoverInformationController(TurnoverInformationService service) {
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
