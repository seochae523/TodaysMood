package TodaysMood.backend.repository;

import TodaysMood.backend.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    Map<String, Member> store = new HashMap<>();


    @Override
    public boolean register(Member member) {
        Set<String> keySet = store.keySet();
        for(String key : keySet){
            if(key.equals(member.getId())){
                return false;
            }
        }
        store.put(member.getId(), member);
        return true;
    }

    @Override
    public int login(String id, String password) {
        Set<String> keySet = store.keySet();
        for (String key : keySet) {
            if(key.equals(id)){
                if(store.get(key).getPassword().equals(password)){
                    return 1;
                }
                else{
                    return 2;
                }
            }
        }
        return 3;
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList(store.values());
    }
}
