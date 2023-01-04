#include<stdio.h>
int main()
    {
        int n,f=1,i;
        printf("Program to Calculate Factorial of number\nEnter value of number ");
        scanf("%d",&n);
        if(n>=0)
            {
                for(i=1;i<=n;i++)
                f=f*i;
                printf("Factorial = %d",f);
            }
        else
            printf("Invalid Number Entered");
        return 0;    
    }

        
