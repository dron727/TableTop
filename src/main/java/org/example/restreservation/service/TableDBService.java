package org.example.restreservation.service;

import jakarta.transaction.Transactional;
import org.example.restreservation.entity.TableDB;
import org.example.restreservation.entity.dto.TableDBConteinerDto;
import org.example.restreservation.entity.dto.TableDBDto;
import org.example.restreservation.entity.dto.request.CreateTableDBRequest;
import org.example.restreservation.entity.dto.request.UpdateTableDBRequest;
import org.example.restreservation.repository.TableDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class TableDBService {
    private final TableDBRepository tableDBRepository;

    @Autowired
    public TableDBService(TableDBRepository tableDBRepository) {
        this.tableDBRepository = tableDBRepository;
    }

    public TableDBConteinerDto findAll(){
        List<TableDBDto> tableDBs = tableDBRepository.findAll().stream()
                .map(TableDB::toDto)
                .collect(Collectors.toList());
        return new TableDBConteinerDto(tableDBs);
    }

    public TableDBDto findById(Long id){
        return tableDBRepository.findById(id)
                .map(TableDB::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Нет id"));
    }

    public TableDBDto save(CreateTableDBRequest request){
        TableDB tableDB = request.toEntity();
        return tableDBRepository.save(tableDB).toDto();
    }

    public TableDBDto update(Long id, UpdateTableDBRequest request){
        return tableDBRepository.findById(id)
                .map(existingTableDB -> {
                    TableDB updateTableDB = request.toEntity(existingTableDB.getId());
                    return tableDBRepository.save(updateTableDB);
                })
                .orElseThrow(() -> new IllegalArgumentException("Не нашли по id")).toDto();
    }

    public void delete(Long id){
        tableDBRepository.deleteById(id);
    }
}
