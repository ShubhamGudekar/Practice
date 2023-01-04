#include<stdio.h>
int main ()
    {
        //Swapping using Arthmetic Operations
        int a,b;
        printf ("Enter the First number ");
        scanf("%d",&a);
        printf ("Enter the Second number ");
        scanf("%d",&b);
        printf("\nBefore Swapping ------ First Number = %d Second Number = %d",a,b);
        a=a+b;
        b=a-b;
        a=a-b;
        printf("\n\nAfter Swapping  ------ First Number = %d Second Number = %d",a,b);
        return 0;
    }