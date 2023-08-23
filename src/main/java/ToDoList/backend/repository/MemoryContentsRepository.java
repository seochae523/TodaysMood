package ToDoList.backend.repository;

import ToDoList.backend.domain.TodaysMood;
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
    public List<TodaysMood> findAll(){
        return new ArrayList<>(store.values());
    }
    @Override
    public void delete(String date) {

        store.remove(date);
    }

    @Override
    public TodaysMood findOne(String date){
        return store.get(date);
    }
}
