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
}
