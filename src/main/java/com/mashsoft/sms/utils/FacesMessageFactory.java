package com.mashsoft.sms.utils;

import javax.faces.application.FacesMessage;

public class FacesMessageFactory {

    private static FacesMessage facesMessage = new FacesMessage();

    public static FacesMessage infoMessage(String summary, String detail) {
        facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
        facesMessage.setSummary(summary);
        facesMessage.setDetail(detail);
        return facesMessage;
    }

    public static FacesMessage saveSuccessfull() {
        facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
        facesMessage.setSummary("Saved...");
        facesMessage.setDetail("Save successfull.");
        return facesMessage;
    }

    public static FacesMessage saveError() {
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesMessage.setSummary("Error...");
        facesMessage.setDetail("An error occured while trying to save the entity.");
        return facesMessage;
    }

    public static FacesMessage missingInputName() {
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        facesMessage.setSummary("Name required");
        facesMessage.setDetail("Please, provide a valid name.");
        return facesMessage;
    }

    public static FacesMessage onObjectCreation(Object object) {
        facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
        facesMessage.setSummary("Success");
        facesMessage.setDetail(object.getClass().getSimpleName() + " created...");
        return facesMessage;
    }

}
