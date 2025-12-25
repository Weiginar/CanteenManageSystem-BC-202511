package com.system.canteen.controller;

import com.system.canteen.entity.TurnoverInformation;
import com.system.canteen.service.TurnoverInformationService;
import com.system.canteen.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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
