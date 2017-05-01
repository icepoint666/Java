import java.lang.Math;
import java.util.Scanner;
public class KMeans{
	public static void main(String[] args)throws Exception{
		int cnt=0;
		double[] x=new double[200];
		double[] y=new double[200];
		double[] cluster_x= new double[200];
		double[] cluster_y= new double[200];
		System.out.print("Enter the number of cluster centers:");
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		System.out.print("Enter the number of repetitions:");
		int t=input.nextInt();
		java.io.File file1=new java.io.File("KMeans_Set.txt");
		java.io.File file2=new java.io.File("KMeans_Set2.txt");
		Scanner scan1= new Scanner(file1);
		while(scan1.hasNext()){
			cnt++;
			x[cnt]=scan1.nextDouble();
			y[cnt]=scan1.nextDouble();
		}
		scan1.close();
		Scanner scan2= new Scanner(file2);
		while(scan2.hasNext()){
			cnt++;
			x[cnt]=scan2.nextDouble();
			y[cnt]=scan2.nextDouble();
		}
		scan2.close();
		if(n<=0||t<=0||n>cnt){
			throw new ArithmeticException("The input makes no sense!");
		}
		for(int i=1;i<=n;i++){
			cluster_x[i]=x[i];
			cluster_y[i]=y[i];
		}
		for(int times=0;times<t;times++){
			int [] belongTo= new int[200];
			int [] isClusterBy= new int[200];
			double []sumCluster_x=new double [200];
			double []sumCluster_y=new double [200];
			for(int i=1;i<=n;i++){
				isClusterBy[i]=0;
				sumCluster_x[i]=0.0;
				sumCluster_y[i]=0.0;
			}
			for(int i=1;i<=cnt;i++){
				double mini_Dis=5000000000000.0;
				for(int j=1;j<=n;j++){
					double dis=distance(cluster_x[j],cluster_y[j],x[i],y[i]);
					if(dis<mini_Dis){
						mini_Dis=dis;
						belongTo[i]=j;
					}
				}
			}
			for(int i=1;i<=cnt;i++){
				isClusterBy[belongTo[i]]++;
				sumCluster_x[belongTo[i]]=sumCluster_x[belongTo[i]]+x[i];
				sumCluster_y[belongTo[i]]=sumCluster_y[belongTo[i]]+y[i];
			}
			for(int i=1;i<=n;i++){
				if(isClusterBy[i]>0){
					cluster_x[i]=sumCluster_x[i]/(1.0*isClusterBy[i]);
					cluster_y[i]=sumCluster_y[i]/(1.0*isClusterBy[i]);
				}
			}
		}
		System.out.println("The answers is as follows:");
		for(int i=1;i<=n;i++){
			System.out.println(i+"\t"+cluster_x[i]+"\t"+cluster_y[i]);
		}
	}
	public static double distance(double x1,double y1,double x2,double y2){
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
}