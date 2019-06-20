package com.decta.homework.cardissue.status;

public class RegistrationStatusDTO {
    private RegistrationStatus status;
    private String details;

    public RegistrationStatus getStatus() {
        return status;
    }

    public void setStatus(RegistrationStatus status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
