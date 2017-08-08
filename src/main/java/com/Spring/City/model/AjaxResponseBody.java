package com.Spring.City.model;

import com.Spring.City.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

public class AjaxResponseBody {
    @JsonView(Views.Public.class)
    private String message;

    @JsonView(Views.Public.class)
    private String code;

    @JsonView(Views.Public.class)
    private List<CityDistance> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<CityDistance> getResult() {
        return result;
    }

    public void setResult(List<CityDistance> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "AjaxResponseBody{" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                ", result=" + result +
                '}';
    }
}
