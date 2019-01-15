package com.nf.interfaces;

import com.nf.entities.Administrator;
import com.nf.entities.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IAdministratorDao {
    List<Administrator> selectAllAdministrator(Map<String, Object> objectMap);

    int insert(Map<String, Object> objectMap);

    int update(Map<String, Object> MemberList);

    int delete(@Param("aid") String aid);

    Administrator selectOneAdministrator(@Param("aid") String aid);

    Administrator selectOne(Map<String, Object> objectMap);
}
