package com.star.controller;


import com.star.model.AjaxReturnForm;
import com.star.service.RewardPunishService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/reward_punish")
public class RewardPunishController {

    @ResponseBody
    @RequestMapping(value = "/search_by_type")
    public AjaxReturnForm searchByType(@RequestBody Map<String, String> map){
        System.out.println(11111111);
        Integer type = Integer.parseInt(map.get("type"));
        if (null == type){
            return  new AjaxReturnForm().addSuccess(null);
        }
        RewardPunishService rewardPunishService = new RewardPunishService();
        return new AjaxReturnForm().addSuccess(rewardPunishService.searchByType(type));
    }
}
