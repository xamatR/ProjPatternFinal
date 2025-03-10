package com.example.proj.pathern;
// Chain of Responsibility Pattern: Processes customer complaints by passing them along a chain of handlers (e.g., Chef, then Manager) until one handles it.

public class ManagerComplaintHandler extends ComplaintHandler {
    @Override
    public String handleComplaint(String complaint) {
        if (complaint.toLowerCase().contains("service")) {
            return "Manager: We will improve the service.";
        } else if (next != null) {
            return next.handleComplaint(complaint);
        }
        return "Complaint not handled.";
    }
}
