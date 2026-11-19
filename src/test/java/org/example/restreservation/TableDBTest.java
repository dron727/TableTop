package org.example.restreservation;

import org.example.restreservation.entity.TableDB;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TableDBTest {
    @Test
    public void validValuesCreateTable(){
        TableDB tableDB = new TableDB(1, 4);
        assertEquals(1, tableDB.getNumber());
        assertEquals(4, tableDB.getCapacity());
    }
    @Test
    public void capacityZeroNotAllowed(){
        assertThrows(IllegalArgumentException.class, () -> new TableDB(7, 0));
    }
    @Test
    public void nullNumberIsNotAllowed(){
        assertThrows(IllegalArgumentException.class, () -> new TableDB(null, 4));
    }
}
