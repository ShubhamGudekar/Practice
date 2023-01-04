#include<stdio.h>
int main()
    {
        int a;
        float b,c,d,e;
        printf("Enter the Basic Salary of Employee ");
        scanf("%d",&a);
        b=a*0.02;//PF
        c=a*0.03;//Tax
        d=a*0.05;//HRA
        e=a*0.08;//DA
        printf("Gross Salary = %0.1f",a+b+c+d+e);
        printf("\nNet Salary = %0.1f",a+d+e);
    }