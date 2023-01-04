#include<stdio.h>
void scanmatrix(int (*matrix)[20],int r,int c)
{
    for(int i=0;i<r;i++)
    {
        for(int j=0;j<c;j++)
        {
        printf("Enter the value of %dx%d    ",i+1,j+1);
        scanf("%d",*(matrix+i)+j);
        }
    }
}
void printmatrix(int (*matrix)[20],int r,int c)
{   
    for(int i=0;i<r;i++)
    {
        for(int j=0;j<c;j++)
        {
        printf("\t%d",*(*(matrix+i)+j));
        }
        printf("\n");
    }
}
int main()
{
    int A[20][20],B[20][20];
    int r,c,i,j,z=0,trace=0,x=0;
    printf("Enter number of Rows ");
    scanf("%d",&r);
    printf("Enter number of Columns ");
    scanf("%d",&c);
    scanmatrix(A,r,c);
    printf("\nMatrix A is a %dx%d Matrix\n",r,c);
    printmatrix(A,r,c);
    for(i=0;i<c;i++)
    {
        for(j=0;j<r;j++)
        B[j][i]=A[i][j];
    }
    if(r==c)
    {   
        printf("\nEntered Matrix is Square Matrix");
        for(i=0;i<r;i++)
        {
            for(j=0;j<c;j++)
            {
                if(A[i][j]==B[i][j])
                z++;
            }
        }
        if(z==(r*c))
        printf("\n\nMatrix is Symmetric");
        else
        printf("\n\nMatrix is Not Symmetric");
        for(i=0;i<r;i++)
        {
            for(j=0;j<c;j++)
            {
                if(i==j)
                {
                    trace+=A[i][j];
                }
            }
        }
        printf("\n\nTrace Of Matrix is %d",trace);
        for(i=0;i<r;i++)
        {
            for(j=0;j<c;j++)
            {
                if((i>j)&&A[i][j]!=0)
                    {
                        x++;
                    }
            }
        }
        if(x==0)
        printf("\n\nEntered Matrix is Upper Triangular Matrix\n");
        else
        printf("\n\nEntered Matrix is not Upper Triangular Matrix\n");
    }
    else
    printf("\n Entered MAtrix is not square matrix\n");
    return 0;
}