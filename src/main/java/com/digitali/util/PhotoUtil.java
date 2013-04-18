package com.digitali.util;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.struts.upload.FormFile;

public class PhotoUtil {

	/**
	 * Apache http web server(Actual) location for storing images.
	 */
	// @Value("${photo.base.location}")
	private static final String IMG_UPLOAD_LOCATION = "photo.base.location";

	/**
	 * URI for images which is called in the browser.
	 */
	private static final String IMG_URI = "photo.base.uri";

	private static final String THUMB_FOLDER_NAME = "photo.base.uri";

	private static final String THUMB_IMG_HEIGHT = "photo.base.thumb.height";

	private static final String THUMB_IMG_WIDTH = "photo.base.thumb.width";

	//Property reader from above bean property keys
	private Properties pros;

	private static Dimension THUMB_SIZE;

	public static BufferedImage loadImage(String ref) {
		BufferedImage bimg = null;
		try {

			bimg = ImageIO.read(new File(ref));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bimg;
	}

	/**
	 * Stores the image and it's resized image in a physical location.
	 * 
	 * @param originalImage image to store.
	 * @param fileName image file name.
	 * @param uploadLocation physical location to store.
	 * @param logedUser user who uploading the image.
	 * @return actual location of image stored.
	 */
	public String storeImage(BufferedImage originalImage, String fileName, long userId) {
		// TODO: rootFolder must be removed
		File outDir = new File(getBaseLocation() + "/" + userId);
		if (!outDir.exists()) {
			outDir.mkdirs();
		}
		File thumbDir = new File(outDir.getPath() + "/" + getThumFolderName());
		if (!thumbDir.exists()) {
			thumbDir.mkdirs();
		}

		try {
			String format = (fileName.endsWith(".png")) ? "png" : "jpg";
			ImageIO.write(originalImage, format, new File(outDir.getPath() + "/" + fileName));

			BufferedImage scaledImg = scaleImage(originalImage);
			ImageIO.write(scaledImg, format, new File(thumbDir + "/" + fileName));

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return outDir.getPath();
	}

	/**
	 * Return the BufferedImage of a Image File.
	 * 
	 * @param file .
	 * @return BufferedImage.
	 */
	public static BufferedImage getBufferedImage(FormFile file) {
		BufferedImage buffImg = null;
		try {
			InputStream in = new ByteArrayInputStream(file.getFileData());
			buffImg = ImageIO.read(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffImg;
	}

	public static BufferedImage getBufferedImage(File file) {
		BufferedImage buffImg = null;
		try {
			buffImg = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffImg;
	}

	/**
	 * Resize the image to the original scale.
	 * 
	 * @param image Original image.
	 * @return scaled image.
	 */
	public BufferedImage scaleImage(BufferedImage newImage) {
		THUMB_SIZE = getThumbSize();
		BufferedImage image = newImage;
		int oriW = image.getWidth();
		int oriH = image.getHeight();
		int desW = 0, desH = 0;

		if (oriW == oriH) {
			desW = THUMB_SIZE.width;
			desH = THUMB_SIZE.height;
		} else if (oriW > oriH) {
			desW = THUMB_SIZE.width;
			desH = (THUMB_SIZE.width * oriH) / oriW;
		} else if (oriW < oriH) {
			desH = THUMB_SIZE.height;
			desW = (THUMB_SIZE.height * oriW) / oriH;
		}

		BufferedImage resizedImage = new BufferedImage(desW, desH, image.getType());
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(image, 0, 0, desW, desH, null);
		g.dispose();
		g.setComposite(AlphaComposite.Src);

		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		return resizedImage;
	}

	public Properties getPros() {
		return pros;
	}

	public void setPros(Properties pros) {
		this.pros = pros;
	}

	public String getBaseLocation() {
		return pros.getProperty(IMG_UPLOAD_LOCATION);
	}

	public String getImageURI() {
		return pros.getProperty(IMG_URI);
	}

	public String getThumFolderName() {
		return pros.getProperty(THUMB_FOLDER_NAME);
	}

	public int getThumbImgHeight() {
		return Integer.parseInt(pros.getProperty(THUMB_IMG_HEIGHT, "200"));
	}

	public int getThumbImgWidth() {
		return Integer.parseInt(pros.getProperty(THUMB_IMG_WIDTH, "200"));
	}

	private Dimension getThumbSize() {
		return new Dimension(getThumbImgWidth(), getThumbImgHeight());
	}
}
