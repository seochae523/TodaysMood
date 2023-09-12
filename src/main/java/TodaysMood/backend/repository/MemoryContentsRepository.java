package TodaysMood.backend.repository;

import TodaysMood.backend.domain.TodaysMood;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class MemoryContentsRepository implements ContentsRepository{
    Map<String, TodaysMood> store= new HashMap<>();




    @Override
    public void saveContents(TodaysMood todaysMood) {

        store.put(todaysMood.getDate(), todaysMood);
    }

    @Override
    public void correnction(TodaysMood todaysMood) {
        store.replace(todaysMood.getDate(), todaysMood);
    }

    @Override
    public List<TodaysMood> findAll(String name){
        List<TodaysMood> moodList = new ArrayList<>();
        for (TodaysMood value : store.values()) {
            if(value.getAuthor() == name){
                moodList.add(value);
            }
        }

        return moodList;
    }
    @Override
    public void delete(String date) {

        store.remove(date);
    }

    @Override
    public TodaysMood findOne(String date){
        return store.get(date);
    }

    @Override
    public double calculateTotalMood() {
        if(store.size()==0){
            return -1;
        }
        double moods = 0;
        for(String key : store.keySet()){
            moods += store.get(key).getMood();
        }

        return moods / store.size();
    }
}
