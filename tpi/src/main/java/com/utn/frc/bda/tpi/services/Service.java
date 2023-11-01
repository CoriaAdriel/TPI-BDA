package com.utn.frc.bda.tpi.services;

import java.util.List;

public interface Service<T, ID>
{
    // CRUD COMPLETO DE CADA ENTIDAD
    List<T> getAll();
    T getById(ID id);
    T add(T entity);
    T delete(ID id);
    T update(T entity);
}
