#include<iostream>
using namespace std;
class book
    {
        string bname,author;
        int id,price;

        public:
        string get_bname()
        {
            return this->bname;
        }
        string get_author()
        {
            return this->author;
        }
        int get_id()
        {
            return this->id;
        }
        int get_price()
        {
            return this->price;
        }
        void set_bname(string a)
        {
            bname=a;
        }
        void set_author(string a)
        {
            author=a;
        }
        void set_id(int a)
        {
            this->id=a;
        }
        void set_price(int a)
        {
            this->price=a;
        }

        void displaydata()
        {
            cout<<"Id        : "<<this->id<<endl;
            cout<<"Book Name : "<<this->bname<<endl;
            cout<<"Author    : "<<this->author<<endl;
            cout<<"Price     : "<<this->price<<endl;
        }
        book(void)
        {   
            cout<<endl<<"Parameterless constructor called (User Defined default constructor)"<<endl;
            set_bname("");
            set_id(0);
            set_author("");
            set_price(0);
        }
        book(int a,string c,string d,int b)
        {
            cout<<endl<<"Parameterized constructor called"<<endl;
            set_id(a);
            set_bname(c);
            set_author(d);
            set_price(b);
            
        }
    };

int main()
    {
        book a;
        a.displaydata();
        book b(10,"Shubh","Pune",2000);
        b.displaydata();
        cout<<endl<<"setting data in a"<<endl;
        a.set_bname("Shubham");
        a.set_id(26);
        a.set_author("Mumbai");
        a.set_price(2500);
        a.displaydata();
        cout<<endl;
        cout<<"Getting name stored in b :: "<<b.get_bname()<<endl;
        cout<<"Getting id stored in b :: "<<b.get_id()<<endl;
        cout<<"Getting author stored in b :: "<<b.get_author()<<endl;
        cout<<"Getting price stored in b :: "<<b.get_price();
        return 0;
    }