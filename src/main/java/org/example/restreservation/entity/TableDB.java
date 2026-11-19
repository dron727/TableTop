package org.example.restreservation.entity;

import jakarta.persistence.*;
import org.example.restreservation.entity.dto.TableDBDto;


@Entity
@Table(name = "restaurant_tables")
public class TableDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    public TableDB(Long id, Integer number, Integer capacity){
        this.id = id;
        this.number = number;
        this.capacity = capacity;
    }

    public TableDB(Integer number, Integer capacity){
        if(number == null || number < 1){
            throw new IllegalArgumentException("Номер не может быть null!");
        }
        if(capacity == null || capacity > 5 || capacity < 1){
            throw new IllegalArgumentException("Вместимость от 1 до 5 мест!");
        }
        this.number = number;
        this.capacity = capacity;
    }

    protected TableDB(){

    }

    public Long getId(){
        return id;
    }

    public Integer getNumber(){
        return number;
    }

    public Integer getCapacity(){
        return capacity;
    }

    public TableDBDto toDto(){
        return new TableDBDto(number, capacity);
    }
}
