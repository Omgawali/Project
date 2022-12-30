
////////////////////////////////////////////////////////
//
//          Customize DataBaseManagement ( SQL )
//
//
//
//
//
//
//
//
//////////////////////////////////////////////////////

import java.lang.*;
import java.util.*;


//Database table/schema
class Student
{
	public int RID;
	public String Name;
	public int Salary;
	
	private static int Generator;
	
	static
	{
		Generator=0;
	}
	
	public Student(String str,int value)
	{
		this.RID=++Generator;
		this.Name=str;
		this.Salary=value;
	}
	
	public void DisplayData()
	{
		
		System.out.println("\t"+"|"+"\t"+this.RID+"\t"+this.Name+"\t"+this.Salary+"\t"+"|");
	}
}

class DBMS
{
	public LinkedList<Student>iobhj;

    public DBMS()
	{
		iobhj=new LinkedList<>();
	}
    public void StartDBMS()
	{
		Scanner scanobhj=new Scanner(System.in);
		System.out.println("");
		System.out.println("        Gawalis customized DBMS Started Successfully       ");		
		System.out.println("--------------------------------------------------------------------");
		
		String Query="";
		while(true)
		{
			System.out.print("\t"+"Gawalis DBMS Console >");
			Query=scanobhj.nextLine();
			
			String tokens[]=Query.split(" ");
			int QuerySize=tokens.length;
			
			if(QuerySize==1)
			{
				if("Help".equals(tokens[0]))
				{
					System.out.println("This application is use to demonstrate customize DBMS ");
					System.out.println("Exit: Terminate DBMS");
					System.out.println("Display all data: Select * from Student");
					System.out.println("Display Minimum salary data: Select min from Student");
					System.out.println("Display Maximun salary data: select max from Student");
					System.out.println("Display summation of salarys : select sum from Student");
					System.out.println("Insert data :Insert into Student Name Salary");
				
				}
				else if("Exit".equals(tokens[0]))
				{
					System.out.println("Thankyou for using DBMS");
					break;
				}
			}
			else if(QuerySize==2)
			{
				
			}
			//display name from student
			//select * from student
			else if(QuerySize==4)
			{
				if("Select".equals(tokens[0]))
				{
					if("*".equals(tokens[1]))
					{
						System.out.println("");
						System.out.println("\t---------------------------------");
						System.out.println("\t"+"|"+"\t"+"ID"+"\t"+"Name"+"\t"+"Salary"+"\t"+"|"+"\t");
					DisplayAll();
					System.out.println("\t---------------------------------");
					}
					else if("min".equals(tokens[1]))
					{
							System.out.println("");
						System.out.println("\t---------------------------------");
						System.out.println("\t"+"|"+"\t"+"ID"+"\t"+"Name"+"\t"+"Salary"+"\t"+"|"+"\t");
						AggregateMin();
						System.out.println("\t---------------------------------");
					}
					else if("max".equals(tokens[1]))
					{
							System.out.println("");
						System.out.println("\t---------------------------------");
						System.out.println("\t"+"|"+"\t"+"ID"+"\t"+"Name"+"\t"+"Salary"+"\t"+"|"+"\t");
						AggregateMax();
						System.out.println("\t---------------------------------");
					}
					else if("sum".equals(tokens[1]))
					{
                        System.out.println("");
						System.out.println("\t---------------------------------");
						System.out.println("\t"+"|"+"\t"+"ID"+"\t"+"Name"+"\t"+"Salary"+"\t"+"|"+"\t");
					DisplayAll();
						 AggregateSum();
					}
					else if("avg".equals(tokens[1]))
					{
						System.out.println("");
						System.out.println("\t---------------------------------");
						System.out.println("\t"+"|"+"\t"+"ID"+"\t"+"Name"+"\t"+"Salary"+"\t"+"|"+"\t");
					DisplayAll();
						 AggregateAvg();
					}
					else if("count".equals(tokens[1]))
					{
						System.out.println("");
						System.out.println("\t---------------------------------");
						System.out.println("\t"+"|"+"\t"+"ID"+"\t"+"Name"+"\t"+"Salary"+"\t"+"|"+"\t");
					DisplayAll();
						 AggregateCount();
					}
				}
				else if("Delete".equals(tokens[0]))
				{
		            	DeleteSpecific(tokens[1]);
				}
				else if("Display".equals(tokens[0]))
				{
					DisplaySpecific(tokens[1]);
					
				}
			}
			else if(QuerySize==5)
			{
				//delete Id 3 from student
				//delete name from student
				//insert into student piyush 1000
				if("Insert".equals(tokens[0]))
				{
					InsertData(tokens[3],Integer.parseInt(tokens[4]));
				}
				else if("Delete".equals(tokens[0]))
				{
					if("Id".equals(tokens[1]))
					{
						DeleteSpecific(Integer.parseInt(tokens[2]));
						
					}
					
				}
				else if("Display".equals(tokens[0]))
				{
					if("Id".equals(tokens[1]))
					{
						DisplaySpecific(Integer.parseInt(tokens[2]));
						
					}
				}
			}
		}
	}
	//insert into query vala logic
	public void InsertData(String str,int value)
	{
		Student sobhj=new Student(str,value);
		iobhj.add(sobhj);
	}
	//dis
	public void DisplayAll()
	{
		for(Student sref:iobhj)
		{
			sref.DisplayData();
		}
	}
	//displayby rid
	public void DisplaySpecific(int rid)
	{
		for(Student sref:iobhj)
		{
			if(sref.RID==rid)
			{
			sref.DisplayData();
			break;
			}
		}
	}
	//display by name
	public void DisplaySpecific(String str)
	{
		for(Student sref:iobhj)
		{
			if(str.equals(sref.Name))
			{
			sref.DisplayData();
			}
		}
	}
	
