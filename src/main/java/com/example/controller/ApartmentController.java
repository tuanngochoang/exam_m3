package com.example.controller;

import com.example.model.Apartment;
import com.example.service.ApartmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "apartmentController", urlPatterns = {"/apartments/list", "/apartments", "/apartments/add", "/apartments/remove"})
public class ApartmentController extends HttpServlet {
    private ApartmentService apartmentService;
    public void init() {
        apartmentService = new ApartmentService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        switch (action) {
            case "/apartments/list":
                req.setAttribute("apartments", apartmentService.getApartments());
                req.getRequestDispatcher("/WEB-INF/view/apartment/list.jsp").forward(req, resp);
                break;
            case "/apartments/add":
                req.getRequestDispatcher("/WEB-INF/view/apartment/add.jsp").forward(req, resp);
                break;
            case "/apartments/remove":
                String id = req.getParameter("id");
                apartmentService.removeApartment(id);
                req.setAttribute("message", "Căn hộ đã được xóa thành công!");
                req.setAttribute("apartments", apartmentService.getApartments());
                req.getRequestDispatcher("/WEB-INF/view/apartment/list.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        switch (action) {
            case "/apartments/add":
                String id = req.getParameter("id");
                Integer area = Integer.parseInt(req.getParameter("area"));
                String status = req.getParameter("status");
                int floor = Integer.parseInt(req.getParameter("floor"));
                String type = req.getParameter("type");
                String description = req.getParameter("description");
                int price = Integer.parseInt(req.getParameter("price"));
                String startDay = req.getParameter("startDay");
                String endDay = req.getParameter("endDay");

                Apartment newApartment = new Apartment(id, area, status, floor, type, description, price, startDay, endDay);

                try {
                    apartmentService.insertApartment(newApartment);
                    req.setAttribute("successMessage", "Thêm căn hộ thành công.");
                    req.getRequestDispatcher("/WEB-INF/view/apartment/add.jsp").forward(req, resp);
                } catch (Exception e) {
                    req.setAttribute("errorMessage", "Có lỗi xảy ra khi thêm căn hộ.");
                    req.getRequestDispatcher("/WEB-INF/view/apartment/add.jsp").forward(req, resp);
                }
                break;
        }
    }
}
