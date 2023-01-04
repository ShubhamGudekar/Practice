#include<stdio.h>
int main()
    {
        int x,y,c,n,m;
        printf("Enter value of x ");
        scanf("%d",&x);
        printf("Enter value of y ");
        scanf("%d",&y);
        while(c!=0)
        {
        printf("\n\nEnter\n1 for Equality Check (x=y)\n2 for Less Than Check (x<y)");
        printf("\n3 for Quotient and Remainder (x/y & x%%y)\n4 for Range(if Number Entered is between x and y)");
        printf("\n5 for Swapping(Interchanging Values of x and y)\n0 to Exit\nYour Choice = ");
        scanf("%d",&c);
        switch(c)
            {
                case 0:break;
                
                case 1:
                if(x==y)
                printf("%d and %d are Equal",x,y);
                else
                printf("%d and %d are not equal",x,y);
                break;

                case 2:
                if(x<y)
                printf("%d is less than %d",x,y);
                else
                printf("%d is not less than %d",x,y);
                break;

                case 3:
                printf("Quotient = %d",x/y);
                printf("\nRemainder = %d",x%y);
                break;

                case 4:
                printf("Enter third number to check if it is between x and y ");
                scanf("%d",&m);
                if((x>m)?(m>y):(y>m))
                printf("%d lies between %d and %d",m,x,y);
                else
                printf("%d does not lie between %d and %d",m,x,y);
                break;

                case 5:
                printf("\nBefore Swapping \nx=%d       \ny=%d",x,y);
                n=x;                x=y;                y=n;
                printf("\nAfter Swapping \nx=%d       \ny=%d",x,y);
                break;

                default:
                printf("Invalid Choice");
            }
        }
        return 0;
    }