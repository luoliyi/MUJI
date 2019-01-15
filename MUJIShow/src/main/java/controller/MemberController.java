package controller;

import com.nf.entities.Goods;
import com.nf.entities.Member;
import com.nf.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "admin/memberController")
public class MemberController {

    @Autowired
    IMemberService memberService;

    @ResponseBody
    @RequestMapping(value = "/selectAllMembersCount", method = RequestMethod.POST)
    public int selectAllMembersCount(@RequestBody List<Object> mohuListLimit) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("pageno", 0);
        objectMap.put("pagesize", 99999);
        objectMap.put("mstate", mohuListLimit.get(0).toString());
        return memberService.selectAllMember(objectMap).size();
    }

    @ResponseBody
    @RequestMapping(value = "/selectAllMembers", method = RequestMethod.POST)
    public List<Member> selectAllMembers(@RequestBody List<Object> objectList) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("pageno", objectList.get(0));
        objectMap.put("pagesize", objectList.get(1));
        objectMap.put("mstate", objectList.get(2).toString());
        return memberService.selectAllMember(objectMap);
    }

    @ResponseBody
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody List<Object> objectList) {

        Map<String, Object> objectMap = new HashMap<>();

        if (memberService.insert(objectMap) > 1) {
            return "success";
        }
        return "error";
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody List<Object> objectList) {
        Map<String, Object> objectMap = new HashMap<>();
        if (memberService.update(objectMap) > 1) {
            return "success";
        }
        return "error";
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody String mid) {
        if (memberService.delete(mid) > 0) {
            return "success";
        }
        return "error";
    }

}
