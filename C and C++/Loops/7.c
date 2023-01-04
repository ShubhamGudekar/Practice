#include<stdio.h>
int main()
    {
        int c,r,l,b;
        do
        {
        printf("\n\nEnter\n1 to Calculate Area of Circle \n2 to Calculate Area of Rectangle");
        printf("\n3 to Calculate Area of Triangle \n0 to Exit\nYour Choice = ");
        scanf("%d",&c);
        switch(c)
            {
                case 0:break;

                case 1:
                printf("Enter Radius of Circle ");
                scanf("%d",&r);
                printf("Area of Circle = %0.3f",3.142*r*r);
                break;

                case 2:
                printf("Enter Length of Rectangle ");
                scanf("%d",&l);
                printf("Enter Breadth of Rectangle ");
                scanf("%d",&b);
                printf("Area of Rectangle %d",l*b);
                break;

                case 3:
                printf("Enter height of triangle ");
                scanf("%d",&l);
                printf("Enter base of triangle ");
                scanf("%d",&b);
                printf("Area of triangle %0.3f",0.5*l*b);
                break;
                
                default:
                printf("Invalid Choice");
                break;
            }
        }while(c!=0);
    return 0;
    }