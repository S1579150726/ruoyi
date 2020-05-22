package com.ruoyi.web.controller.tool.msg;

public class ObjectConResponse<T> extends BaseResponse {

    T data;
    boolean rel;

    public boolean isRel() {
        return rel;
    }

    public void setRel(boolean rel) {
        this.rel = rel;
    }


    public ObjectConResponse rel(boolean rel) {
        this.setRel(rel);
        return this;
    }


    public ObjectConResponse data(T data) {
        this.setData(data);
        return this;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ObjectConResponse() {
        super();
    }

    public ObjectConResponse(boolean rel, String message) {
        super(200, message);
        this.rel=rel;
    }

}
