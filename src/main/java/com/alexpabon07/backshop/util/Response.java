package com.alexpabon07.backshop.util;

public class Response {

    private Object responseBody;
    private String responseMessage;
    private int responseCode;
    private boolean responseStatus;

    public Response() {
        responseCode = 200;
        responseStatus = true;
    }

    public Object getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(Object responseBody) {
        this.responseBody = responseBody;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public boolean getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(boolean status) {
        this.responseStatus = status;
    }

    public Response buildResponse(Object responseBody, String responseMessage, int responseCode, boolean responseStatus) {
        Response response = new Response();

        response.setResponseBody(responseBody);
        response.setResponseCode(responseCode);
        response.setResponseMessage(responseMessage);
        response.setResponseStatus(responseStatus);

        return response;
    }
}
