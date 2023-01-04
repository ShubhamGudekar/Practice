#include<stdio.h>
int main()
    {
        char a[250];
        printf("Enter the Sentence ");
        scanf("%[^\n]",a);
        printf("%s",a);
        int i=0;
        //printf("\nSize of a %d",sizeof(a));
        while(a[i]<sizeof(a))
            {
                if(a[i]==' ')
                a[i]='*';
                else if((a[i]>64)&&(a[i]<91))
                a[i]+=32;
                else if((a[i]>96)&&(a[i]<123))
                a[i]-=32;
                else if((a[i]>47)&&(a[i]<58))
                a[i]='?';
                i++;
            }
        printf("\n%s",a);
        return 0;
    }