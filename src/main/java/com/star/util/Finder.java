package com.star.util;


import io.ebean.Ebean;
import io.ebean.ExpressionList;

public class Finder<T extends Object> {


	public Class clazz;

	public Finder(Class<T> clazz) {
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
	public T byId(Long id) {
		return (T) Ebean.find(clazz).where().eq("id", id).eq("deleted", 0).findOne();
	}
	@SuppressWarnings("unchecked")
	public T byId(String id) {
		return (T) Ebean.find(clazz).where().eq("id", id).eq("deleted", 0).findOne();
	}

	@SuppressWarnings("unchecked")
	public ExpressionList<T> where() {
		return Ebean.find(clazz).where();
	}

}
