#include<iostream>
using namespace std;
class complexnumber
    {
        int real,imaginary;

        public:
        int get_real()
        {
            return this->real;
        }
        int get_imaginary()
        {
            return this->imaginary;
        }
        void set_real(int a)
        {
            this->real=a;
        }
        void set_imaginary(int a)
        {
            this->imaginary=a;
        }

        void displaydata()
        {  
            if(get_imaginary()>=0)
            cout<<endl<<"Complex Number : "<<get_real()<<"+"<<get_imaginary()<<"i"<<endl;
            if(get_imaginary()<0)
            cout<<endl<<"Complex Number : "<<get_real()<<get_imaginary()<<"i"<<endl;
        }
        complexnumber(void)
        {   
            cout<<endl<<"Parameterless constructor called (User Defined default constructor)"<<endl;
            set_real(0);
            set_imaginary(0);
        }
        complexnumber(int real,int imaginary)
        {
            cout<<endl<<"Parameterized constructor called"<<endl;
            set_real(real);
            set_imaginary(imaginary);
        }
    };

int main()
    {
        complexnumber a;
        a.displaydata();
        complexnumber b(10,-20);
        b.displaydata();
        cout<<endl<<"setting data in a"<<endl;
        a.set_real(-26);
        a.set_imaginary(30);
        a.displaydata();
        cout<<endl<<"Getting Complex Number stored in B"<<endl;
        b.displaydata();
        return 0;
    }