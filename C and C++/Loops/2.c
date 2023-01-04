#include<stdio.h>
int main()
    {
        int x,n,v=1,i;
        float v1=1;
        printf("Program to Calculate x raised to n\nEnter value of x ");
        scanf("%d",&x);
        printf("Enter value of n ");
        scanf("%d",&n);
        if(n>0)
            {
                for(i=1;i<=n;i++)
                v=v*x;
                printf("Value of %d raised to %d is %d",x,n,v);
            }
        else if(n==0)
            printf("Value of %d raised to %d is 1",x,n);
        else if(0>n)
            {
                for(i=-1;i>=n;i--)
                v1=v1/x;
                printf("Value of %d raised to %d is %f",x,n,v1);
            }

    }