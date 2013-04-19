/**
 * 
 */
package com.digitali.presentation.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	private final Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	public UserManagerContract userManager;

	public ActionForward loadMyHomePageAction(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return mapping.findForward("success");
	}

	public ActionForward userLoginAction(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.debug(" Inside the userLoginAction");
		PropertyUtilsBean beanUtil = new PropertyUtilsBean();
		User user = (User) beanUtil.getSimpleProperty(form, "user");

		return mapping.findForward(authenticate(user.getUsername(), user.getPassword(), request));
	}

	public ActionForward loadRegisterHomePageAction(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<User> userLIst = new ArrayList<User>(); 	// userManager.getAllUsers();
		request.setAttribute("userList", userLIst);
		request.setAttribute("resultSize", userLIst.size());
		return mapping.findForward("registerHome");
	}

	public ActionForward userRegisterAction(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.debug("########### Inside the userRegister");

		// ActionErrors errors = new ActionErrors();
		// errors.add("common.name.err", new ActionMessage("error.common.name.required"));

		DynaActionForm registrationForm = (DynaActionForm) form;
		User user = (User) registrationForm.get("user");
		user.setCreatedDate(new Date());
		userManager.create(user);
		return mapping.findForward("success");
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
			request.getSession(true).setAttribute("user", user);
			logger.info(" # User Authenticated : " + userName + " , " + user.toString());
		} else {
			ActionErrors errors = new ActionErrors();
//			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.login"));
			errors.add("login.error", new ActionMessage("error.login"));
			saveErrors(request, errors);
			logger.info(" # User Invalid : " + userName + " , " + password);
			return "fail";
		}
		return "success";

	}
}
