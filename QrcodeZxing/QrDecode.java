import com.google.zxing.*;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import java.awt.image.BufferedImage;
import java.util.EnumMap;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class QrDecode{
	private static final EnumMap<DecodeHintType,Object>hint =new EnumMap<DecodeHintType,Object>(DecodeHintType.class);
	static{
		hint.put(DecodeHintType.CHARACTER_SET,"UTF-8");
		hint.put(DecodeHintType.PURE_BARCODE,true);
	}
	public static String decodeImage(File imageFile){
		String content=null;
		if(!imageFile.isFile()){
			System.out.println("输入的为非文件格式");
			return null;
		}
		BufferedImage image;
		try{
			image = ImageIO.read(imageFile);
			LuminanceSource source =new BufferedImageLuminanceSource(image);
			Binarizer binarizer =new HybridBinarizer(source);
			BinaryBitmap binaryBitmap =new BinaryBitmap(binarizer);
			MultiFormatReader reader =new MultiFormatReader();
			Result result =reader.decode(binaryBitmap,hint);
			content =result.getText();
		}catch(IOException e){
			e.printStackTrace();
		}catch(NotFoundException e){
			System.out.println("无法识别该文件");
		}
		return content;
	}
}