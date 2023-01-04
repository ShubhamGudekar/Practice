#include<stdio.h>
int main ()
    {
        int a,b,c,d,e;
        float s,p;
        s1:
        printf("Enter the Marks obtained in Subject 1 ");
        scanf("%d",&a);
        if(a<0||a>100)
        goto s1;
        printf("Enter the Marks obtained in Subject 2 ");
        scanf("%d",&b);
        printf("Enter the Marks obtained in Subject 3 ");
        scanf("%d",&c);
        printf("Enter the Marks obtained in Subject 4 ");
        scanf("%d",&d);
        printf("Enter the Marks obtained in Subject 5 ");
        scanf("%d",&e);
        s=a+b+c+d+e;
        p=s/5;
        printf("\nTotal Marks Obtained is %.0f Out of 500",s);
        printf("\nPercentage %.2f",p);
        
    }