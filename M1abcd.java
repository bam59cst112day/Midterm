//// Midterm code for 59CST112

/**************************************************************
BE SURE TO CHANGE THE NEXT SEVERAL LINES, USING YOUR REAL NAME.

    MY FIRST NAME IS......Xerxes
    MY MIDDLE NAME IS.....Yolanda
    MY LAST NAME IS.......Zero
    
PICK 3 WORDS THAT START WITH YOUR INITIALS, using lower case letters:

    first word............xyst
    second word...........yclept
    third word............zed
    
USE THESE 3 WORDS TO NAME ALL VARIABLES FOR 3 POOL BALLS.
(You may abbreviate any words, but start with same letter.)
***************************************************************/


//// GLOBALS FOR 3 colored balls ////
//// (Assume ball diameter is 30.) ////
float xerxesX,  xerxesY,  xerxesDX,  xerxesDY;          //++++ MODIFY THIS.  Don' use "wolf". ++++
float ycleptX,  ycleptY,  ycleptDX,  ycleptDY;              //++++ MODIFY THIS.  Don' use "ham". ++++
float hippoX,  zedY, zedDX, zedDY;      //++++ MODIFY THIS.  Don' use "hippo". ++++
            //++++ MODIFY THESE DECLARATIONS -- Do not use "wolf" or "ham" or "hippo" ++++


//// OTHER GLOBALS:  strings, pool table, etc ////

String title=  "CST112 MIDTERM EXAM";
String news=   "Click any ball to reset it to right half of table.  (r resets all.)";
String author=  "Your Name";

float left=50, right=450, top=100, bottom=250;        // Table boundaries
float middle=250;
boolean wall=true;

int tableRed=150, tableGreen=250, tableBlue=150;      // green pool table
int score=0,m=0,k=0;

    // ADD YOUR OWN DECLARATIONS HERE. ++++


//// SETUP:  size and table
void setup() {
    size( 500, 303 );          //++++ CHANGE THE SIZE -- see instructions! ++++
  
    //// MODIFY THIS CODE TO MAKE TABLE CENTERED IN WINDOW.  ++++

    // Table boundaries
 }


//// NEXT FRAME:  table, bounce off walls, collisions, show all
void draw() {
  background( 250,250,200 );
  rectMode( CORNERS );
  table( left, top, right, bottom );
  buttons();
  bounce();
  collisions();
  show();
  messages();
}


//// HANDLERS:  keys, click
void keyPressed() {
  if (key == 'q') { exit();  }
    //++++ ADD YOUR OWN CODE HERE. ++++
}


//// SCENE:  draw the table with wall down the middle
void table( float east, float north, float west, float south ) {
  fill( tableRed, tableGreen, tableBlue );    // pool table
  strokeWeight(20);
  stroke( 127, 0, 0 );      // Brown walls
  rect( east-20, north-20, west+20, south+20 );

            //++++ MODIFY THIS CODE, as necessary. ++++

  // Start with a WALL down the middle of the table! 
  if (wall) {
    float middle=  (east+west)/2;    
    stroke( 0, 127, 0 );
    line( middle,north+10, middle,south-10 );
  }
  stroke(0);
  strokeWeight(1);
}

//// ACTION:  bounce off walls, collisions
void bounce() {
    //// ADD YOUR OWN CODE HERE. ++++
}
void collisions() {
    //// ADD YOUR OWN CODE HERE. ++++
}


//// SHOW:  balls, messages, etc.
void show() {
    //++++ ADD YOUR OWN CODE HERE. ++++
}
void buttons() {
    //++++ ADD YOUR OWN CODE HERE. ++++
}
void messages() {
  fill(0);
  text( title, width/3, 15 );
  text( news, width/9, 30 );
  text( author, 10, height-5 );

  // Also, display the number of collisions.

    //++++ ADD YOUR OWN CODE HERE. ++++

}
