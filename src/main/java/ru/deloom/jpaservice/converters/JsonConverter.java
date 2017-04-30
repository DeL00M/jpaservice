package ru.deloom.jpaservice.converters;

public interface JsonConverter {
	String toJson(Object object);
	public <T> T fromJson(String json, Class<T> classOfT);
}
