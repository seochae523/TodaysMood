package TodaysMood.backend.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private String id;
    private String password;
    private String email;
    private String name;
}
