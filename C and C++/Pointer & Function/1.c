#include <stdio.h>
#include <stdlib.h>
int main()
{
        int *p,n,j=0,i,e=0,o=0;
        printf("Enter the Number of Integers in Array ");
        scanf("%d",&n);
        p = (int*)malloc(n*sizeof(int));
        if (p == NULL)
                {
                printf("Memory not allocated");
                exit(1);
                }
        for (i=0;i<n;i++)
                {
                printf("Enter %dth Element ",i);
                scanf("%d",p+i);
                }
        for (i=0;i<n;i++)
                {
                if (*(p+i)%2 == 0)
                        e+=*(p+i);
                else
                        o+=*(p+i);
                }
        printf("\nSum of Even Numbers in Array = %d\nSum of Odd Numbers in Array = %d",e,o);
        free(p);
        p=NULL;
        return 0;
}