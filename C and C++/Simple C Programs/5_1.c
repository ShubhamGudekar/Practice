#include<stdio.h>
int main ()
    {
        //Swapping using another Variable
        int a,b,temp;
        printf ("Enter the First number ");
        scanf("%d",&a);
        printf ("Enter the Second number ");
        scanf("%d",&b);
        printf("\nBefore Swapping ------ First Number = %d Second Number = %d",a,b);
        temp=a;
        a=b;
        b=temp;
        printf("\n\nAfter Swapping  ------ First Number = %d Second Number = %d",a,b);
        return 0;
    }