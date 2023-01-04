#include<stdio.h>
int main()
    {
        int a;
        printf("Enter the Number to check if it is Divisle by 5 & 7 = ");
        scanf("%d",&a);
        if(a%5==0)
        printf("\nNumber is Divisble by 5");
        else
        printf("\nNumber is Not Divisble by 5");
        if(a%7==0)
        printf("\nNumber is Divisble by 7");
        else
        printf("\nNumber is Not Divisble by 7");
        return 0;
    }