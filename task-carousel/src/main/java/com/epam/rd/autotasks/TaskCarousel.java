package com.epam.rd.autotasks;

import java.util.ArrayList;
import java.util.List;

public class TaskCarousel {

    private List<Task> tasks;
    private int capacity;
    private int taskToExecute;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        taskToExecute = 0;
        tasks = new ArrayList<>();
    }

    public boolean addTask(Task task) {
        if(task != null && !task.isFinished() && !this.isFull()) {
            tasks.add(task);
            return true;
        }
        else
            return false;
    }

    public boolean execute() {
        if(!this.isEmpty()) {
            Task tmp = tasks.get(taskToExecute);
            tmp.execute();
            if(tmp.isFinished()) {
                tasks.remove(taskToExecute);
                if(tasks.size() != 0)
                    taskToExecute = (taskToExecute + 1) % tasks.size();
            }
            else
                taskToExecute = (taskToExecute + 1) % tasks.size();
            return true;
        }
        else
            return false;
    }

    public boolean isFull() {
        if(tasks.size() == capacity)
            return true;
        else
            return false;
    }

    public boolean isEmpty() {
        if(tasks.isEmpty())
            return true;
        else
            return false;
    }

}
