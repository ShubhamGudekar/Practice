#include<Stdio.h>
int sum(int x);
int main()
    {
        int x,a;
        printf("Program to find sum of digits of number\nEnter the number ");
        scanf("%d",&x);
        printf("Sum of digits of %d is %d",x,sum(x));
        return 0;
    }
int sum(int x)
    {  
        int y,s;
        if(x>0)
            {
                y=x%10;
                s=y+sum(x/10);
                if(s<10)
                return s;
                else
                return sum(s);
            }
        else
        return 0;
    }