package kr.soft.study.api;

import jakarta.servlet.http.HttpServletRequest;
import kr.soft.study.dto.BoardDTO;
import kr.soft.study.dto.MemberDTO;
import kr.soft.study.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public void print(){
        System.out.println("hello");

        log.info("hello");

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserId("userID");

        memberDTO.setUserPw("userPw");

        log.info("data : {}", memberDTO.toString());

        BoardDTO boardDTO = new BoardDTO(5, "title", "content");

        log.info("data : {}", boardDTO.toString());

        BoardDTO boardDTO1 = BoardDTO.builder().idx(5).title("title").content("content").build();

        log.info("data : {}", boardDTO1.toString());


    }

    @GetMapping("/data")
    public String data(){
        return "data";
    }

    @GetMapping("/member")
    public MemberDTO member(){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserId("Ironman");
        memberDTO.setUserPw("1234");

        return memberDTO;
    }

    @GetMapping("/idCheck")
    public MemberDTO idCheck(HttpServletRequest request){
        String id = request.getParameter("userId");

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserId(id);
//        memberDTO.setUserPw("1234");

        return memberDTO;
    }

    @PostMapping("/join")
    public MemberDTO join(@RequestBody MemberDTO memberDTO){
        System.out.println(memberDTO.toString());


        return memberDTO;

    }

    @GetMapping("/test")
    public void test(){
        memberService.testConnection();
    }
}
