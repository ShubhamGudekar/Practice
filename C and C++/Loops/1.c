#include<stdio.h>
int main()
    {
        int a=0,s=0;
        while(a>=0)
            {
                printf("\nEnter Number ");
                scanf("%d",&a);
                if(a>=0)
                {
                    s=s+a;
                    printf("Sum = %d",s);
                }
            }
        printf("\nNegative number Entered-----Program terminated");
        return 0;
    }