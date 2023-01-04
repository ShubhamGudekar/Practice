#include<stdio.h>
int main()
    {
        int a,i;
        unsigned char b;
        printf("Enter Character ");
        scanf("%c",&b);
        printf("Enter Number ");
        scanf("%d",&a);
        i=b;
        while(i<=(b+a))
            {
                printf("%c  ",i);
                i++;
            }
        return 0;
    }