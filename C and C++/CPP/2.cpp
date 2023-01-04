#include<iostream>
using namespace std;
class person
    {
        string name,city;
        int age;

        public:
        string get_name(person a)
        {
            return a.name;
        }
        string get_city()
        {
            return this->city;
        }
        int get_age(void)
        {
            return this->age;
        }
        void set_name(string a)
        {
            this->name=a;
        }
        void set_city(string a)
        {
            this->city=a;
        }
        void set_age(int a)
        {
            this->age=a;
        }

        void displaydata()
        {
            cout<<"Name : "<<this->name<<endl;
            cout<<"Age  : "<<this->age<<endl;
            cout<<"City : "<<this->city<<endl;
        }
        person(void)
        {   
            cout<<endl<<"Parameterless constructor called (User Defined default constructor)"<<endl;
            this->name = "NULL";
            this->age=0;
            this->city = "NULL";
        }
        person(string name,int age,string city)
        {
            cout<<endl<<"Parameterized constructor called"<<endl;
            this->name = name;
            this->age=age;
            this->city = city;
        }
    };

int main()
    {
        person a;
        a.displaydata();
        person b("Shubh",27,"Pune");
        b.displaydata();
        cout<<endl<<"setting data in a"<<endl;
        a.set_name("Shubham");
        a.set_age(26);
        a.set_city("Mumbai");
        a.displaydata();
        cout<<endl;
        cout<<"Getting name stored in b :: "<<b.get_name(b)<<endl;
        cout<<"Getting age stored in b :: "<<b.get_age()<<endl;
        cout<<"Getting city stored in b :: "<<b.get_city();
        return 0;
    }