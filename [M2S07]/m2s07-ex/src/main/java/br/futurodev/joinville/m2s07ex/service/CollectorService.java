package br.futurodev.joinville.m2s07ex.service;

import br.futurodev.joinville.m2s07ex.entity.CollectorEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectorService {

    public List<CollectorEntity> findAll() {
        return CollectorEntity.getCollectors();
    }

    public CollectorEntity save(CollectorEntity collector) {
        return CollectorEntity.save(collector);
    }

}
