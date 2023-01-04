#include<iostream>
using namespace std;
class shape //Abstract class
    {
        protected:
        float area;
        public:
        shape(void)
            {
            area=0;
            }
        virtual void acceptdata()=0;//Pure virtual Fuunction
        virtual void displaydata()=0;
    };
class rectangle : public shape
    {
        int l,b;
        public:
        rectangle(void)
            {
            l=0;
            b=0;
            }
        void acceptdata()
            {
                cout<<endl;
                cout<<"Enter Lenght of rectangle ";
                cin>>l;
                cout<<"Enter Breadth of rectangle ";
                cin>>b;
                area=l*b;
            }
        void displaydata()
            {
                cout<<endl;
                cout<<"Rectangle's Lenght  = "<<l<<endl;
                cout<<"Rectangle's Breadth = "<<b<<endl;
                cout<<"Area of rectangle   = "<<area<<endl;
            }
    };
class circle : public shape
    {
        int r;
        public:
        circle(void)
            {
            r=0;
            }
        void acceptdata()
            {
                cout<<endl;
                cout<<"Enter Radius of Circle ";
                cin>>r;
                area=3.142*r*r;
            }
        void displaydata()
            {
                cout<<endl;
                cout<<"Radius of Circle = "<<r<<endl;
                cout<<"Area of Circle   = "<<area<<endl;
            }
    };
class square : public shape
    {
        int l;
        public:
        square(void)
            {
            l=0;
            }
        void acceptdata()
            {
                cout<<endl;
                cout<<"Enter Lenght of square ";
                cin>>l;
                area=l*l;
            }
        void displaydata()
            {
                cout<<endl;
                cout<<"Lenght of Square = "<<l<<endl;
                cout<<"Area of Square   = "<<area<<endl;
            }
    };

int main()
    {
        rectangle a;
        a.acceptdata();
        a.displaydata();
        circle c;
        c.acceptdata();
        c.displaydata();
        square e;
        e.acceptdata();
        e.displaydata();
    }