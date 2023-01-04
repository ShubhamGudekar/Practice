#include<stdio.h> 
int main()
{
    int m[100][100];
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
        scanf("%d",&m[i][j]);
        }
    }
    printf("Entered Matrix is %dx%d Matrix\n",r,c);
    for(i=0;i<r;i++)
    {
        int sr=0;
        for(j=0;j<c;j++)
        {
        sr+=m[i][j];
        printf("\t  %d",m[i][j]);
        }
        printf("\tsum=%d\n",sr);
    }
    for(j=0;j<c;j++)
        {
            int sc=0;
            for(i=0;i<r;i++)
            {
            sc+=m[i][j];
            }
            printf("\tsum=%d",sc);
        }
    return 0;
}