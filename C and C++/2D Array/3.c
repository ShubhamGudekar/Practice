#include<stdio.h> 
int main()
{
    int A[20][20],B[20][20],C[20][20],D[20][20];
    int ra,ca,rb,cb,i,j,k;
    printf("Enter number of Rows of Matrix A ");
    scanf("%d",&ra);
    printf("Enter number of Columns of Matrix A ");
    scanf("%d",&ca);
    for(i=0;i<ra;i++)
    {
        for(j=0;j<ca;j++)
        {
        printf("Enter the value of %dx%d of matrix A ",i+1,j+1);
        scanf("%d",&A[i][j]);
        }
    }
    printf("Enter number of Rows of Matrix B ");
    scanf("%d",&rb);
    printf("Enter number of Columns of Matrix B ");
    scanf("%d",&cb);
    for(i=0;i<rb;i++)
    {
        for(j=0;j<cb;j++)
        {
        printf("Enter the value of %dx%d of matrix B ",i+1,j+1);
        scanf("%d",&B[i][j]);
        }
    }
    printf("\nMatrix A is a %dx%d Matrix\n",ra,ca);
    for(i=0;i<ra;i++)
    {
        for(j=0;j<ca;j++)
        {
        printf("\t%d",A[i][j]);
        }
        printf("\n");
    }
    printf("\nMatrix B is a %dx%d Matrix\n",rb,cb);
    for(i=0;i<rb;i++)
    {
        for(j=0;j<cb;j++)
        {
        printf("\t%d",B[i][j]);
        }
        printf("\n");
    }
    if(ca==rb)
        {
            printf("\nMultiplication of Matrix is Possible");
            for(i=0;i<ra;i++)
                {
                    for(j=0;j<cb;j++)
                    {
                        C[i][j]=0;
                        for(k=0;k<ca;k++)
                        C[i][j]+=A[i][k]*B[k][j];
                    }
                }
        printf("\nMatrix c is a %dx%d Matrix (Multiplication Of Matrix A & Matrix B)\n",ra,cb);
        for(i=0;i<ra;i++)
        {
        for(j=0;j<cb;j++)
        {
        printf("\t%d",C[i][j]);
        }
        printf("\n");
        }
        }
    else
    printf("Multiplicaion Not Possible");
    if((ra==rb)&&(ca==cb))
    {
            printf("\nAddition of Matrix is Possible");
            for(i=0;i<ra;i++)
                {
                    for(j=0;j<ca;j++)
                    {
                        D[i][j]=0;
                        D[i][j]=A[i][j]+B[i][j];
                    }
                }
        printf("\nMatrix D is a %dx%d Matrix (Addition Of Matrix A & Matrix B)\n",ra,ca);
        for(i=0;i<ra;i++)
        {
        for(j=0;j<ca;j++)
        {
        printf("\t%d",D[i][j]);
        }
        printf("\n");
        }
        }
    else
    printf("Addition Not Possible");
    return 0;
}