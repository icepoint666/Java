import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calc{
	public double MidCalc(Converter ctr){
		Stack stacks =new Stack(ctr.getcnt());
		double num1=0.0;double num2=0.0;double result=0.0;
		for(int i=0;i<ctr.getcnt();i++){
			if(ctr.getOutExpre(i) instanceof Integer){
				int temp=(Integer)ctr.getOutExpre(i);
				//System.out.print(temp+" ");
				stacks.push((double)temp);
			}
			else{
				char cr=(Character)ctr.getOutExpre(i);
				//System.out.print(cr+" ");
				num1=(Double)stacks.pop();
				num2=(Double)stacks.pop();
				switch(cr){
					case'+':result=num2+num1;break;
					case'-':result=num2-num1;break;
					case'*':result=num2*num1;break;
					case'/':result=num2/num1;break;
					default:result=0.0;break;
				}
				stacks.push(result);
			}
		}
		return (Double)stacks.pop();
	}
	public static void main(String[] args)throws Exception{
		InputStreamReader isr= new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		while(1==1){
			String str =br.readLine();
			Converter ctr =new Converter(str);
			ctr.convert();
			Calc calc=new Calc();
			Double result =calc.MidCalc(ctr);
			System.out.println(result);
		}
	}
}