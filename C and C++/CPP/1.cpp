#include<iostream>
using namespace std;

class student
    {
        int rn,m1,m2,m3,total;
        char grade;
        float perc;

        public:
        void acceptinfo(void)
            {
                cout<<"Enter Roll No. of Student : ";
                cin>>this->rn;
                cout<<"Enter Marks in Subject 1 : ";
                cin>>this->m1;
                cout<<"Enter Marks in Subject 2 : ";
                cin>>this->m2;
                cout<<"Enter Marks in Subject 3 : ";
                cin>>this->m3;
                this->total=this->m1+this->m2+this->m3;
                this->perc=(float)(this->total)/3;
                if(this->perc>75)
                    this->grade='A';
                else if(this->perc>60&&this->perc<=75)
                    this->grade='B';
                else if(this->perc>50&&this->perc<=60)
                    this->grade='C';
                else if(this->perc>40&&this->perc<=50)
                    this->grade='D';
                else
                    this->grade='F';
            } 
        void printinfo(void)
            {
                cout<<endl<<endl;
                cout<<"Roll No.             "<<this->rn<<endl;
                cout<<"Marks in Subject 1   "<<this->m1<<endl;
                cout<<"Marks in Subject 2   "<<this->m2<<endl;
                cout<<"Marks in Subject 3   "<<this->m3<<endl;
                cout<<"Total MArks          "<<this->total<<"/300"<<endl;
                cout<<"Percentage           "<<this->perc<<"%"<<endl;
                if(this->perc>90)
                cout<<"Grade                "<<this->grade<<"+"<<endl;
                else
                cout<<"Grade                "<<this->grade<<endl;
            }
    };

int main()
    {
        student a;
        a.acceptinfo();
        a.printinfo();
        return 0;
    }