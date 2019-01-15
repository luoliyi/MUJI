package com.nf.service;

import com.nf.entities.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IMemberService {
    List<Member> selectAllMember(Map<String, Object> objectMap);

    int insert(Map<String, Object> objectMap);

    int update(Map<String, Object> objectMap);

    int delete(@Param("mid") String mid);

    Member selectOne(Map<String, Object> objectMap);

    int regsister(Map<String, Object> objectMap);
}