	public void DeleteSpecific(int rid)
	{
		int index=0;
		for(Student sref:iobhj)
		{
			if(sref.RID==rid)
			{
			iobhj.remove(index);
			break;
			}
			index++;
		}
	}
	//delete by name
	public void DeleteSpecific(String str)
	{
		int index=0;
		for(Student sref:iobhj)
		{
			if(str.equals(sref.Name))
			{
			iobhj.remove(index);
			break;
			}
			index++;
		}
	}
	
	public void AggregateMax()
	{
		int iMax=0;
		Student temp=null;
		for(Student sref:iobhj)
		{
			if(sref.Salary > iMax)
			{
				iMax=sref.Salary;
				temp=sref;
			}
		}
		System.out.println("Maximimum salary");
		temp.DisplayData();
	}
	
	public void AggregateMin()
	{
		int iMin=(iobhj.getFirst()).Salary;
		Student temp=iobhj.getFirst();
		for(Student sref:iobhj)
		{
			if(sref.Salary < iMin)
			{
				iMin=sref.Salary;
				temp=sref;
			}
		}
		System.out.println("Minimum salary");
		temp.DisplayData();
	}
	
	public void AggregateSum()
	{
		long iSum=0;
		
		for(Student sref:iobhj)
		{
			iSum=iSum+sref.Salary;
		}
		System.out.println("Summation of salary "+iSum);
		
	}
	
	public void AggregateAvg()
	{
		long iSum=0;
		
		for(Student sref:iobhj)
		{
			iSum=iSum+sref.Salary;
		}
		System.out.println("average salary is "+iSum/(iobhj.size()));
		
	}
	
	public void AggregateCount()
	{
		System.out.println("Count :");
	}
}

class project3
{
	public static void main(String arg[])
	{
	    DBMS dobhj=new DBMS();
		dobhj.StartDBMS();
	/*	dobhj.InsertData("Piyush",1000);
		dobhj.InsertData("Shruti",2000);
		dobhj.InsertData("Sachin",5000);
		dobhj.InsertData("om",7000);
		dobhj.InsertData("pranav",2000);
		dobhj.InsertData("karan",1000);
	
		
		//dobhj.DisplaySpecific("Piyush");
	//	dobhj.DeleteSpecific(2);
		
		//dobhj.DeleteSpecific("Piyush");
		dobhj.AggregateMax();
		dobhj.AggregateMin();
		dobhj.AggregateSum();
		dobhj.AggregateAvg();
		dobhj.AggregateCount();
		//dobhj.DisplayAll();
		*/
		System.out.println("--------------------------------------------------");
	}
}