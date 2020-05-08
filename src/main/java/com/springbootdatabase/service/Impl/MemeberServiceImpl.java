package com.springbootdatabase.service.Impl;

import com.springbootdatabase.dao.MemberDao;
import com.springbootdatabase.model.MemberModel;
import com.springbootdatabase.service.MemberService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemeberServiceImpl implements MemberService {
    @Autowired
    private MemberDao dao;


    @Override
    public List<MemberModel> printMember() {
        List<MemberModel> member = dao.getMember();
        return member;
    }

    @Override
    public void insertMember(MemberModel member)
    {
        dao.setMember(member);
    }
    @Override
    public void deleteMember(MemberModel member)
    {
        dao.deleteMember(member);
    }
    @Override
    public void updateMember(MemberModel member)
    {
        dao.updateMember(member);
    }

    @Override
    public boolean loginMember(MemberModel member)
    {
        int result = dao.loginMember(member);

        if(result>0)//id와 name에 맞는게 하나이상이라도 있다면 성공
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    @Override
    public MemberModel findMember(MemberModel member)
    {
        MemberModel model1 = dao.findMember(member);
        return model1;
    }

    public boolean checkId(MemberModel member)
    {
        int result =dao.checkId(member);
        if(result>0)//id가 1개이상이라면
        {
            return false; //중복임
        }
        else
        {
            return true;    //중복아님
        }
    }
}
