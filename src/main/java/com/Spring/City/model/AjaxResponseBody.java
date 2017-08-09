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

    @JsonView(Views.Public.class)
    private SearchCriteria resultCriteria;

    @JsonView(Views.Public.class)
    private CalcCriteria calcCriteria;

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

    public SearchCriteria getResultCriteria() {
        return resultCriteria;
    }

    public void setResultCriteria(SearchCriteria resultCriteria) {
        this.resultCriteria = resultCriteria;
    }

    public CalcCriteria getCalcCriteria() {
        return calcCriteria;
    }

    public void setCalcCriteria(CalcCriteria calcCriteria) {
        this.calcCriteria = calcCriteria;
    }

    @Override
    public String toString() {
        return "AjaxResponseBody{" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                ", result=" + result +
                ", resultCriteria=" + resultCriteria +
                ", calcCriteria=" + calcCriteria +
                '}';
    }
}
