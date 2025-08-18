package br.futurodev.joinville.m2s07ex.controller;

import br.futurodev.joinville.m2s07ex.entity.CollectorEntity;
import br.futurodev.joinville.m2s07ex.service.CollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("collectors")
public class CollectorController {

    @Autowired
    private CollectorService service;

    @GetMapping
    public List<CollectorEntity> get() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CollectorEntity post(@RequestBody CollectorEntity collector) {
        return service.save(collector);
    }

}
