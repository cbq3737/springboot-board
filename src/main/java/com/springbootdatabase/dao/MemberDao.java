package com.springbootdatabase.dao;

import com.springbootdatabase.model.MemberModel;
//xml에 맵핑되는곳.
import java.util.List;

public interface MemberDao {
    List<MemberModel> getMember();
    void setMember(MemberModel member);
    void deleteMember(MemberModel member);
    void updateMember(MemberModel member);
}
