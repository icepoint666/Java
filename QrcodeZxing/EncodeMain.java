import java.io.File;
public class EncodeMain{
	public static void main(String[] args){
		String content="生成二维码的内容";
		String fileName="./qr.png";
		QrEncode.writeToFile(content, "png", new File(fileName));
		System.out.println("已成功生成二维码");
	}
}