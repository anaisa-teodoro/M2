package br.futurodev.joinville.m2s07ex.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CollectorEntity {

    private static final List<CollectorEntity> COLLECTORS =  new ArrayList<>();

    private static Long nextId = 1L;

    @Setter(AccessLevel.PRIVATE) private Long id;
    private String name;
    private String description;

    public CollectorEntity() {
        id = getNextId();
    }

    private static Long getNextId() {
        return nextId++;
    }

    public static List<CollectorEntity> getCollectors() {
        return COLLECTORS;
    }

    public static CollectorEntity save(CollectorEntity collector) {
        COLLECTORS.add(collector);
        return collector;
    }
}
