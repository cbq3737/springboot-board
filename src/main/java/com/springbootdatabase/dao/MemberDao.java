package com.springbootdatabase.dao;

import com.springbootdatabase.model.MemberModel;
//xml에 맵핑되는곳.여기가 mapping한다는것도 config에서 설정해줘야함.
import java.util.List;

public interface MemberDao {
    List<MemberModel> getMember();
    void setMember(MemberModel member);
    void deleteMember(MemberModel member);
    void updateMember(MemberModel member);
    int loginMember(MemberModel member);
    MemberModel findMember(MemberModel member);
    int checkId(MemberModel member);
}
