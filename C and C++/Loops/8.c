#include<stdio.h>
int main()
    {
        int n,f,i,j,t=0;
        printf("Program to print all prime number between 1 to n\nEnter value of n ");
        scanf("%d",&n);
        if(n>0)
            {
                if(n==1)
                printf("1 is neither Composite nor Prime");
                else
                {       
                printf("Prime Numbers between 1 and %d are\n",n);
                for(i=2;i<=n;i++)
                    {
                        f=0;
                        for(j=1;j<=i;j++)
                            {
                                if((i%j)==0)
                                {
                                f++;
                                }
                            }
                        if(f<=2)
                            
                            {
                                printf("%d  ",i);
                                t++;
                            }
                    }
                printf("\nTotal number of Prime Number between 1 and %d is %d",n,t);
                }
            }
        else
            printf("Invalid Number Entered");
        return 0;    
    }
