package com.WsCube.Drawing;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class DrawingActivity extends Activity  implements OnItemSelectedListener{
	private DrawingView view1,view2;
	String color[]={"color","red","blue","green"};
	String stroke[]={"Stroke","1","2","3","4"};
	String eraser[]={"Eraser","1","2","3","4"};
	//int img[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,R.drawable.o,R.drawable.p,R.drawable.q,R.drawable.r, R.drawable.s,R.drawable.t,R.drawable.v,R.drawable.w,R.drawable.x};
	int img[]={R.drawable.a,R.drawable.b};
	int count=0;
	Spinner sp1,sp2,sp3;
	ArrayAdapter<String> aa,ab,ac;

	SharedPreferences sp;
	SharedPreferences.Editor edt;
/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	
	setContentView(R.layout.main);
	// hide statusbar of Android
		// could also be done later
		this.getSharedPreferences("priyanka", 1);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
	sp1=(Spinner)findViewById(R.id.spinner1);
	aa=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,color);
	aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	sp1.setAdapter(aa);
	
	sp2=(Spinner)findViewById(R.id.spinner2);
	ab=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,stroke);
	ab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	sp2.setAdapter(ab);
	
	sp3=(Spinner)findViewById(R.id.spinner3);
	ac=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,eraser);
	ac.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	sp3.setAdapter(ac);
	
	view1 = (DrawingView) findViewById(R.id.drawingView3);
	view2 = (DrawingView) findViewById(R.id.drawingView4);
	view1.setBackgroundResource(img[count]);
	view2.setBackgroundColor(Color.WHITE);
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
	getMenuInflater().inflate(R.menu.menu, menu);
	return super.onCreateOptionsMenu(menu);
}
public  void pre(View v){
	if (count <= 0)
		{count=(img.length)-1;
		view1.setBackgroundResource(img[count]);
		}
	 
		else 
			{count--;
			view1.setBackgroundResource(img[count]);}	
}
public  void nxt(View v){
	if (count >= img.length)
	{
		count=0;
		view1.setBackgroundResource(img[count]);
		}
	else
		{
		
		view1.setBackgroundResource(img[count]);}
	count++;
}
public  void fb(View v){
	
}
/*
@Override
public boolean onOptionsItemSelected(MenuItem item) {
	switch (item.getItemId()) {
	case R.id.menuItemClear:
		view1.clear();
		break;
	default:
		break;
	}
	return super.onOptionsItemSelected(item);
}*/

@Override
public void onItemSelected(AdapterView parent,View v,int position,long id) {
	// TODO Auto-generated method stub
	
	switch (sp1.getSelectedItemPosition()){
	case 0 :	edt=sp.edit();
		edt.putInt("clr",0);
		edt.commit();
		break;
		
	case 1 :edt=sp.edit();
		edt.putInt("clr",1);
		edt.commit();
		break;
		
	case 2 :edt=sp.edit();
	edt.putInt("clr",2);
	edt.commit();
	break;
	}
	
	switch (sp2.getSelectedItemPosition()){
	case 0 :	edt=sp.edit();
		edt.putFloat("str",3f);
		edt.commit();
		break;
		
	case 1 :edt=sp.edit();
		edt.putFloat("str",5f);
		edt.commit();
		break;
		
	case 2 :edt=sp.edit();
	edt.putFloat("str",7f);
	edt.commit();
	break;
	
	case 3 :edt=sp.edit();
	edt.putFloat("str",9f);
	edt.commit();
	break;
	}
	
	switch (sp3.getSelectedItemPosition()){
	case 0 :	edt=sp.edit();
		edt.putFloat("ers",3f);
		edt.commit();
		break;
		
	case 1 :edt=sp.edit();
		edt.putFloat("ers",5f);
		edt.commit();
		break;
		
	case 2 :edt=sp.edit();
	edt.putFloat("ers",7f);
	edt.commit();
	break;
	
	case 3 :edt=sp.edit();
	edt.putFloat("ers",9f);
	edt.commit();
	break;
	}	
}

@Override
public void onNothingSelected(AdapterView parent) {
	// TODO Auto-generated method stub
	//Toast.makeText("nothing selected", Toast.LENGTH_LONG).show();
}


}

