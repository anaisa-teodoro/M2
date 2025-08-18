package br.futurodev.joinville.m2s07ex.service;

import br.futurodev.joinville.m2s07ex.entity.RouteEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    public List<RouteEntity> findAll() {
        return RouteEntity.getRoutes();
    }

    public RouteEntity save(RouteEntity route) {
        return RouteEntity.save(route);
    }

}
