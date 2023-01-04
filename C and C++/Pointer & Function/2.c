#include<stdio.h>
int isEven(int a)
    {
       if(a%2==0)
       return 1;
       else
       return 0;
    }
int main()
    {
        int a,s;
        printf("Enter number to check if its Even or Odd ");
        scanf("%d",&a);
        s=isEven(a);
        if(s==1)
        printf("Number is Even");
        else
        printf("Number is Odd");
        return 0;
    }