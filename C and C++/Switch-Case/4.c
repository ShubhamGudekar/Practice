#include<stdio.h>
#define pi 3.142
int main()
    {
        int r,c;
        printf("Enter value of Radius ");
        scanf("%d",&r);
        while(c!=0)
        {
        printf("\n\nEnter\n1 to Calculate Area of Circle \n2 to Calculate Circumference of Circle");
        printf("\n3 to Calculate Valume of Sphere \n0 to Exit\nYour Choice = ");
        scanf("%d",&c);
        switch(c)
            {
                case 0:break;
                case 1:
                printf("Area of Circle = %0.3f",pi*r*r);
                break;
                case 2:
                printf("Circumference of CIrcle = %0.3f",2*pi*r);
                break;
                case 3:
                printf("Volume of Sphere = %0.3f",1.333*pi*r*r*r);
                break;
                default:
                printf("Invalid Choice");
                break;
            }
        }
    return 0;
    }