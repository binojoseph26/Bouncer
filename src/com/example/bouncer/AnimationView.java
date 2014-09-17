package com.example.bouncer;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Paint;
import android.graphics.Color;
import android.graphics.Canvas;

public class AnimationView extends View 
{
	private final int FRAME_RATE=15;
	private Paint paint;
	private Handler h;
	Ball myball;
	Ball greenBall;
	Ball redBall;
	
	private Runnable r=new Runnable(){
		public void run()
		{
			invalidate();
		}
	};
	public AnimationView(Context context,AttributeSet attrs)
	{
		super(context,attrs);
		
		h=new Handler();
		paint=new Paint();
		paint.setColor(Color.BLUE);
		myball=new Ball(100,100,Color.BLUE,50);
		greenBall=new Ball(200,200,Color.GREEN,25);
		redBall=new Ball(50,400,Color.RED,75);
		
		myball.setDX(10);
		myball.setDY(10);
		
		greenBall.setDX(-20);
		greenBall.setDY(-15);
		redBall.setDX(5);
		redBall.setDY(-5);
	}
	protected void onDraw(Canvas c)
	{
		myball.bounce(c);
		greenBall.bounce(c);
		redBall.bounce(c);
		
		c.drawCircle(myball.getX(),myball.getY(),myball.getRadius(),myball.getPaint());
		
		c.drawCircle(greenBall.getX(),greenBall.getY(),greenBall.getRadius(),greenBall.getPaint());
		
		c.drawCircle(redBall.getX(),redBall.getY(),redBall.getRadius(),redBall.getPaint());
		
		h.postDelayed(r,FRAME_RATE);
	}
	
}
