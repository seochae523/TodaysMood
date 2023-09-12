package TodaysMood.backend.repository;

import TodaysMood.backend.domain.Member;

import java.util.List;

public interface MemberRepository {

    boolean register(Member member);
    int login(String id, String password);



    List<Member> findAll();

}
