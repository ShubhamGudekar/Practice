#include<stdio.h>
int GCD(int a,int b)
    {
        if(b==0)
        return a;
        else
        return GCD(b,a%b);
    }
int main()
    {
        int n,o,f;
        printf("Program to find GCD of two number\nEnter value of first number ");
        scanf("%d",&n);
        printf("Enter Value of Second Number ");
        scanf("%d",&o);
        f=GCD(n,o);
        printf("\nGCD of %d and %d is %d",n,o,f);
        return 0;    
    }