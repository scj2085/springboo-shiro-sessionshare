package com.gome.meidian.sessionshare.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * json-util
 * @author shichangjian
 *
 */
public abstract class JSONUtils {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final static ObjectMapper MAPPER = new ObjectMapper();

	static {
		MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	}

	/**
	 *
	 * @param obj
	 * @return
	 */
	public static String toJSONString(Object obj) {
		try {
			return MAPPER.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 *
	 * @param content
	 * @param typeReference
	 * @param <T>
	 * @return
	 */
	public static <T> T convertValue(String content, TypeReference<?> typeReference) {
		try {
			return MAPPER.readValue(content, typeReference);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 *
	 * @param content
	 * @param type
	 * @param <T>
	 * @return
	 */
	public static <T> T convertValue(String content, JavaType type) {
		try {
			return MAPPER.readValue(content, type);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 *
	 * @param content
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> T convertValue(String content, Class<T> clazz) {
		try {
			return MAPPER.readValue(content, clazz);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 从json字符串中获取key对应的值，只使用于简单的json结构
	 * 
	 * @param json
	 * @param key
	 * @return
	 */
	public static String getValueFromJsonByKey(String json, String key) {
		if (json == null) {
			return "";
		}
		JSONObject js = JSON.parseObject(json);
		Object o = js.get(key);
		if (o == null) {
			return null;
		}
		return (String) o;
	}
}
