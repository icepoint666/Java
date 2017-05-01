public class Converter{
	private String expre;
	private Stack stack;
	private Object[] outExpre=new Object[500];
	private int cnt;
	public Object getOutExpre(int i){
		return outExpre[i];
	}
	public void setExpre(String expre){
		init(expre);
	}
	public void init(String expre){
		this.expre=expre;
		stack =new Stack(expre.length());
	}
	public int getcnt(){
		return cnt;
	}
	public Converter(String expre){
		init(expre);
	}
	public void convert(){
		cnt=0;
		boolean flag=true;
		for(int i=0;i<expre.length();i++){
			char cr = expre.charAt(i);
			if(i>0&&expre.charAt(i-1)=='('&&cr=='-'){	
				flag=false;
			}
			else if(cr=='+')forOper(cr,1);
			else if(cr=='-')forOper(cr,1);
			else if(cr=='*')forOper(cr,2);
			else if(cr=='/')forOper(cr,2);
			else if(cr=='(')stack.push(cr);
			else if(cr==')')forBra();
			else{
				int tmp=0;
				do{
					tmp=tmp*10+expre.charAt(i)-'0';
					i++;
					if(i==expre.length())break;
				}while(expre.charAt(i)>='0'&&expre.charAt(i)<='9');
				i--;
				if(flag)outExpre[cnt++]=(Integer)tmp;
				else{
					tmp=0-tmp;
					outExpre[cnt++]=(Integer)tmp;
				}
				flag=true;
			}
		}
		while(!stack.isEmpty()){
			outExpre[cnt++]=(Character)stack.pop();
		}
	}
	private void forBra(){
		while(!stack.isEmpty()){
			char topOper=(Character)stack.pop();
			if(topOper=='(')break;
			else outExpre[cnt++]=(Character)topOper;
		}
	}
	private void forOper(char thisOper,int thisWt){
		while(!stack.isEmpty()){
			char topOper=(Character)stack.pop();
			if(topOper=='('){
				stack.push(topOper);
				break;
			}
			else{
				int topWt=2;
				if(topOper=='+'||topOper=='-'){
					topWt=1;
				}
				if(topWt<thisWt){
					stack.push(topOper);
					break;
				}
				else outExpre[cnt++]=(Character)topOper;
			}
		}
		stack.push(thisOper);
	}
}