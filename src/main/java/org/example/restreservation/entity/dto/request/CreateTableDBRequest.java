package org.example.restreservation.entity.dto.request;

import org.example.restreservation.entity.TableDB;

public record CreateTableDBRequest(Integer number, Integer capacity) {

    public TableDB toEntity(){
        return new TableDB(number, capacity);
    }
}


