package com.kaufland.vmdb.service;


import com.kaufland.vmdb.domain.Human;
import com.kaufland.vmdb.dto.HumanModel;

import java.util.List;
import java.util.stream.Collectors;

public interface HumanService<T extends Human> {
    List<T> findAll();

    default List<HumanModel> findAllDTO(){
        return findAll().stream().map(HumanModel::new).collect(Collectors.toList()) ;
    }

    List<T> findByNameIn(List<String> names);
}
