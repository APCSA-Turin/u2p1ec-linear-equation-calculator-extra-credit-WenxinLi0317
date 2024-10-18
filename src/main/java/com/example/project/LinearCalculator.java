
    package com.example.project;
    public class LinearCalculator{
        //INSTANCE VARIABLES 
        //4 INTEGER variables (name them: x1,x2,y1,y2) 
        private int x1;
        private int x2;
        private int y1;
        private int y2;
    
    
        //CONSTRUCTOR
        //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
        //For example, "(1,2)" and "(3,4)" would be two parameter values 
        //You will have to parse the string into 4 integers, representing the 2 points.
    
        //in order to successfully set the coordinate to int x1,x2,y1,y2 
        //we want to split the point into a substring where () and comma are excluded
        
        public LinearCalculator(String point1, String point2){ 
        //we first find the index of the parenthesis and comma
            int paren1 = point1.indexOf("(");
            int paren2 = point1.indexOf(")");
            int comma= point1.indexOf(",");
    
            int comma2= point2.indexOf(",");
            int paren3 = point2.indexOf("(");
            int paren4 = point2.indexOf(")");
        //and exlude the parenthesis and comma, takes only the interger out from the substring
        //and parse that substring into int
            this.x1 = Integer.parseInt(point1.substring(paren1 + 1, comma).trim());
            this.y1 = Integer.parseInt(point1.substring(comma + 1, paren2).trim());
            this.x2 = Integer.parseInt(point2.substring(paren3 + 1, comma2).trim());
            this.y2 = Integer.parseInt(point2.substring(comma2 + 1, paren4).trim());   
        }
    
    
    
        //METHODS
        //getters and setters for the 4 instance variables (8 methods total) 
        public int getX1(){return x1;}
        public int getY1(){return y1;}
        public int getX2(){return x2;}
        public int getY2(){return y2;}
        public void setX1(int newX1){x1 = newX1;}
        public void setY1(int newY1){y1 = newY1;}
        public void setX2(int newX2){x2 = newX2;}
        public void setY2(int newY2){y2 = newY2;}
    
    
    
        //distance() -> returns a double. 
        //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
        public double distance(){
            //we first calculate the horizontal and vertical distance bewtween x1,x2 & y1,y2
            double horizontal = (double) (x2 - x1);
            double vertical = (double) (y2 - y1);
            //then we add the square of each value, then square root it to gte distance
            double distance = Math.sqrt(horizontal * horizontal + vertical * vertical);
            //by using math round, we can round it to 2 decimal places
            //by fist multiply it by 100.00, then divide by 100.00
            return Math.round(distance * 100.0) / 100.0;
        }
    
        //yInt() -> returns a double. 
       
        //if y-int if undefined, should return -999.99
        public double yInt(){
            //if the slope is undefined, then the y-intercept is undefined, too
    
            double slope = slope();
            if (slope == -999.99) {
                return -999.99; // Undefined y-intercept
            }
            //but if we had a valid slope, we can calculate the y-int
            //by first take the value of y-coor, subtract it by the product of the x-coor*slope
            double yInt = y1 - (slope * x1);
            return Math.round(yInt * 100.0) / 100.0;
        }
    
        //slope() -> returns a double. 
        //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
        //if slope is undefined, should return -999.99
        public double slope() {
            int horizontal = x2 - x1;
            //if the denominator is 0, then the slope is undefined
            if (horizontal == 0) {
                return -999.99; // Undefined slope
            }
            //we can find slope by divide the change in y-value over change in x-value
            double vertical = y2 - y1;
            double slope = vertical / horizontal;
              //by using math round, we can round it to 2 decimal places
            //by fist multiply it by 100.00, then divide by 100.00
            return Math.round(slope * 100.0) / 100.0;
        }
    
        //equations() -> returns a String.
        //calculates the final equation in y=mx+b form and returns the string
        //if the equation has no slope, the equation should return -> "undefined"
        //HINT: You may need other custom methods to decrease the amount of code in the equations() method
        public String equation(){
            double slope = slope();
            double b = yInt();
            //if slope is undefined, then the whole equation is undefined
            if(slope==-999.99){
                return "undefined";
            }else if (slope==0){
                //if slope is 0, then nomatter what x-value you have, y is always equal to the y int
                return "y="+b;
            }else if(b==-999.99 || b==0){
                //but if there is no y-int, instead of y=mx+0.0,
                //we want it to report just simply y=mx
                return "y="+slope+"x";
            }else if (b < 0){
                //if y-int is a negative vaule, we want to delte that extra "+" sign
                return "y="+slope+"x"+b;
            }else{
                //if y-int is a positive vaule, we want to keep that extra "+" sign
                return "y="+slope+"x+"+b;
            }
        }
    
    
        //roundedToHundredth(double x)-> returns double
        //calculates the input to the nearest hundredth and returns that value
        public double roundedToHundredth(double x){
            return Math.round(x*100)/100;
        }
    
        //printInfo() -> returns a string of information
        //this method is tested but you can also call it in your main method if gradle tests are 
        //not working. 
        

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        if((x1 == -x2) && (y1 == -y2)){
        return "Symmetric about the origin";
        }else if (x1==x2){
            return "Symmetric about the x-axis";
        }else if (y1==y2){
            return "Symmetric about the y-axis";
        }else {
            return "No symmetry";
        }
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        double xMidpoint = (double)(x1+x2)/2;
        double yMidpoint = (double)(y1+y2)/2;
        return "The midpoint of this line is: ("+xMidpoint+","+yMidpoint+")";
    }

    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    public String printInfo(){
       String str = "The two points are: (" + x1 + "," + y1 + ")";
       str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        str += "\n"+findSymmetry();
        str += "\n"+Midpoint();
        return str;
    }

}



