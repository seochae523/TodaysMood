package ToDoList.backend.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodaysMood {
    private String date;
    private String context;
    private String color;
    private int mood;
}
