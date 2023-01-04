#include<stdio.h>
int main()
    {
        printf("Enter the Temperature in Fahrenheit ");
        float f,c;
        scanf("%f",&f);
        c=((f-32)*5)/9;
        printf("Converting....\nTempertaure in Celsius %.2f C",c);
        printf("\nTempertaure in Kelvin %.2f K",c+273.15);
        return 0;
    }