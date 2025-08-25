package br.futurodev.jmt.m2s08.service;

import br.futurodev.jmt.m2s08.entity.CityEntity;

import java.util.List;

public interface CityService {

    List<CityEntity> findAll(String name, String estadoSigla);
    CityEntity save(CityEntity cityEntity);

}
