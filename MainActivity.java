package com.createai.studio;

import android.app.*;
import android.os.Bundle;
import android.graphics.Color;
import android.view.*;
import android.widget.*;
import android.content.Context;

public class MainActivity extends Activity {
  String selected = "Generate Image";
  @Override public void onCreate(Bundle b){
    super.onCreate(b); setContentView(R.layout.activity_main);
    GridLayout grid=findViewById(R.id.modeGrid);
    String[] modes={"🖼️ Image","🎬 Video","🔄 Image → Video","👤 Character","🎤 Voice","🗂️ Gallery"};
    for(String m:modes){
      Button x=new Button(this); x.setText(m); x.setTextColor(Color.WHITE); x.setAllCaps(false);
      x.setOnClickListener(v->{ selected=m; Toast.makeText(this,m+" selected",Toast.LENGTH_SHORT).show();});
      GridLayout.LayoutParams lp=new GridLayout.LayoutParams();
      lp.width=0; lp.height=60; lp.columnSpec=GridLayout.spec(GridLayout.UNDEFINED,1f);
      lp.setMargins(4,4,4,4); x.setLayoutParams(lp); grid.addView(x);
    }
    findViewById(R.id.generate).setOnClickListener(v->{
      EditText p=findViewById(R.id.prompt);
      if(p.getText().toString().trim().isEmpty()){
        Toast.makeText(this,"Enter a prompt first.",Toast.LENGTH_SHORT).show();
      } else {
        Toast.makeText(this,"Request ready for AI backend: "+selected,Toast.LENGTH_LONG).show();
      }
    });
  }
}
