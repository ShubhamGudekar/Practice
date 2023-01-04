#include<stdio.h>
int main()
    {
        int a,b,c;
        printf("Enter the first angle of triangle = ");
        scanf("%d",&a);  
        printf("Enter the second angle of triangle = ");
        scanf("%d",&b);
        printf("Enter the third angle of triangle = ");
        scanf("%d",&c);
        if((a+b+c)==180)
        printf("\nValid Triangle");
        else
        printf("\nInvalid Triangle");
        return 0;
    }
        
