#include<stdio.h> 
#include<stdlib.h> 
int main()
{
    int *p,n,j,i,k; 
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
    //Sorting Array using Insertion Sort
    for(i=1;i<n;i++)
        {
            j = i-1;
            k= p[i];
            while((j>=0)&&(k>p[j]))
                {
                    p[j+1]=p[j];
                    j--;
                }
            p[j+1]=k;
        }
    printf("Sorted array in descending order\n");
    for(i=0;i<n;i++)
    printf("%d  ",p[i]);
    free(p); 
    p=NULL;    
    return 0;
}