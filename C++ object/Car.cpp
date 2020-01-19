#include <iostream>
using namespace std;


class Car {
   public:
      Car(int initYear, string initMake);
      int getYear() const;
      string getMake() const;
      string getEngine() const;
      int getSpeed() const;
      void setEngine(string inputEngine);
      void toString() const;
      void accelerate();
      void brake();
   private:
      int year;
      string make;
      string engine;
      int speed;
};

//Car class inilializer
Car::Car(int initYear, string initMake){
  year = initYear;
  make = initMake;
  engine = "NoEngine";
  speed = 0;
}

//get year property
int Car::getYear() const{
  return year;
}

//get make property
string Car::getMake() const{
  return make;
}

//get engine property
string Car::getEngine() const{
  return engine;
}

//get speed property
int Car::getSpeed() const{
  return speed;
}

//set engine property
void Car::setEngine(string inputEngine){
  engine = inputEngine;
}

//toString method for car class
void Car::toString() const{
  cout << "Year: "<< year <<", Make: "<< make << ", Engine: "<< engine <<", Speed: "<< speed << endl;
}

//accelerate method, adds 5 to current speed
void Car::accelerate(){
  speed += 5;
}

//brake method, subtracs 5 from current speed, if speed>0
void Car::brake(){
  if(speed<=0){
     cout << "Car's speed is 0. Can't brake."<< endl;
       speed = 0;
  }
  else{
      speed -= 5;
  }
}

//Main Method to run object class
int main() {
  //create new object

  Car testCar(2019,"Telsa");
  //set engine
  testCar.setEngine("Old Prototype");
  cout <<"Current Car State: "<< endl;
  testCar.toString();
  
  //speed up car
  cout <<"Car speeding up"<< endl;
  for(int i=0;i<5;++i){
    testCar.accelerate();
    cout <<"Current Speed: "<< testCar.getSpeed()<< endl;
  }

  //brake car
  cout <<"Car braking"<< endl;
  for(int i=0;i<5;++i){
    testCar.brake();
    cout <<"Current Speed: "<< testCar.getSpeed()<< endl;
  }
  
  //final care state
  testCar.setEngine("New Prototype");
  cout <<"Current Car State: "<< endl;
  testCar.toString();
}
