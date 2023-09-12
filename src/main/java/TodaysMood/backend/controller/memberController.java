package TodaysMood.backend.controller;


import TodaysMood.backend.domain.Member;
import TodaysMood.backend.repository.MemberRepository;
import TodaysMood.backend.repository.MemoryMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class memberController {
    MemberRepository memberRepository = new MemoryMemberRepository();

    // Post로 바꿩
    @ResponseBody
    @PostMapping("/login")
    public int login(@RequestBody Member member){

        int result = memberRepository.login(member.getId(), member.getPassword());
        log.info("result = {}", result);
        return result;
    }

    @ResponseBody
    @PostMapping("/register")
    public String register(@RequestBody Member member){
        log.info("id => {}, password = {}, email = {}, name = {}", member.getId(), member.getPassword(), member.getEmail(), member.getName());
        boolean result = memberRepository.register(member);
        log.info("result = {}", result);
        if(result == true){
            return "가입 성공";
        }
        return "아이디 중복";
    }
}
