package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BmiAjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("got a message");
        String strName = request.getParameter("name");
        String height = request.getParameter("h");
        String weight = request.getParameter("w");
        float h =Float.valueOf(height);
        float w =Float.valueOf(weight);
        float bmi=w/(h*h);
        String msg="";
        if (bmi<18.5){
            msg="您比较瘦";
        } else if (bmi>18.5&&bmi<=23.9){
            msg="您的bmi是正常的";
        }else if (bmi>24&&bmi<=32.5){
            msg="您的身体比较胖";
        }else {
            msg="您的身体肥胖";
        }
        System.out.println("msg"+msg);
        msg="您好："+strName+"先生/女士，您的bmi值是"+bmi+","+msg;
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(msg);
    }
}
