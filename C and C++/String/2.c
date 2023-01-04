#include<stdio.h> 
#include<string.h> 
int main()
{
    char string[100][100];
    int i,n,j=0,a[100];
    printf("Enter number of strings ");
    scanf("%d",&n);
    for(i=0;i<n;i++)
    {
        printf("Enter the %dth String    ",i+1);
        scanf("%*c%[^\n]",string[i]);
    }
    for(i=0;i<n;i++)
    {
        a[i]=strlen(string[i]);
    }
    for(i=0;i<n;i++)
    {
        if(a[0]<a[i])
        {
            a[0]=a[i];
            j=i;
        }
    }
    printf("\nLongest String Entered is ---- %s",string[j]);
    return 0;
}