package com.serfinsa.pruebatecnica.services.contract;

import java.util.List;

public interface CommonOperation<T>{

    public T save(T entity);

    public T update(T entity);

    public void delete(T entity);

    public T findById(int id);

    public List<T> findAll();


}
