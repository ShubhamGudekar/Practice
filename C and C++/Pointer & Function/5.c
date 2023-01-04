#include <stdio.h>

int fac(int x)
{
	int i,fac=1;
	for(i=1;i<=x;i++)
		fac=fac*i;
	return fac;
}
float power (float x,int y)
{
    int i;
    float v=1;
    if(y>0)
        {
            for(i=1;i<=y;i++)
                v=v*x;
                return v;
        }
}

int main()
{
	float x,x1,sum=0;
	int i,j,limit;

	printf("Enter the value of x of sinx series: ");
	scanf("%f",&x);

	printf("Enter the limit upto which you want to expand the series: ");
	scanf("%d",&limit);

	x1=x;
	x = x*(3.1415/180);

	for(i=1,j=1;i<=limit;i++,j=j+2)
	{
		if(i%2!=0)
		{
			sum=sum+power(x,j)/fac(j);
		}
		else
			sum=sum-power(x,j)/fac(j);
	}

	printf("Sin(%0.1f): %f",x1,sum);
	return 0;
}