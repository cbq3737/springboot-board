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

    @RequestMapping("/addMember")//GET방식
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
        member.setPassword((String)request.getParameter("password"));
        member.setAge(Integer.parseInt(request.getParameter("age")));

        memberService.insertMember(member);
//        ModelAndView result = new ModelAndView("redirect:/list");
        //굳이 ModelAndView객체를 사용한 이유는 말그대로 Model객체와 view에 넘겨줄 페이지값을 가진 return값을 합친것이다.얘를 사용하면 실행할 페이지이름을 지정해주거나 생성시 페이지의 이름 생성가능
        return "redirect:/list"; //controller에서 할꺼 다 하고 view에 던져줄것.
    }

    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public String delete(HttpServletRequest request) throws UnsupportedEncodingException{

        request.setCharacterEncoding("UTF-8");
        MemberModel member = new MemberModel();//새로운 모델객체를 생성한뒤
        member.setId(Integer.parseInt(request.getParameter("id")));//POST방식으로 넘어온 정보들을 이 새로 생성된 객체안에 넣어주고
        member.setPassword((String)request.getParameter("password"));
        memberService.deleteMember(member);//그정보를 삭제해줌.->결국 쿼리문을 가르키고 있다.
        return "redirect:/list";
    }

    @RequestMapping("/updateMember")//여긴 jsp에서 받아오는 GET방식
    public String updateMember(Model model,HttpServletRequest request )
    {
        model.addAttribute("id",request.getParameter("id"));//처음 list에서 update되면서 넘겨줄때 id를 넘겨주기 위해서 add를 하여 추가해준다.jsp는 model을 사용하기 때문에
        return "updateMember";
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)//jsp에서 사용되는 POST방식
    public String update(HttpServletRequest request) throws UnsupportedEncodingException{

        request.setCharacterEncoding("UTF-8");
        MemberModel member = new MemberModel();
        member.setId(Integer.parseInt(request.getParameter("id")));
        member.setName((String)request.getParameter("name"));
        member.setPassword((String)request.getParameter("password"));
        member.setAge(Integer.parseInt(request.getParameter("age")));
        memberService.updateMember(member);

        return "redirect:/list";
    }

    @RequestMapping("/loginMember")
    public String loginMember(Model model,HttpServletRequest request )
    {
        return "loginMember";
    }

    @RequestMapping(value="/login" , method=RequestMethod.POST)
    public String login(HttpServletRequest request) throws  UnsupportedEncodingException
    {
        request.setCharacterEncoding("UTF-8");
        MemberModel member = new MemberModel();
        request.getSession().setAttribute("id",request.getParameter("id"));//id를 잠시 보관해두기 위한 단계
        member.setId(Integer.parseInt(request.getParameter("id")));
        member.setPassword((String)request.getParameter("password"));
        boolean result = memberService.loginMember(member);
        if(result)
        {
            return "redirect:/memberdetail";//로그인 성공
        }
        return "redirect:/list"; //로그인 실패
    }

    @RequestMapping("/memberdetail")
    public String memberdetail(Model model,HttpServletRequest request ) throws  UnsupportedEncodingException
    {
        request.setCharacterEncoding("UTF-8");

        String ID = (String)request.getSession().getAttribute("id");//아까 저장해놨던 id를 뽑음
        MemberModel member = new MemberModel();
        member.setId(Integer.parseInt(ID));//뽑은 아이디를 member객체에 넣고
        MemberModel model1 = memberService.findMember(member);//그정보를 토대로 id에 해당하는 member의 정보를 뽑음.

        model.addAttribute("memberList",model1);

        return "memberdetail";
    }

    @RequestMapping(value="/checkId",method=RequestMethod.POST)
    public String checkId(HttpServletRequest request) throws UnsupportedEncodingException{
        request.setCharacterEncoding("UTF-8");
        MemberModel member = new MemberModel();
        member.setId(Integer.parseInt(request.getParameter("id")));
        boolean result = memberService.checkId(member);
        if(result)
        {
            System.out.println("중복 안됨");
            return "redirect:/list"; //중복 안된경우
        }
        else
        {
            System.out.println("중복임");
            return "redirect:/list"; //중복인경우
        }

    }
}
