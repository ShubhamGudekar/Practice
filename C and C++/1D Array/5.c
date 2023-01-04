#include<stdio.h>
int main()
    {
        int a,b=0,r,i=1;
        printf("Enter number in decimal format ");
        scanf("%d",&a);
        printf("Binary Number of %d is ",a);
        while(a!=0)
            {
                r=a%2;
                a/=2;
                b=b+r*i;
                i*=10;
            }
        printf("%d",b);
        return 0;
    }