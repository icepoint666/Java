import java.io.File;
public class DecodeMain{
	public static void main(String[] args){
		System.out.println("解析结果如下：");
		String content= QrDecode.decodeImage(new File("./qr.png"));
		System.out.println(content);
	}
}