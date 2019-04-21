package com.star.controller;

import com.star.model.AjaxReturnForm;
import com.star.model.ScoreLog;
import io.ebean.Ebean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/score_log")
public class ScoreLogController {

    @RequestMapping("/search_by_children_id")
    @ResponseBody
    public AjaxReturnForm searchByChildrenId(@RequestBody Map<String, String> map){
        Integer childrenId = Integer.parseInt(map.get("childrenId"));
        if (null==childrenId){
            return new AjaxReturnForm().returnErrorMsg("孩子Id不存在");
        }
        Integer maxRows = Integer.parseInt(map.get("maxRows"));
        if(null==maxRows){
            maxRows = 10;
        }
        List<ScoreLog> list = Ebean.find(ScoreLog.class).where().eq("childrenId", childrenId).orderBy("id desc").setMaxRows(maxRows).findList();
        return new AjaxReturnForm().addSuccess(list);
    }
}
