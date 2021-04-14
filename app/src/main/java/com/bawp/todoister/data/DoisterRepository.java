package com.bawp.todoister.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.bawp.todoister.model.Task;
import com.bawp.todoister.util.TaskRoomDatabase;

import java.util.List;

public class DoisterRepository {
    private final TaskDao taskDao;
    private  final LiveData<List<Task>> allTask;

    public DoisterRepository(Application application) {
        TaskRoomDatabase database= TaskRoomDatabase.getDatabase(application);
        taskDao = database.taskDao();
        allTask =taskDao.getTask() ;
    }
    public LiveData<List<Task>> getAllTask(){
        return allTask;
    }
    public void insert(Task task){
        TaskRoomDatabase.databaseWriteExecutor.execute(()->{ taskDao.insertTask(task);});
    }
    public void delete(Task task){
        TaskRoomDatabase.databaseWriteExecutor.execute(()->{taskDao.delete(task);});
    }
    public void update(Task task){
        TaskRoomDatabase.databaseWriteExecutor.execute(()->{taskDao.update(task);});

        }
     public LiveData<Task> get(long id){ return taskDao.get(id); }

}
