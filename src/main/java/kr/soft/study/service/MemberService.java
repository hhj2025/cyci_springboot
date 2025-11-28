package kr.soft.study.service;

import kr.soft.study.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public void testConnection(){
        String message = memberMapper.testConnection();
        log.info("message:{}",message);
    }
}
