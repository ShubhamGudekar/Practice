#include<stdio.h>
#define pi 3.142857
int main()
{
    int r;
    printf("Enter the Radius of the Circle ");
    scanf("%d",&r);
    printf("\nArea of the Circle is           %0.3f",pi*r*r);
    printf("\nCircumference of the Circle is  %0.3f",pi*r*2);
    return 0;
}