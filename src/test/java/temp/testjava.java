package temp;

import library.ObjFactory;

public class testjava
{

	public static void main(String[] args)
	{
		ObjFactory.getexcel().setCelData("RBS_EOBAO_Status", 1, 0, 1);
		
		int i=1;
		int sno=0;
		
		String data = ObjFactory.getexcel().getCelData("RBS_EOBAO_Status", i-1, 0);
		sno = Integer.parseInt(data.trim());
		System.out.println(sno);
		
		ObjFactory.getexcel().setCelData("RBS_EOBAO_Status", i, 0, sno+1);
		System.out.println("Excel updated");
	}
	
}
