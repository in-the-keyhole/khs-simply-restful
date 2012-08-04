package com.khs.restful.client;

public abstract class BaseRequest implements IRequest {

	@Override
	public boolean isFileContent() {
		return false;
	}

}
