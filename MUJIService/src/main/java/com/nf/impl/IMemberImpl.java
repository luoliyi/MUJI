package com.nf.impl;

import com.nf.entities.Member;
import com.nf.interfaces.IMemberDao;
import com.nf.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Repository
@Service
public class IMemberImpl implements IMemberService {

    @Autowired
    IMemberDao memberDao;


    @Override
    public List<Member> selectAllMember(Map<String, Object> objectMap) {
        return memberDao.selectAllMember(objectMap);
    }

    @Override
    public int insert(Map<String, Object> objectMap) {
        return memberDao.insert(objectMap);
    }

    @Override
    public int update(Map<String, Object> objectMap) {
        return memberDao.update(objectMap);
    }

    @Override
    public int delete(String mid) {
        return memberDao.delete(mid);
    }

    @Override
    public Member selectOne(Map<String, Object> objectMap) {
        return memberDao.selectOne(objectMap);
    }

    @Override
    public int regsister(Map<String, Object> objectMap) {
        return memberDao.regsister(objectMap);
    }
}
