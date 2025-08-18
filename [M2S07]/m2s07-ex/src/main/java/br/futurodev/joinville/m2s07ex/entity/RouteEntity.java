package br.futurodev.joinville.m2s07ex.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RouteEntity {

    private static final List<RouteEntity> ROUTES =  new ArrayList<>();

    private static Long nextId = 1L;

    @Setter(AccessLevel.PRIVATE) private Long id;
    private String description;
    private String coverageArea;
    private BigDecimal pcEfficiency;

    public RouteEntity() {
        id = getNextId();
    }

    private static Long getNextId() {
        return nextId++;
    }

    public static List<RouteEntity> getRoutes() {
        return ROUTES;
    }

    public static RouteEntity save(RouteEntity route) {
        ROUTES.add(route);
        return route;
    }
}
