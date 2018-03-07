package com.gome.meidian.sessionshare.utils;

import java.util.List;


/**
 * 返回的json 对象
 * @author shichangjian
 *
 * @param <T>
 */
public class ResponseJson<T> {
	
	private int code = StatusCode.SUCCESS.getCode();
	private String msg = StatusCode.SUCCESS.getMsg();
	private T data;

	private transient static ResponseJson successResponse = new ResponseJson(StatusCode.SUCCESS, true);

	public ResponseJson() {
	}

	public ResponseJson(int code) {
		super();
		this.code = code;
	}

	public ResponseJson(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public ResponseJson(StatusCode statusCode, boolean success) {
		code = statusCode.getCode();
		msg = statusCode.getMsg();
	}
	public ResponseJson(StatusCode statusCode) {
		code = statusCode.getCode();
		msg = statusCode.getMsg();
	}

	public ResponseJson(T data) {
		this.data = data;
	}


	public static ResponseJson getValidationErrorResponse(List<ValidationError> errorList) {
		ResponseJson<List<ValidationError>> responseJson = new ResponseJson<>();
		responseJson.setData(errorList);
		return responseJson;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data == null ? (T) new Object() : data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return String.format("ResponseJson [code=%d, msg=%s, data=%s]",code, msg, JSONUtils.toJSONString(data));
	}

	public static ResponseJson getSuccessResponse() {
		return ResponseJson.successResponse;
	}

	public static ResponseJson getFailedResponse() {
		return new ResponseJson(StatusCode.SYSTEM_ERROR, false);
	}

	public static ResponseJson getFailedResponse(String msg) {
		ResponseJson response = new ResponseJson(StatusCode.SYSTEM_ERROR, false);
		response.setMsg(msg);
		return response;
	}

	public static class ValidationError {
		private String param;
		private String msg;

		public ValidationError(String param, String msg) {
			this.param = param;
			this.msg = msg;
		}

		public String getParam() {
			return param;
		}

		public void setParam(String param) {
			this.param = param;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}
	}

}
