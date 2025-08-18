package br.futurodev.joinville.m2s07ex.controller;

import br.futurodev.joinville.m2s07ex.entity.RouteEntity;
import br.futurodev.joinville.m2s07ex.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("routes")
public class RouteController {

    @Autowired
    private RouteService service;

    @GetMapping
    public List<RouteEntity> get() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RouteEntity post(@RequestBody RouteEntity route) {
        return service.save(route);
    }

}
