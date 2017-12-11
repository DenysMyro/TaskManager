package com.company;

public class Task {

    String taskTitle;
    int taskTime;
    int taskStartTime;
    int taskEndTime;
    int taskTimeInterval;
    boolean isRepeatable;
    boolean isActive;

	/*Constructors*/

    public Task(String title, int time, boolean active) {
        if (time < 0) {
            throw new NegativeTimeValueException(title);
        }//throwing unchecked exception for negative values

        this.taskTitle = title;
        this.taskTime = time;
        isActive = active;
        isRepeatable = false;

    }

    public Task(String title, int start, int end, int interval, boolean active) {

        if (start < 0 || end < 0 || interval < 0) {
            throw new NegativeTimeValueException();
        } //throwing unchecked exception for negative values

        this.taskTitle = title;
        this.taskStartTime = start;
        this.taskEndTime = end;
        this.taskTimeInterval = interval;
        isActive = active;
        isRepeatable = true;
    }

	/*Getters&Setters*/

    public String getTitle() {
        return taskTitle;
    }

    public void setTitle(String title) {
        this.taskTitle = title;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean state) {
        this.isActive = state;
    }

    public int getTime() {
        if (isRepeatable) {
            return taskStartTime;
        } else {
            return taskTime;
        }
    }

    public void setTime(int time) {
        if (time < 0) {
            throw new NegativeTimeValueException(this.getTitle());
        }//throwing unchecked exception for negative values

        taskTime = time;
        isRepeatable = false;
    }

    public int getStartTime() {
        if (isRepeatable) {
            return taskStartTime;
        } else {
            return taskTime;
        }
    }

    public int getEndTime() {
        if (isRepeatable) {
            return taskEndTime;
        } else {
            return taskTime;
        }
    }

    public int getRepeatInterval() {
        if (isRepeatable) {
            return taskTimeInterval;
        } else {
            return 0;
        }
    }


    public void setTime(int start, int end, int interval) {
        if (start < 0 || end < 0 || interval < 0) {
            throw new NegativeTimeValueException(this.getTitle());
        }//throwing unchecked exception for negative values

        taskStartTime = start;
        taskEndTime = end;
        taskTimeInterval = interval;
        isRepeatable = true;

    }

    public boolean isRepeated() {
        return isRepeatable;
    }

    public int nextTimeAfter(int current) {
        if (isRepeatable) {
            if (current < taskStartTime) {
                return taskStartTime;
            } else {
                if (current >= taskStartTime && current <= taskEndTime) {
                    int time = taskStartTime;
                    while (current >= time) {
                        time += taskTimeInterval;
                        if (time > taskEndTime)
                            return -1;
                    }
                    return time;
                } else {
                    return -1;
                }
            }
        } else {
            if (isActive && current < taskTime) {
                return taskTime;
            } else {
                return -1;
            }
        }
    }

    @Override
    public String toString() {
        return taskTitle;
    }
}

