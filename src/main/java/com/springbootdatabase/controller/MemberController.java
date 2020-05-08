package com.springbootdatabase.controller;

import com.springbootdatabase.model.MemberModel;
import com.springbootdatabase.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @RequestMapping("/list")
    public String list(Model model)
    {
        List<MemberModel> member = memberService.printMember();
        model.addAttribute("memberList",member);
        return "list";
    }

//    @RequestMapping("/list")
//    public List list(Model model)
//    {
//        List<MemberModel> member = memberService.printMember();
//        model.addAttribute("memberList",member);
//        return member;
//    }

    @RequestMapping("/addMember")
    public String addMember(Model model)
    {
        return "addMember";
    }

    @RequestMapping(value="/insert", method= RequestMethod.POST)
    public String insert(HttpServletRequest request) throws UnsupportedEncodingException{
        request.setCharacterEncoding("UTF-8");
        MemberModel member = new MemberModel();
        member.setId(Integer.parseInt(request.getParameter("id")));
        member.setName((String)request.getParameter("name"));
        member.setNickname((String)request.getParameter("nickname"));
        member.setPosition((String)request.getParameter("position"));

        memberService.insertMember(member);
//        ModelAndView result = new ModelAndView("redirect:/list");

        return "redirect:/list";
    }

    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public String delete(HttpServletRequest request) throws UnsupportedEncodingException{

        request.setCharacterEncoding("UTF-8");
        MemberModel member = new MemberModel();//새로운 모델객체를 생성한뒤
        member.setId(Integer.parseInt(request.getParameter("id")));//POST방식으로 넘어온 정보들을 이 새로 생성된 객체안에 넣어주고
        member.setName((String)request.getParameter("name"));
        memberService.deleteMember(member);//그정보를 삭제해줌.->결국 쿼리문을 가르키고 있다.
        return "redirect:/list";
    }

    @RequestMapping("/updateMember")//여긴 jsp에서 받아오는 GET방식
    public String updateMember(Model model,HttpServletRequest request )
    {
        model.addAttribute("id",request.getParameter("id"));//처음 list에서 update되면서 넘겨줄때 id를 넘겨주기 위해서 add를 하여 추가해준다.
        return "updateMember";
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)//jsp에서 사용되는 POST방식
    public String update(HttpServletRequest request) throws UnsupportedEncodingException{

        request.setCharacterEncoding("UTF-8");
        MemberModel member = new MemberModel();
        member.setId(Integer.parseInt(request.getParameter("id")));
        member.setName((String)request.getParameter("name"));
        member.setNickname((String)request.getParameter("nickname"));
        member.setPosition((String)request.getParameter("position"));
        memberService.updateMember(member);

        return "redirect:/list";
    }

}
