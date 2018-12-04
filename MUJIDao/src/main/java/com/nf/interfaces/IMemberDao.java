package com.nf.interfaces;

import com.nf.entities.Goods;
import com.nf.entities.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IMemberDao {
    List<Member> selectAllMember(Map<String,Object> objectMap);

    int insert(Map<String,Object> objectMap);

    int update(Map<String,Object> MemberList);

    int delete(@Param("mid") String mid);
}
