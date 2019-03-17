package com.star.controller;


import com.star.model.Children;
import com.star.model.AjaxReturnForm;
import io.ebean.Ebean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("children")
public class ChildrenController {

    /**
     * 根据ID查询
     */
    @RequestMapping("searchById")
    @ResponseBody
    public AjaxReturnForm searchById(String activeId){
        Children children= new Children();
        children.setAge(12);
        Ebean.save(children);
        return new AjaxReturnForm(true,null,null);
    }


}
