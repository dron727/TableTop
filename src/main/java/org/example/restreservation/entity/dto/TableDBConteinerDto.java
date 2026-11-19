package org.example.restreservation.entity.dto;

import java.util.List;

public class TableDBConteinerDto {
    private final List<TableDBDto> tableDBDTOList;

    public TableDBConteinerDto(List<TableDBDto> tableDBDTOList){
        this.tableDBDTOList = tableDBDTOList;
    }

    public List<TableDBDto> getTableDBDTOList(){
        return tableDBDTOList;
    }
}
