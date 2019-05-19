package com.star.controller;

import com.framework.util.ModelUtil;
import com.star.model.AjaxReturnForm;
import com.star.model.Children;
import com.star.model.Prize;
import com.star.model.User;
import com.star.service.PrizeService;
import com.star.service.UserService;
import io.ebean.Ebean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/prize")
public class PrizeController {

    /**
     * 新增或修改
     *
     * @param map
     * @return
     */
    @RequestMapping("/set_prize")
    @ResponseBody
    public AjaxReturnForm setOrUpdatePrize(@RequestBody Map<String, Object> map) {
        Prize prize = (Prize) ModelUtil.toModel(map, Prize.class);
        PrizeService prizeService = new PrizeService();
        prizeService.setOrUpdate(prize);
        return new AjaxReturnForm().addSuccess(null);
    }

    /**
     * 查新奖品信息
     *
     * @param map
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    public AjaxReturnForm search(@RequestBody Map<String, String> map) {
        String userId = map.get("userId");
        PrizeService prizeService = new PrizeService();
        Prize prize = prizeService.searchPrize(userId);
        return new AjaxReturnForm().addSuccess(prize);
    }

}
