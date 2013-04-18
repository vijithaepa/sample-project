package com.digitali.presentation;

import org.apache.log4j.Logger;
import org.apache.struts.config.SecureActionConfig;

public class BaseActionMapping extends SecureActionConfig {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	private final Logger logger = Logger.getLogger(this.getClass());

	protected String method;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		if (configured) {
			logger.error("Configuration is frozen");
			throw new IllegalStateException("Configuration is frozen");
		}
		this.method = method;
	}

	@Override
	public String toString() {

		StringBuffer sb = new StringBuffer(super.toString());

		if (method != null) {
			sb.append(",method=");
			sb.append(method);
		}

		return sb.toString();
	}
}
