#include<stdio.h> 
int main()
{
    int A[20][20],B[20][20];
    int r,c,i,j;
    printf("Enter number of Rows ");
    scanf("%d",&r);
    printf("Enter number of Columns ");
    scanf("%d",&c);
    for(i=0;i<r;i++)
    {
        for(j=0;j<c;j++)
        {
        printf("Enter the value of %dx%d    ",i+1,j+1);
        scanf("%d",&A[i][j]);
        }
    }
    printf("Matrix A is a %dx%d Matrix\n",r,c);
    for(i=0;i<r;i++)
    {
        for(j=0;j<c;j++)
        {
        printf("\t%d",A[i][j]);
        B[j][i]=A[i][j];
        }
        printf("\n");
    }
    printf("Matrix B is a %dx%d Matrix (Transpose of Matrix A)\n",c,r);
    for(i=0;i<c;i++)
    {
        for(j=0;j<r;j++)
        {
        printf("\t%d",B[i][j]);
        }
        printf("\n");
    }

    return 0;
}