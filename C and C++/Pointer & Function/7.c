#include<Stdio.h>
int power(int x,int y);
float power1(int x,int y);
int main()
    {
        int x,y;
        printf("Program to find value of x raised to y\nEnter value of x ");
        scanf("%d",&x);
        printf("Enter value of y ");
        scanf("%d",&y);
        if(x==0)
        printf("Any power raised to 0 is 0");
        else if(y==0)
        printf("Value of %d raised to %d is 1",x,y);
        else
            {
                if(y>0)
                printf("Value of %d raised to %d is %d",x,y,power(x,y));
                if(y<0)
                printf("Value of %d raised to %d is %f",x,y,power1(x,y));
                return 0;
            }
    }
int power(int x,int y)
    {  
        if(y>0)
        return x*power(x,y-1);
        else
        return 1;
    }
float power1(int x,int y)
    {  
        if(y<-1)
        return ((float)1/x)*power1(x,y+1);
        else
        return (float)1/x;
    }