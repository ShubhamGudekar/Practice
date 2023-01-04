#include<stdio.h> 
#include<stdlib.h> 
int main()
{
    int *p,n,j=0,i,k; 
    printf("Enter the Number of Integers in Array ");
    scanf("%d",&n);
    p = (int*)malloc(n*sizeof(int)); 
    if(p==NULL)
    {
           printf("Memory not allocated");
           exit(1); 
    }
    for(i=0;i<n;i++)
    {
            printf("Enter %dth Element ",i);
            scanf("%d",&p[i]); 
    }
    printf("Enter Key to check if it is present in Array ");
    scanf("%d",&k);
    //Using Linear Search
    for(i=0;i<n;i++)
        {
            if(k==p[i])
                {
                    j++;
                }
        }
    if(j==0)
    printf("%d is not present in Array",k);
    else
    printf("%d has occured %d times in array",k,j);    
    return 0;
}
