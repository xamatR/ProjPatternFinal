package com.example.proj.pathern;
// Chain of Responsibility Pattern: Processes customer complaints by passing them along a chain of handlers (e.g., Chef, then Manager) until one handles it.

import java.util.Locale;

public class ChefComplaintHandler extends ComplaintHandler {
    @Override
    public String handleComplaint(String complaint) {
        if (complaint.toLowerCase().contains("spicy")) {
            return "Chef: I will adjust the spice level.";
        } else if (next != null) {
            return next.handleComplaint(complaint);
        }
        return "Complaint not handled.";
    }
}
