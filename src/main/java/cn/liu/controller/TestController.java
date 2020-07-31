package cn.liu.controller;


import cn.liu.pojo.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("tc")
public class TestController {

    @RequestMapping("demo.do")
    public String demo(){
        return "demo";
    }

    @RequestMapping(value = "demo.ajax",produces = "application/text;charset=utf-8")
    @ResponseBody
    public String demo1(String[] a){
        for (String str: a) {
            System.err.println(str);
        }
        return "11111";
    }
}