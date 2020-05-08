package com.springbootdatabase.service;

import com.springbootdatabase.model.MemberModel;

import java.util.List;

public interface MemberService {
    List<MemberModel> printMember();
    void insertMember(MemberModel member);
    void deleteMember(MemberModel member);
    void updateMember(MemberModel member);
    boolean loginMember(MemberModel member);
    MemberModel findMember(MemberModel member);
    boolean checkId(MemberModel member);
}
