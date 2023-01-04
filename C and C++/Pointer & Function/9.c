#include<stdio.h>
int fib(int a)
    {
        if(a==1)
        return 0;
        else if(a==2)
        return 1;
        else if(a>2)
        return fib(a-2)+fib(a-1);
    }
int main()
    {
        int n;
        printf("Program to calculate nth Fibonacci Number \nEnter value of n ");
        scanf("%d",&n);
        printf("%dth fibonacci number is %d ",n,fib(n));
        return 0;    
    }