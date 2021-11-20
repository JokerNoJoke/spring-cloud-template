package org.joker.service.template.core;

public class ResponseBodyEntity {

    private static final int FAILURE_STATUS = 0;
    private static final String FAILURE_MESSAGE = "failure";
    private static final int SUCCESS_STATUS = 1;
    private static final String SUCCESS_MESSAGE = "success";

    private int status;
    private String message;
    private Object body;

    public int getStatus() {
        return status;
    }

    public ResponseBodyEntity setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseBodyEntity setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getBody() {
        return body;
    }

    public ResponseBodyEntity setBody(Object body) {
        this.body = body;
        return this;
    }

    public static ResponseBodyEntity failure() {
        return new ResponseBodyEntity().setStatus(FAILURE_STATUS).setMessage(FAILURE_MESSAGE);
    }

    public static ResponseBodyEntity success() {
        return new ResponseBodyEntity().setStatus(SUCCESS_STATUS).setMessage(SUCCESS_MESSAGE);
    }

}
