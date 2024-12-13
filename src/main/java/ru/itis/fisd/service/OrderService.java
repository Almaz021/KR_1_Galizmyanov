package ru.itis.fisd.service;

import ru.itis.fisd.model.Order;
import ru.itis.fisd.repository.OrderRepository;

import java.util.List;

public class OrderService {
    private final OrderRepository repository;

    public OrderService() {
        repository = new OrderRepository();
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        return repository.findById(id);
    }
}
