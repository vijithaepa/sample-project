package com.digitali.presentation.photo;


public class PhotoAction { // extends BaseDispatchAction {

	// private final Logger logger = Logger.getLogger(this.getClass());
	// PhotoManagerContract photoManager;
	//
	// public PhotoManagerContract getPhotoManager() {
	// return photoManager;
	// }
	//
	// public void setPhotoManager(PhotoManagerContract photoManager) {
	// this.photoManager = photoManager;
	// }

	// public ActionForward uploadPhoto(ActionMapping mapping, ActionForm form,
	// HttpServletRequest request,
	// HttpServletResponse response) throws Exception {
	// logger.debug(" # Inside the uploadPhoto");
	// PropertyUtilsBean beanUtil = new PropertyUtilsBean();
	// int maxFileSize = 5000 * 1024;
	// int maxMemSize = 5000 * 1024;
	//
	// String caption = "AA";// (String) beanUtil.getSimpleProperty(form,
	// "title");
	// String description = "BB";// (String) beanUtil.getSimpleProperty(form,
	// "description");
	// FormFile photoFile = (FormFile) beanUtil.getSimpleProperty(form,
	// "uploadFile");
	// // File file = new File(photoFile.getFileName());
	// logger.info("Image name : " + photoFile.getFileName());
	// logger.info("Image Content TYpe : " + photoFile.getContentType());
	// logger.debug("Image Class TYpe : " + photoFile.getClass());
	//
	// // TODO: validate image
	// // TODO: resize and assign to a thumb
	// Photo model = new Photo();
	// model.setName(photoFile.getFileName());
	// model.setCaption(caption);
	// model.setDescription(description);
	// // int type = photoFile.getType() == 0? BufferedImage.TYPE_INT_ARGB :
	// originalImage.get
	// BufferedImage originalImage = PhotoUtil.getBufferedImage(photoFile);
	// // BufferedImage resizedImage = PhotoUtil.scaleImage(originalImage);
	// // model.setImgThumbInByte(PhotoUtil.getByteArrayThumb(resizedImage,
	// // photoFile.getContentType()));
	// model.setCreatedDate(new Date());
	// User loggedUser = (User) request.getSession().getAttribute("user");
	// model.setCreatedUser(loggedUser);
	//
	// // Store the actual image on server location
	// ServletContext context = getServlet().getServletContext();
	// String contextPath = context.getInitParameter(PhotoUtil.IMG_URI);
	// String uploadLocation =
	// context.getInitParameter(PhotoUtil.IMG_UPLOAD_LOCATION) +
	// loggedUser.getUserId();
	//
	// // String contextPath = "PhotoSite";
	// String imgLocation = PhotoUtil.storeImage(originalImage,
	// photoFile.getFileName(), uploadLocation);
	//
	// new Thread(new PhotoStoreThread(PhotoUtil.scaleImage(originalImage),
	// photoFile.getFileName(), uploadLocation))
	// .start();
	// model.setImgLocation(contextPath + loggedUser.getUserId() + "/" +
	// PhotoUtil.THUMB_FOLDER_NAME + "/");
	// model.setImgName(photoFile.getFileName());
	//
	// List<PhotoModel> photos = new ArrayList<PhotoModel>();
	// photos.add(model);
	// photoManager.uploadPhotos(photos);
	//
	// List<PhotoModel> photoModelList = photoManager.getPhotos((User)
	// request.getSession().getAttribute(
	// CommonUtil.SESSION_USER_KEY));
	// BeanUtils.setProperty(form, "uploadedFiles", photoModelList);
	//
	// return mapping.findForward("success");
	// }
	//
	// public ActionForward photoHome(ActionMapping mapping, ActionForm form,
	// HttpServletRequest request,
	// HttpServletResponse response) throws Exception {
	// logger.debug(" # Inside the photoHome");
	// BufferedImage imageThumb;
	// List<PhotoModel> photoModelList = photoManager.getPhotos((User)
	// request.getSession().getAttribute(
	// CommonUtil.SESSION_USER_KEY));
	// BeanUtils.setProperty(form, "uploadedFiles", photoModelList);
	// return mapping.findForward("success");
	// }

}
