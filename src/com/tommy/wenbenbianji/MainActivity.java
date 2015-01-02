package com.tommy.wenbenbianji;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.io.*;

public class MainActivity extends Activity
{
	EditText content,path;
	
	@Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		content=(EditText)findViewById(R.id.content);
		path=(EditText)findViewById(R.id.path);
    }
	
	public void open(View v){
		String strpath=path.getText().toString();
		if(!strpath.equals("")){
			try
			{
				BufferedReader reader=new BufferedReader(new FileReader(strpath));
				String strcontent="",line;
				while((line=reader.readLine())!=null)
					strcontent+=line;
				content.setText(strcontent);
				Toast.makeText(this,"打开成功",0).show();
			}
			catch (IOException e)
			{Toast.makeText(this,e+"",0).show();}
		}
	}
	public void save(View v){
		String strcontent=content.getText().toString();
		if(!strcontent.equals("")){
			try
			{
				FileWriter writer=new FileWriter(path.getText().toString());
				writer.write(strcontent);
				Toast.makeText(this,"保存成功",0).show();
			}
			catch (IOException e)
			{Toast.makeText(this,e+"",0).show();}
		}
	}
}
