package ru.deloom.jpaservice.converters.impl;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import ru.deloom.jpaservice.converters.JsonConverter;

@Service
public class JsonConverterImpl implements JsonConverter{
	private static Gson gson = new Gson();

	@Override
	public String toJson(Object object) {
		return gson.toJson(object);
	}

	@Override
	public <T> T fromJson(String json, Class<T> classOfT) {
		return gson.fromJson(json, classOfT);
	}
}
