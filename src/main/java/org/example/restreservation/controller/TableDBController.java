package org.example.restreservation.controller;

import org.example.restreservation.entity.dto.TableDBConteinerDto;
import org.example.restreservation.entity.dto.TableDBDto;
import org.example.restreservation.entity.dto.request.CreateTableDBRequest;
import org.example.restreservation.entity.dto.request.UpdateTableDBRequest;
import org.example.restreservation.service.TableDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/tabledb")
public class TableDBController {
    private final TableDBService tableDBService;

    @Autowired
    public TableDBController(TableDBService tableDBService){
        this.tableDBService = tableDBService;
    }

    @PostMapping("/add")
    public TableDBDto save(@RequestBody CreateTableDBRequest request){
        return tableDBService.save(request);
    }

    @GetMapping("/get")
    public TableDBConteinerDto findAll(){
        return tableDBService.findAll();
    }

    @GetMapping("/get/{id}")
    public TableDBDto findById(@PathVariable Long id){
        return tableDBService.findById(id);
    }

    @PutMapping("/update/{id}")
    public TableDBDto update(@PathVariable Long id, @RequestBody UpdateTableDBRequest request){
        return tableDBService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        tableDBService.delete(id);
    }
}
