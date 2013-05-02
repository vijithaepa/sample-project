/**
 * 
 */
package com.digitali.presentation.user;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.DynaActionForm;
import org.springframework.beans.factory.annotation.Autowired;

import com.digitali.business.contract.UserManagerContract;
import com.digitali.entity.User;
import com.digitali.presentation.BaseDispatchAction;

/**
 * @author vijitha
 * 
 */
public class UserAction extends BaseDispatchAction {

	private static final String STRING_EMPTY = "";

	private static final String FAIL = "fail";

	private static final String SUCCESS = "success";

	private static final String USER = "user";

	private final Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	public UserManagerContract userManager;

	public ActionForward loadMyHomePageAction(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return mapping.findForward(SUCCESS);
	}

	public ActionForward userLoginAction(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.debug("Inside the userLoginAction");
		PropertyUtilsBean beanUtil = new PropertyUtilsBean();
		User user = (User) beanUtil.getSimpleProperty(form, USER);
		String authenticated = authenticate(user.getUsername(), user.getPassword(), request);
		user.setPassword(STRING_EMPTY);
		beanUtil.setSimpleProperty(form, USER, user);
		return mapping.findForward(authenticated);
	}

	public ActionForward loadRegisterHomePageAction(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward(SUCCESS);
	}

	public ActionForward userRegisterAction(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		DynaActionForm registrationForm = (DynaActionForm) form;
		User user = (User) registrationForm.get(USER);
		user.setCreatedDate(new Date());
		
		userManager.create(user);
		
		// ActionErrors errors = new ActionErrors();
		// errors.add("common.name.err", new
		// ActionMessage("error.common.name.required"));


		return mapping.findForward(SUCCESS);
	}

	public ActionForward userPhotoUploadHomePageAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		return null;
	}

	public ActionForward userPhotoUploadAction(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return null;
	}

	/*
	 * Private method to validate credentials.
	 */
	private String authenticate(String userName, String password, HttpServletRequest request) {

		User user = userManager.findByCredentials(userName, password);
		if (user != null) {
			request.getSession(true).setAttribute(USER, user);
			logger.info(" # User Authenticated : " + userName + " , " + user.toString());
		} else {
			ActionErrors errors = new ActionErrors();
			errors.add("errors.login", new ActionMessage("errors.login"));
			saveErrors(request, errors);
			logger.info(" # User Invalid : " + userName + " , " + password);
			return FAIL;
		}
		return SUCCESS;

	}
}
