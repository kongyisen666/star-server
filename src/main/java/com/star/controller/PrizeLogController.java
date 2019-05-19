package com.star.controller;

import com.framework.util.ModelUtil;
import com.star.model.AjaxReturnForm;
import com.star.model.Prize;
import com.star.model.PrizeLog;
import com.star.service.PrizeLogService;
import com.star.service.PrizeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/prize_log")
public class PrizeLogController {

    /**
     * 新增奖品日志
     *
     * @param map
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public AjaxReturnForm add(@RequestBody Map<String, Object> map) {
        PrizeLog prizeLog = (PrizeLog) ModelUtil.toModel(map, PrizeLog.class);
        PrizeLogService prizeLogService = new PrizeLogService();
        prizeLogService.AddPrizeLog(prizeLog);
        return new AjaxReturnForm().addSuccess(null);
    }
}
