#include<stdio.h>
int main()
    {
        int n,f=0,i;
        printf("Program to Calculate Factors of number\nEnter value of number ");
        scanf("%d",&n);
        if(n>0)
            {
                printf("Factors of %d \n",n);
                for(i=1;i<=n;i++)
                    {
                       if((n%i)==0)
                            {
                                printf("%d  ",i);
                                f++;
                            }
                    }
                printf("\nTotal Number of Factors = %d",f);
            }
        else
            printf("Invalid Number Entered");
        return 0;    
    }
