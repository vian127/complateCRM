package com.pop136.customerservice.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MatrixToImageWriter {

	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;

	private MatrixToImageWriter() {
	}

	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
			}
		}
		return image;
	}

	public static void writeToFile(BitMatrix matrix, String format, File file) throws IOException {
		BufferedImage image = toBufferedImage(matrix);

		if (!ImageIO.write(image, format, file)) {
			throw new IOException("Could not write an image of format " + format + " to " + file);
		}
	}

	public static void writeToStream(BitMatrix matrix, String format, OutputStream stream) throws IOException {

		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, stream)) {
			throw new IOException("Could not write an image of format " + format);
		}
	}

	public static void writeToStream(BufferedImage image, String format, OutputStream stream) throws IOException {

		if (!ImageIO.write(image, format, stream)) {
			throw new IOException("Could not write an image of format " + format);
		}
	}

	public static byte[] getImage(String codeText, int width, int height) {
		try {
			Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
			hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			hintMap.put(EncodeHintType.MARGIN, 1); /* default = 4 */
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			BitMatrix byteMatrix = qrCodeWriter.encode(codeText, BarcodeFormat.QR_CODE, width, height, hintMap);
			int byteMatrixWidth = byteMatrix.getWidth();
			int byteMatrixHeight = byteMatrixWidth; // Height and Width are same
			BufferedImage image = new BufferedImage(byteMatrixWidth, byteMatrixHeight, BufferedImage.TYPE_INT_RGB);
			image.createGraphics();

			Graphics2D graphics = (Graphics2D) image.getGraphics();
			graphics.setColor(Color.WHITE);
			graphics.fillRect(0, 0, byteMatrixWidth, byteMatrixWidth);
			graphics.setColor(Color.BLACK);
			// Loop on Width and Height to fill the rectangle block of WHITE and BLACK
			// patches
			for (int i = 0; i < byteMatrixWidth; i++) {
				for (int j = 0; j < byteMatrixHeight; j++) {
					if (byteMatrix.get(i, j)) {
						graphics.fillRect(i, j, 1, 1);
					}
				}
			}

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "jpg", baos );
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();

			return imageInByte;
		} catch (WriterException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public  static String getQRcodeUrl(String text)
	{
		String qrCodeUrl;
		byte[] img = MatrixToImageWriter.getImage(text, Constants.qrcode_width, Constants.qrcode_height);
		qrCodeUrl = FileUtil.uploadImg(img);
		return qrCodeUrl;
	}

	public static String getWeChatQRCode(String usertoken, String params) throws IOException
	{
		RestTemplate rest = new RestTemplate();

		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + Constants.appid
				+ "&secret=" + Constants.secret;

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		HttpEntity requestEntity = new HttpEntity(headers);

		ResponseEntity<String> entity = rest.exchange(url, HttpMethod.GET, requestEntity, String.class, new Object[0]);

		JSONObject jsonObject = JSON.parseObject(entity.getBody());
		return getQRCodeUrl(jsonObject.get("access_token").toString(), params);
	}


	public static String getQRCodeUrl(String accessToken, String sceneStr) throws IOException
	{
		String qrCodeUrl = "";
    RestTemplate rest = new RestTemplate();
    InputStream inputStream = null;
    String url = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=" + accessToken;
    Map<String, Object> param = new HashMap<>();
    param.put("scene", sceneStr);
    param.put("page", "pages/register/register");
    param.put("width", 430);
    param.put("auto_color", false);
    Map<String, Object> line_color = new HashMap<>();
    line_color.put("r", 0);
    line_color.put("g", 0);
    line_color.put("b", 0);
    param.put("line_color", line_color);
    MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();

    HttpEntity requestEntity = new HttpEntity(param, headers);
    ResponseEntity<byte[]> entity = rest.exchange(url, HttpMethod.POST, requestEntity, byte[].class, new Object[0]);
    byte[] result = entity.getBody();

		qrCodeUrl = FileUtil.uploadImg(result);
		return qrCodeUrl;
	}

	public static void main(String[] args) throws Exception {
		String text = "http://www.baidu.com"; // 二维码内容
		int width = 300; // 二维码图片宽度
		int height = 300; // 二维码图片高度
		String format = "jpg";// 二维码的图片格式

		Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 内容所使用字符集编码

		BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
		// 生成二维码
		File outputFile = new File("d:" + File.separator + "new.jpg");
		MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
	}
}
