package com.khs.restful.client;

import com.khs.restful.system.Constants;

public class TextRequest extends BaseRequest {

	@Override
	public String getContentType() {
		return Constants.TEXT_MIME;
	}

}
