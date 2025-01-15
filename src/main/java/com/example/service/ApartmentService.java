package com.example.service;

import com.example.DAO.ApartmentDAO;
import com.example.model.Apartment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ApartmentService {
    private final ApartmentDAO apartmentDAO;

    public ApartmentService() {
        this.apartmentDAO = new ApartmentDAO();
    }

    public void insertApartment(Apartment apartment) {
        if (apartment == null || apartment.getId() == null || apartment.getId().isEmpty()) {
            throw new IllegalArgumentException("Apartment or ID cannot be null/empty.");
        }
        apartmentDAO.addApartment(apartment);
    }

    public List<Apartment> getApartments() {
        List<Apartment> apartments = apartmentDAO.findApartments();
        if (apartments != null && !apartments.isEmpty()) {
            Collections.sort(apartments, Comparator.comparingInt(Apartment::getArea));
        }
        return apartments;
    }

    public void removeApartment(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Apartment ID cannot be null/empty.");
        }
        apartmentDAO.deleteApartment(id);
    }
}
