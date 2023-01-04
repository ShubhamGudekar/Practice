#include<iostream>
using namespace std;
class point
    {
        int x,y;

        public:
        int get_x()
        {
            return this->x;
        }
        int get_y()
        {
            return this->y;
        }
        void set_x(int a)
        {
            this->x=a;
        }
        void set_y(int a)
        {
            this->y=a;
        }

        void displaydata()
        {
            cout<<endl<<"Point : ("<<get_x()<<","<<get_y()<<")"<<endl;
        }
        point(void)
        {   
            cout<<endl<<"Parameterless constructor called (User Defined default constructor)"<<endl;
            set_x(0);
            set_y(0);
        }
        point(int x,int y)
        {
            cout<<endl<<"Parameterized constructor called"<<endl;
            set_x(x);
            set_y(y);
        }
    };

int main()
    {
        point a;
        a.displaydata();
        point b(10,-20);
        b.displaydata();
        cout<<endl<<"setting data in a"<<endl;
        a.set_x(-26);
        a.set_y(30);
        a.displaydata();
        cout<<endl<<"Getting Point stored in B"<<endl;
        cout<<endl<<"Point : ("<<b.get_x()<<","<<b.get_y()<<")"<<endl;
        return 0;
    }