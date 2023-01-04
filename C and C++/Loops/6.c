#include<stdio.h>
int main()
    {
        int n,o,i,f;
        printf("Program to find GCD of two number\nEnter value of first number ");
        scanf("%d",&n);
        printf("Enter Value of Second Number ");
        scanf("%d",&o);
        if((n>0)&&(o>0))
            {
                printf("\nGCD of %d and %d is ",n,o);
                for(i=1;i<=n;i++)
                    {
                       if(((n%i)==0)&&((o%i)==0))
                            {
                                f=i;
                            }
                    }
                printf("%d",f);
            }
        else
            printf("Invalid Number Entered");
        return 0;    
    }
