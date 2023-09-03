package TodaysMood.backend.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodaysMood {
    private String date;
    private String title;
    private String context;
    private String color;
    private int mood;

}
