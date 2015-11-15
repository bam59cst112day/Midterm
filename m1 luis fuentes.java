  /******************
midterm code for cst 112
LUIS
ANGEL
FUENTES


WORD

LUI
ANG
FUE


********************************/
    
String title=  "CST112 MIDTERM EXAM";
String news=   "Click any ball to reset it to right half of table.  (r resets all.)";
String author=  "Luis Fuentes";
    
    float left, right, top, bottom;
    float middle;
    

float luiX, luiY, luiDX, luiDY;
float angX, angY, angDX, angDY;
float fueX, fueY, fueDX, fueDY;
boolean wall=true;
    
    float rX, rY, rW, rH;
    
    //// SETUP:  size and table
    void setup()
    { 
      rX=50;
      rY=20;
      rW=150;
      rH=50;
      size( 640, 480 );
      left=   70;
      right=  width-70;
      top=    100;
      bottom= height-70;
      middle= left + (right-left) / 2;
      //
      reset();
    }
    void reset() {
    
      // Random positions.
      luiX=  right; 
      luiY=  bottom;
      angX=right;   
      angY= top;
      fueX=  right;   
      fueY=  middle;


      // Random speeds
      angDX=  random( 0, 1 );   
      angDY=  random( -3, 2 );
      fueDX=  random(- 1, 1.5 );   
      fueDY=  random( -0.1, 1 );


      luiDX=  random( 0.5, 2 );   
      luiDY=  random( 0.1, 2.1);
    }
    
    //// NEXT FRAME:  table, bounce off walls, collisions, show all
    void draw() {
      background( 250, 250, 200 );
      rectMode( CORNERS );
      table( left, top, right, bottom );
      bounce();
      collisions();
      show();
      messages();
      textSize(15);
      fill(100,150,175);
      rect(rX, rY, rW, rH);
      fill(15);
      text("reset", 75, 40);
      fill(100);
      rectMode(CORNER);
      rect(rX+110, rY, rW-30, rH-20);
      fill(255);
      text("table pink",175,40);
    }
      
    
    //// SCENE:  draw the table with walls
    void table( float left, float top, float right, float bottom ) {
      fill( 100, 250, 100 );    // green pool table
      strokeWeight(20);
      stroke( 127, 0, 0 );      // Brown walls
      rect( left-20, top-20, right+20, bottom+20 );
      stroke(0);
      strokeWeight(20);
       if (wall) {
    float middle=  (left+right)/2;    
    stroke( 0, 127, 0 );
    line( middle,top, middle,bottom );
    stroke(0);
    strokeWeight(1);
  }
    }
    
    //// ACTION:  bounce off walls, collisions
    void bounce() {
      angX += angDX;  
      if ( angX<left || angX>right ) angDX *= -1;
      angY += angDY;  
      if ( angY<top || angY>bottom ) angDY *=  -1;
      luiX += luiDX;  
      if ( luiX<left || luiX>right ) luiDX *= -1;
      luiY += luiDY;  
      if ( luiY<top || luiY>bottom ) luiDY *=  -1;
    




      fueX += fueDX;  
      if ( fueX<left || fueX>right ) fueDX *= -1;
      fueY += fueDY;  
      if ( fueY<top || fueY>bottom ) fueDY *=  -1;
    }
    void collisions() {
      float tmp;
      // Swap velocities!
      if ( dist( angX, angY, fueX, fueY ) < 30 ) {
        tmp=fueDX;  
        fueDX=angDX;  
        angDX=tmp;
        tmp=fueDY;  
        fueDY=angDY;  
        angDY=tmp;
      }
     
     
      if ( dist( luiX, luiY, fueX, fueY ) < 30 ) {
        tmp=fueDX;  
        fueDX=luiDX;  
        luiDX=tmp;
        tmp=fueDY;  
        fueDY=luiDY;
      } 
      if ( dist( angX, angY, luiX, luiY ) < 30 ) {
        tmp=luiDX;  
        luiDX=angDX;  
        angDX=tmp;
        tmp=luiDY;  
        luiDY=angDY;  
        angDY=tmp;
      }
    

    }
    
    
    //// SHOW:  balls, messages
    void show() {
      fill( 255, 255, 255 );    
      ellipse( angX, angY, 30, 30 );
      fill( 255, 0, 0 );    
      ellipse( angX, angY, 30, 30 );
      fill( 255, 255, 0 );  
      ellipse( fueX, fueY, 30, 30 );
  
      fill( 255, 255, 255 );    
      ellipse( luiX, luiY, 30, 30 );
      
      }

    void messages() {
      fill(0);
      text( title, width/3, 20 );
      text( news, width/9, 70 );
      text( author, 10, height-10 );
      text("1", angX-5, angY+5);
      text("2", luiX-5, luiY+5);
      text("3", fueX-5, fueY+5);

    }
   
     //reset key 
    void keyPressed() {
  if (key == 'r') 
  {
    reset();                           // press 'q' key to QUIT.
  }
    }
    //reset  TABLE 2 rX+110, rY, rW-30, rH-20
    void mousePressed() {
      if (mouseX>rX && mouseX<rX+(rW-50) && mouseY>rY&&mouseY<rY+(rH-20))
      {
     
        reset();
      }
    if (mouseX>(rX+110)&& mouseX<(rX+110)+rW && mouseY>rY&&mouseY<rY+(rH-20))
      {
        fill(200,0,0);
       
      strokeWeight(20);
      stroke( 127, 0, 0 );      // Brown walls
      rect( left-20, top-20, right-50, bottom-60 );
      stroke(0);
      strokeWeight(1);
      }
    
      if (mouseX>luiX-15 && mouseX < luiX+15 && mouseY > luiY-15 && mouseY<luiY+15)
      {
       reset();
      }
     if (mouseX>fueX-15 && mouseX < fueX+15 && mouseY > fueY-15 && mouseY<fueY+15)
      {
       reset();
      }
       if (mouseX>angX-15 && mouseX < angX+15 && mouseY > angY-15 && mouseY<angY+15)
      {
       reset();
      }
  }





