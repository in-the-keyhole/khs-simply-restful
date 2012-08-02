package com.khs.restful;

import com.khs.restful.system.Constants;

public class JsonRequest implements IRequest {

	public String getContentType() {
		return Constants.JSON_MIME;
		
	}

}
