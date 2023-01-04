#include<stdio.h>
int main()
    {
        float a;
        printf("Enter Annual BAsic Salary = ");
        scanf("%f",&a);
        if(a<150000)
        printf("Income tax = 0");
        if((a>=150000)&&(a<=300000))
        printf("Income tax = %0.2f",a*0.2);
        if(a>300000)
        printf("Income tax = %0.2f",a*0.3);
        return 0;
    }