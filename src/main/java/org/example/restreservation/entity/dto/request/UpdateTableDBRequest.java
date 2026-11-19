package org.example.restreservation.entity.dto.request;

import org.example.restreservation.entity.TableDB;


public class UpdateTableDBRequest {

    Integer number;
    Integer capacity;

    public UpdateTableDBRequest(Integer number, Integer capacity) {
        this.number = number;
        this.capacity = capacity;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public TableDB toEntity(Long id){
        return new TableDB(id, number, capacity);
    }
}
