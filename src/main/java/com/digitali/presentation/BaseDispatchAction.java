package com.digitali.presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class BaseDispatchAction extends DispatchAction {

	private final Logger logger = Logger.getLogger(this.getClass());

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String methodName = mapping.getParameter();
		if (null == methodName || methodName.isEmpty()) {
			logger.debug("No such method Name : " + methodName);
			throw new NoSuchMethodException(methodName);
		}

		return super.execute(mapping, form, request, response);
	}

	@Override
	protected String getMethodName(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response, String parameter) throws Exception {

		String method = null;

		if (mapping instanceof BaseActionMapping) {
			method = ((BaseActionMapping) mapping).getMethod();
		} else {
			throw new java.lang.NoSuchMethodException("There is no method value for the mapping : " + mapping.getName());
		}

		logger.debug("found method Name : " + method);
		return method;
	}
}
