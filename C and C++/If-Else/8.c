#include<stdio.h>
int main()
    {
        int a,b,c,m,n;
        printf("Enter the first Number = ");
        scanf("%d",&a);  
        printf("Enter the second Number = ");
        scanf("%d",&b);
        printf("Enter the third Number = ");
        scanf("%d",&c);
        if((a==b)&&(a==c))
        printf("All Numbers are Equal..!!");
        else
        {
            m=(a>=b)?((a>c)?a:c):((b>c)?b:c);
            n=(a<=b)?((a<c)?a:c):((b<c)?b:c);
            if(a==b)
            printf("\nFirst & Second Number are Equal..!!");
            if(b==c)
            printf("\nSecond & Third Number Numbers are Equal..!!");
            if(a==c)
            printf("\nFirst & Third Number are Equal..!!");
            printf("\nMaximum Number = %d \nMinimum Number = %d",m,n);
        }
        return 0;
    }


