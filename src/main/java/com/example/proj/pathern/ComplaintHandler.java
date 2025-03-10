package com.example.proj.pathern;
// Chain of Responsibility Pattern: Processes customer complaints by passing them along a chain of handlers (e.g., Chef, then Manager) until one handles it.

public abstract class ComplaintHandler {
    protected ComplaintHandler next;

    public void setNext(ComplaintHandler next) {
        this.next = next;
    }

    public abstract String handleComplaint(String complaint);
}
