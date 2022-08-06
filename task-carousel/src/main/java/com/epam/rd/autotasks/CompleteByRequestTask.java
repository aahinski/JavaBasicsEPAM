package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {

    private boolean isCompleted;
    private boolean isExecuted;

    public CompleteByRequestTask() {
        isExecuted = false;
        isCompleted = false;
    }

    @Override
    public void execute() {
        if(isCompleted)
            isExecuted = true;
    }

    @Override
    public boolean isFinished() {
        if(isCompleted && isExecuted)
            return true;
        else
            return false;
    }

    public void complete() {
        isCompleted = true;
    }
}
