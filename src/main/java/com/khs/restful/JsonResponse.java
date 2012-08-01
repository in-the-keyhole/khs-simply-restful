package com.khs.restful;

import com.khs.restful.system.Constants;

public class JsonResponse extends Response implements IResponse {

	@Override
	public String getContenetType() {
		return Constants.JSON_MIME;
	}
}
