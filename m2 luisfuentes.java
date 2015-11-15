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
    
    String title=  "CST112 MIDTERM EXAM"                  ;
    String news=   "Click any ball to reset it to right half of table.  (r resets all.)";
    String author=  "Luis Fuentes"                        ;
    float left, right, top, bottom                        ;
    float middle                                          ;
    float luiX, luiY, luiDX, luiDY                        ;
    float angX, angY, angDX, angDY                        ;
    float fueX, fueY, fueDX, fueDY                        ;
    int tableRed=150, tableGreen=250, tableBlue=150       ;
    boolean wall=true                                     ;
    boolean mouse=false                                   ;  
    float miceX, miceY, miceDX                            ;
    int frame                                             ;
    float rX, rY, rW, rH                                  ;
    int score=0,m=0,k=0                                   ;
    
    //// SETUP
    void setup()
    {
      rX=50                                ;
      rY=25                                ;
      rW=150                               ;
      rH=50                                ;
      size( 700, 500 )                     ;
      left=   70                           ;
      right=  width-70                     ;
      top=  100                            ;
      bottom= height-70                    ;
      middle= left + (right-left) / 2      ;
      reset()                              ;
    }
    void reset() {
    
      // Random positions. (balls and mouse position)
      luiX=  right        ;
      luiY=  bottom       ;
      angX=right          ;   
      angY= top           ;
      fueX=  right        ;   
      fueY=  middle-100   ;
      miceX= width-500;               
      miceY=  450;
    
      // Random speeds for ball and mouse
      angDX=  random( 1, 4 )    ;   
      angDY=  random( 1, 1.5 )  ;
      fueDX=  random(2, 3.4 )   ;   
      fueDY=  random( -0.1, 1 ) ;
    
    
      luiDX=  random( 2, 5 )    ;   
      luiDY=  random( 1, 2.1)    ;
      miceDX= -1                 ;
    }
    
    //// NEXT FRAME:  table, bounce off walls, collisions, show all
    void draw() {
       background( 150, 150, 100 )        ;
       rectMode( CORNERS )                ;
       table( left, top, right, bottom )    ;
       bounce()                  ;
       collisions();
       show();
       messages();
       Buttons();
       mouseDraw();
    }
      void Buttons()
      {
        textSize(15);
        fill(100, 150, 175);
        rect(rX, rY, rW, rH+5);
        fill(15);
        text("reset", 75, 45);                                //reset button
        fill(150,100,100);
        rectMode(CORNER);
        rect(rX+110, rY, rW-30, rH-20);
        fill(255);
        text("table pink", 180, 45);                          //make table pink
        fill(10, 150, 100);                
        rect(rX+250, rY, rW-20, rH-20);
        fill(15);
        text("don't show wall" , rX+260, rY+20);              //dont show wall
        fill(100, 100, 100);
        rect(rX+400, rY, rW-20, rH-20);
        fill(250);
        text("show mouse", rX+415, rY+20);                    // show mouse
  }
    
    void mouseDraw(){                                    //code for mouse
  if (mouse){                                            //only display mouse if true
      fill(138,138,138);
      ellipse(miceX, miceY,30,20);
     
      miceX += miceDX;
      frame = frame + 1;
  if ( miceX<left || miceX>right ) miceDX *= -1;      //animation code for mouse legs

    if (miceDX == -1){
  
     if(frame/30 % 2 == 0){
       ellipse(miceX-17, miceY+5,15,10);                 //head
       ellipse(miceX-17, miceY+5,2,2);                   //eye
       ellipse(miceX+23, miceY,15,5);                    //tail
       ellipse(miceX-26, miceY+5,5,4);                   //nose
       line(miceX+15,miceY+4,miceX+25,miceY+14);         //LEG
       line(miceX-10,miceY+8,miceX-25,miceY+20);         //LEG
     }else{
       ellipse(miceX-17, miceY+5,15,10);                 //head
       ellipse(miceX-17, miceY+5,2,2);                   //eye
       ellipse(miceX+23, miceY,15,5);                    //tail
       ellipse(miceX-26, miceY+5,5,4);                   //nose
       line(miceX+15,miceY+4,miceX+25,miceY+21);         // LEG
       line(miceX-10,miceY+8,miceX-20,miceY+21);         //LEG
     }
   }else if (miceDX == 1){
      if(frame/30 % 2 == 0){
      ellipse(miceX+17, miceY+5,15,10);                  //head
      ellipse(miceX+17, miceY+5,2,2);                    //eye
      ellipse(miceX-23, miceY,15,5);                     //tail
      ellipse(miceX+26, miceY+5,5,4);                    //nose
      line(miceX-15,miceY+4,miceX-25,miceY+14);          //LEG
      line(miceX+10,miceY+8,miceX+20,miceY+21);          //LEG
      
   }else{
       ellipse(miceX+17, miceY+5,15,10);                 //head
       ellipse(miceX+17, miceY+5,2,2);                   //eye
       ellipse(miceX+26, miceY+5,5,4);                   //nose
       ellipse(miceX-23, miceY,15,5);                    //tail
       line(miceX+10,miceY+8,miceX+15,miceY+25);         //LEG
       line(miceX-15,miceY+4,miceX-25,miceY+21);         //LEG
           }
        }
     }
 }
    
    //// SCENE:  draw the table with walls
    void table( float left, float top, float right, float bottom ) {
        fill( tableRed, tableGreen, tableBlue );          // green pool table
        strokeWeight(20);
        stroke( 127, 0, 0 );                              // Brown walls
        rect( left-20, top-20, right+20, bottom+20 );
    
    
      if (wall) {
        float middle=  (left+right)/2;    
        stroke( 0, 127, 0 );
        line( middle, top, middle, bottom );
        stroke(0);
        strokeWeight(1);
      }
    }
    
    //// ACTION:  bounce off walls, collisions
    void bounce() {
      if (wall) {
          angX += angDX;  
        if ( angX<middle+23 || angX>right ) angDX *= -1;
          angY += angDY;  
        if ( angY<top || angY>bottom ) angDY *= -1;
          luiX += luiDX;  
        if ( luiX<middle+23 || luiX>right ) luiDX *= -1;
          luiY += luiDY;  
        if ( luiY<top || luiY>bottom ) luiDY *= -1;
          fueX += fueDX;  
        if ( fueX<middle+23 || fueX>right ) fueDX *= -1;
          fueY += fueDY;  
        if ( fueY<top || fueY>bottom ) fueDY *= -1;
      } else {
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
    }
    /*void collisions() {
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
    */
    
    //// SHOW:  balls, messages
    void show() {
      stroke(0);
      strokeWeight(1);
      fill( 255, 255, 255 );    
      ellipse( angX, angY, 30, 30 );
      fill( 255, 0, 0 );    
      ellipse( angX, angY, 30, 30 );
      fill( 255, 255, 0 );  
      ellipse( fueX, fueY, 30, 30 );
    
      fill( 255, 255, 255 );    
      ellipse( luiX, luiY, 30, 30 );
    }
    
    void collisions() {


  float tmp;


 if ( dist( luiX,luiY, angX,angY ) < 30 ) {         //ang and lui


   tmp=angDX;  angDX=luiDX;  luiDX=tmp;


   tmp=angDY;  angDY=luiDY;  luiDY=tmp;


   k +=1;


 }


 if ( dist( fueX,fueY, angX,angY ) < 30 ) {         //ang and fue


   tmp=angDX;  angDX=fueDX;  fueDX=tmp;


   tmp=angDY;  angDY=fueDY;  fueDY=tmp;


   k +=1;


 }


 if ( dist( luiX,luiY, fueX,fueY ) < 30 ) {         //fue and lui


   tmp=fueDX;  fueDX=luiDX;  luiDX=tmp;


   tmp=fueDY;  fueDY=luiDY;  luiDY=tmp;
   k +=1;


 }

}
    void messages() {
      fill(0);
      text( title, width/3, 20 );
      text( news, width/9, 70 );
      text( author, 10, height-10 );
      text("1", angX-5, angY+5);
      text("2", luiX-5, luiY+5);
      text("3", fueX-5, fueY+5); 
      fill(20,230,250);
      text("Collisions", 130, height-10 );
      text(k,  210, height-10 );
    }
    
    void tablePink() {
      tableRed= 200;
      tableGreen=100;
      tableBlue=100;
    }
    //reset key
    void keyPressed() {
      if (key == 'm') {mouse = true;}
      if (key == 'r')
      {
        reset();                         // press 'q' key to QUIT.
      }
    }
    //reset  TABLE 3 
    void mousePressed() {
      if (mouseX>rX && mouseX<rX+(rW-50) && mouseY>rY&&mouseY<rY+(rH-20))        ////  reset
  {
        tableRed=150; tableGreen=250; tableBlue=150;
        wall=true;
        reset();
        mouse=false;
  }
      if (mouseX>(rX+110)&& mouseX<(rX+110)+rW && mouseY>rY&&mouseY<rY+(rH-20))    //table pink
  {
        tablePink();
  }

      if (mouseX>rX+250 && mouseX<(rX+250)+(rW-20) && mouseY>rY&&mouseY<rY+(rH-20))   //dont shpw wall
  {
        wall=false;
   }
     
     
     if (mouseX>rX+400 && mouseX<(rX+400)+(rW-20) && mouseY>rY&&mouseY<rY+(rH-20))     //show mouse
  {
        mouse = true;
  }
      if (mouseX>luiX-15 && mouseX < luiX+15 && mouseY > luiY-15 && mouseY<luiY+15)
  {
        luiX=  right;
        luiY=  bottom;
  }
      if (mouseX>fueX-15 && mouseX < fueX+15 && mouseY > fueY-15 && mouseY<fueY+15)
  {
        fueX=  right;   
        fueY=  middle-100;
  }
      if (mouseX>angX-15 && mouseX < angX+15 && mouseY > angY-15 && mouseY<angY+15)
  {
        angX=right-100;   
        angY= top;

    }

}
    
