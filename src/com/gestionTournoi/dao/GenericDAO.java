package com.gestionTournoi.dao;

import java.util.List;

public interface GenericDAO<T> {
	public void insert(T Object);
	public List<T> getAll();
}
