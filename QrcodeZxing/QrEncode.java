import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.EnumMap;
import javax.imageio.ImageIO;
public class QrEncode{
	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0XFFFFFFFF;
	private static final int width = 250;
	private static final int height = 250;
	public static final EnumMap <EncodeHintType, Object>hint =new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
	static{
		hint.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.H);
		hint.put(EncodeHintType.MARGIN,0);
		hint.put(EncodeHintType.CHARACTER_SET,"UTF-8");
		hint.put(EncodeHintType.MAX_SIZE,350);
		hint.put(EncodeHintType.MIN_SIZE,150);
	}
	public static BufferedImage encodeImage(String content){
		BufferedImage image=null;
		try{
			BitMatrix matrix =new MultiFormatWriter().encode(content,BarcodeFormat.QR_CODE,width,height,hint);
			image =new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			int width=matrix.getWidth();
			int height= matrix.getHeight();
			for (int x=0;x<width;x++){
				for(int y=0;y<height;y++){
					image.setRGB(x,y,matrix.get(x,y)?BLACK:WHITE);
				}
			}
		}catch(Exception e){
			System.out.println("生成二维码失败"+e.getMessage());
		}
		return image;
	}
	public static void writeToFile(String content, String format, File file){
		BufferedImage image= encodeImage(content);
		try{
			ImageIO.write(image,format,file);
		}catch(IOException e){
			System.out.println("二维码写入失败"+e.getMessage());
		}
	}
	public static void writeToStream(String content, String format, OutputStream stream){
		BufferedImage image= encodeImage(content);
		try{
			ImageIO.write(image,format,stream);
		}catch(IOException e){
			System.out.println("二维码写入失败"+e.getMessage());
		}
	}

}