import java.util.Scanner;

public class LifeOfCells {
	
		//array of grid
		int grid[][];
		 int rows;
		 int cols;
		//using scanner class to take input from user
		Scanner sc = new Scanner(System.in);

public void set(int [][] grid,int rows,int cols)
{
   this.rows=rows;
   this.cols=cols;
   this.grid=new int[rows][cols];
   for(int i=0;i<rows;i++)
     for(int j=0;j<cols;j++)
     this.grid[i][j]=grid[i][j]; 
}

public void get()
{
	System.out.println("Original Generation: ");
   for(int i=0;i<rows;i++)
   { 
     for(int j=0;j<cols;j++)
     System.out.print(grid[i][j]);
  
       System.out.println();
   }
   System.out.println();
}

   public void printGrid()
    {
          for (int i = 0; i < rows; i++)
         {
                    for (int j = 0; j < cols; j++)
                  {
                     int Cell = grid[i][j];
                    check(i,j,Cell); 
                 }
         }   
    }
  
  public void check(int p,int q,int Cell)
    {
             int count=0,g1,g2,g3,g4;
              g1= p-1;
              g2 = p+1;
              g3 = q-1;
              g4 = q+1;
                if (g1 >= 0 && grid[g1][q]==1)
                  count++;
              
                if(g2 <rows && grid[g2][q]==1)
            
               count++; 
             if(g3 >=0 && grid[p][g3]==1)
               count++;
              
             if(g4 <cols && grid[q][g4]==1)
             {
               count++;
             }
             if(q>=0 && q<cols-1 && p>=0 && p<rows-1)
             { 
                if(grid[g2][g4]==1)
                  count++;
             }
             if(p>0 && p<rows && q>0 && q<cols)
             {
               if(grid[g1][g3]==1)
                 count++;
             }
             if(q>0 && q<cols && p>=0 && p<rows-1)
             {
               if(grid[g2][g3]==1)
                 count++;
             }
             if(p>0 && p<rows && q>=0 && q<cols-1)
             {
               if(grid[g1][g4]==1)
                 count++;       
             }
             if(Cell==1)
             { 
               if(count<2)             
             grid[p][q]=0;
             
               if(count>3)
             grid[p][q]=0;
          
             if(count==2 || count==3)
                 grid[p][q]=grid[p][q];  
             }
             if(Cell==0 && count==3)
               grid[p][q]=1;             
}
  public void nextGrid()
  {
	  System.out.println("Next Generation: ");
	  int k=1;
        if(k<rows)
      for(int i=0;i<rows;i++)
      { 
      
        for(int j=0;j<cols;j++)
          System.out.print(grid[i][j]);
      
        System.out.println();
      }
    }
    
  public void cellStatus()
   {
       int count = 0;
     System.out.println("Enter the cell you want to check:\n (Rows and column Starts from zero) ");
    
     System.out.println("Enter Row Number: ");
     int r=sc.nextInt();
     System.out.println("Enter Column Number: ");
     int c=sc.nextInt();
     if(r<rows && c<cols)
     { 
     for(int i=0;i<rows;i++)
     {
       for(int j=0;j<cols;j++)
         if(grid[r][c]==0)
           count=0;
         else
           count=1;
     } 
       if(count==0)
         System.out.println("Cell status : Dead");
       if(count==1)
         System.out.println("Cell status : Live");
          
     }
     else
     {
       System.out.println("Enter the valid rows and columns");
       cellStatus();
     }
   }
  public static void main(String[] args)
  {
	  System.out.println("\n----------------Welcome! to Game Of Life--------------------");
		System.out.println("Rules are :\n1. Any live cell with fewer than two live neighbors dies, as if by loneliness.\r\n" + 
				"2. Any live cell with more than three live neighbors dies, as if by overcrowding.\r\n" + 
				"3. Any live cell with two or three live neighbors lives, unchanged, to the next generation.\r\n" + 
				"4. Any dead cell with exactly three live neighbors comes to life.");
		Scanner sc2=new Scanner(System.in);
		System.out.println("\nEnter the Number of Rows you want:");
	     int row=sc2.nextInt();
	  
	    System.out.println("Enter the Number of Columns you want:");
	     int col=sc2.nextInt();
	    int [][] grid=new int[row][col];
	  
	    
	    System.out.println("\nEnter the states in Grid(Enter Only 0 or 1) where 0 = Dead and 1 = Live:");
	  
	    for(int i=0;i<row;i++) 
	      for(int j=0;j<col;j++)
	        grid[i][j]=sc2.nextInt();
	  
	    LifeOfCells lc = new LifeOfCells();
	    lc.set(grid, row, col);
	    lc.get();
	    
    int n;
  	do
      {
  		System.out.println("***********MENU************");
      	System.out.println("1. Print Next Generation.");
      	System.out.println("2. Get State of each cell.");
      	System.out.println("3. Exit Game.");
      	System.out.println("Enter your choise: ");
      	n = sc2.nextInt();
      	
     
      switch(n)
      {
      case 1:
      	lc.printGrid();
      	lc.nextGrid();
      	  break;
      case 2:
      	lc.cellStatus();
      	 break;
      case 3: 
      	System.out.println("You are Exited Successfully.Thank you for playing!");
      	System.exit(0);
      	break;
      default:
      	System.out.println("Please enter valid choise.");
      }
      }while(n>0);
}

} 