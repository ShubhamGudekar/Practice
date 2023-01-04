#include<stdio.h>
#define pi 3.142857
int main()
{
    int r,h;
    printf("Enter the Radius of the Cylinder ");
    scanf("%d",&r);
    printf("Enter the Height of the Cylinder ");
    scanf("%d",&h);
    printf("\nSurface Area of Cylinder %0.2f ",(2*pi*r*r)+(2*pi*r*h));
    printf("\nVolume of Cylinder %0.2f ",(2*pi*r*h));
    return 0;
}