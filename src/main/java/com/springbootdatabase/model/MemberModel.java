package com.springbootdatabase.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberModel {
    private int id;
    private String name;
    private String nickname;
    private String position;


    public void setId(int id)
    {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setNickname(String nickname)
    {
        this.nickname=nickname;
    }
    public void setPosition(String position)
    {
        this.position=position;
    }
}


