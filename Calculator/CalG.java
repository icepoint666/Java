import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CalG extends JFrame{
	JButton jb1=new JButton("+");
	JButton jb2=new JButton("1");
	JButton jb3=new JButton("2");
	JButton jb4=new JButton("3");
	JButton jb5=new JButton("(");
	JButton jb6=new JButton("-");
	JButton jb7=new JButton("4");
	JButton jb8=new JButton("5");
	JButton jb9=new JButton("6");
	JButton jb10=new JButton(")");
	JButton jb11=new JButton("*");
	JButton jb12=new JButton("7");
	JButton jb13=new JButton("8");
	JButton jb14=new JButton("9");
	JButton jb15=new JButton("Clear");
	JButton jb16=new JButton("/");
	JButton jb17=new JButton("C");
	JButton jb18=new JButton("0");
	JButton jb19=new JButton("=");
	JButton jb20=new JButton("Exit");
	String str="";
	JTextField jt= new JTextField(str);
	public CalG(){
		JPanel p1 =new JPanel();
		p1.setLayout(new GridLayout(4,5));
		p1.add(jb1);
		p1.add(jb2);
		p1.add(jb3);
		p1.add(jb4);
		p1.add(jb5);
		p1.add(jb6);
		p1.add(jb7);
		p1.add(jb8);
		p1.add(jb9);
		p1.add(jb10);
		p1.add(jb11);
		p1.add(jb12);
		p1.add(jb13);
		p1.add(jb14);
		p1.add(jb15);
		p1.add(jb16);
		p1.add(jb17);
		p1.add(jb18);
		p1.add(jb19);
		p1.add(jb20);
		JPanel p2= new JPanel(new BorderLayout());
		jt.setEnabled(false);
		jt.setFont(new Font("宋体",Font.BOLD,23));
		jt.setForeground(Color.BLACK);
		p2.add(jt,BorderLayout.NORTH);
		p2.add(p1,BorderLayout.CENTER);
		add(p2,BorderLayout.CENTER);
		ButtonListener listener = new ButtonListener();
		WindowListener listener2= new WindowListener();
		jb1.addActionListener(listener);
		jb2.addActionListener(listener);
		jb3.addActionListener(listener);
		jb4.addActionListener(listener);
		jb5.addActionListener(listener);
		jb6.addActionListener(listener);
		jb7.addActionListener(listener);
		jb8.addActionListener(listener);
		jb9.addActionListener(listener);
		jb10.addActionListener(listener);
		jb11.addActionListener(listener);
		jb12.addActionListener(listener);
		jb13.addActionListener(listener);
		jb14.addActionListener(listener);
		jb15.addActionListener(listener);
		jb16.addActionListener(listener);
		jb17.addActionListener(listener);
		jb18.addActionListener(listener);
		jb19.addActionListener(listener);
		jb20.addActionListener(listener2);
	}
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==jb1){
				str=str+"+";
				jt.setText(str);
			}else if(e.getSource()==jb2){
				str=str+"1";
				jt.setText(str);
			}else if(e.getSource()==jb3){
				str=str+"2";
				jt.setText(str);
			}else if(e.getSource()==jb4){
				str=str+"3";
				jt.setText(str);
			}else if(e.getSource()==jb5){
				str=str+"(";
				jt.setText(str);
			}else if(e.getSource()==jb6){
				str=str+"-";
				jt.setText(str);
			}else if(e.getSource()==jb7){
				str=str+"4";
				jt.setText(str);
			}else if(e.getSource()==jb8){
				str=str+"5";
				jt.setText(str);
			}else if(e.getSource()==jb9){
				str=str+"6";
				jt.setText(str);
			}else if(e.getSource()==jb10){
				str=str+")";
				jt.setText(str);
			}else if(e.getSource()==jb11){
				str=str+"*";
				jt.setText(str);
			}else if(e.getSource()==jb12){
				str=str+"7";
				jt.setText(str);
			}else if(e.getSource()==jb13){
				str=str+"8";
				jt.setText(str);
			}else if(e.getSource()==jb14){
				str=str+"9";
				jt.setText(str);
			}else if(e.getSource()==jb15){
				str="";
				jt.setText(str);
			}else if(e.getSource()==jb16){
				str=str+"/";
				jt.setText(str);
			}else if(e.getSource()==jb17){
				if(str==""){
					str="";
				}
				else{
					str=str.substring(0,str.length()-1);
				}
				jt.setText(str);
			}else if(e.getSource()==jb18){
				str=str+"0";
				jt.setText(str);
			}
			else if(e.getSource()==jb19){
				Converter ctr =new Converter(str);
				ctr.convert();
				Calc calc=new Calc();
				Double result =calc.MidCalc(ctr);
				String res=Double.toString(result);
				jt.setText(res);
				str="";
			}
		}
	}
	class WindowListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
 			System.exit(0);
	 	}
	}
	public static void main(String[] args){
		CalG frame = new CalG();
		frame.setTitle("Calculator(Just for integers)");
		frame.setSize(400,250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
