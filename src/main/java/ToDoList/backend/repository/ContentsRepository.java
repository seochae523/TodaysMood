package ToDoList.backend.repository;

import ToDoList.backend.domain.TodaysMood;

import java.util.List;
import java.util.Map;


public interface ContentsRepository {

    void saveContents(TodaysMood todaysMood);

    void correnction(TodaysMood todaysMood);

    List<TodaysMood> findAll();
    void delete(String date);

    TodaysMood findOne(String date);
}
