package com.khs.restful.client;

import com.khs.restful.system.Constants;

public class XmlRequest extends BaseRequest {

	@Override
	public String getContentType() {
		return Constants.XML_MIME;
	}

}
