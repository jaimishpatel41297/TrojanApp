package com.example.trojans.model;

public enum Priority {
    LOW(0),
    MEDIUM(1),
    HIGH(2);

    private final int priority;

    public static Priority valueOf(int priority) throws Exception {
        for (Priority value : Priority.values()) {
            if(value.getPriority() == priority){
                return value;
            }
        }
        throw new Exception("Priority not valid");
    }

    public int getPriority() {
        return priority;
    }

    Priority(int priority) {
        this.priority = priority;
    }
}
