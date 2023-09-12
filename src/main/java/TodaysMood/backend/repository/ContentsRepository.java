package TodaysMood.backend.repository;

import TodaysMood.backend.domain.TodaysMood;

import java.util.List;


public interface ContentsRepository {

    void saveContents(TodaysMood todaysMood);

    void correnction(TodaysMood todaysMood);

    List<TodaysMood> findAll(String name);
    void delete(String date);

    TodaysMood findOne(String date);

    double calculateTotalMood();
}
