package ru.itis.fisd.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private Long id;
    private String bludo;
    private Integer table_number;
    private String server_name;

    public Order() {
    }

    public Order(Long id, String bludo, Integer table_number, String server_name) {
        this.id = id;
        this.bludo = bludo;
        this.table_number = table_number;
        this.server_name = server_name;
    }
}
