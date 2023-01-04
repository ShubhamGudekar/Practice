#include<stdio.h>
int isPrime(int a)
    {
        int i,j=0;
        for(i=1;i<=a;i++)
        {
            if(a%i==0)
            j++;
        }
        if(j<=2)
        return 1;
        else
        return 0;
    }
int main()
    {
        int a,c=0,s;
        printf("First 10 Prime Numbers are \n");
        for(a=2;c<=10;a++)
            {
                s=isPrime(a);
                if(s==1)
                    {
                        printf("%d ",a);
                        c++;
                    }
            }
        return 0;
    }