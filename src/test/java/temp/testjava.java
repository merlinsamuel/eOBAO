package temp;

import library.ObjFactory;

public class testjava
{


	public static void main(String[] args)
	{
		
		String sheetname ="Sample";	
		
		int match = getEmptyRowIndex(sheetname);
		
		System.out.println("Value of empty row = "+match);

	}
	
	public static int getEmptyRowIndex(String sheetname)
	{
		int index=0;
		
		int row = ObjFactory.getexcel().getRowCount(sheetname);
		System.out.println("Row count: "+row);
		Object [] data = new Object[row];
		
		for(int i=0; i<row; i++)
		{
			data[i]=ObjFactory.getexcel().getCelData(sheetname, i, 1);
			if(data[i].equals(""))
			{
				index = i;
				break;
			}
		}
		return index;
	}

}
