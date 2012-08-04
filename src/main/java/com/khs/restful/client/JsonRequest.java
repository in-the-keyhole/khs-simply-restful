package com.khs.restful.client;

import com.khs.restful.system.Constants;

public class JsonRequest extends BaseRequest {

	public String getContentType() {
		return Constants.JSON_MIME;
		
	}

}
