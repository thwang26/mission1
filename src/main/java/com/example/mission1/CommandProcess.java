package com.example.mission1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandProcess {
    public String request(HttpServletRequest request, HttpServletResponse response) throws Throwable;
}