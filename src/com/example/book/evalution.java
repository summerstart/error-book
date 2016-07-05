package com.example.book;


import com.example.book.utils.text_evalution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.book.user.Cuoti;
import com.example.book.user.In_error;
import com.example.book.utils.Text_error;
import com.example.book.utils.UserService;
import com.example.book.utils.error_service;
import android.app.Activity;
import android.content.Intent;
import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class evalution extends  Activity implements OnClickListener {
	//1.����xml�ļ��еĿؼ��ı���
	    private EditText error_date;
	    private EditText error_time ;
		private Button bt1;
		private Button rigs_start;
		private Spinner spnPrefer1;
		private Spinner spnPrefer2;
		private Spinner spnPrefer3;
		private Spinner spnPrefer4;
	    private TextView textViewRegister;
	    private SimpleAdapter sa;
	    private SQLiteDatabase db = null;
	   private List list=null;
	   private ListView listt;
	   String[] type=new String[]{"ѡ����","�����","Ӧ����","�ʴ���","�ۺ���"};
	    String[] section=new String[]{"��һ��","�ڶ���","������","������","������","������","������"};
	    String[] reason=new String[]{"������","д����","��ѧ֪ʶ������","δ���յ���˼·","ȱ���κ󹮹���ϰ","�����������","����˼·����"};
	    String[] point=new String[]{"��������","������","�����ļ�ֵ","�ֲ�����ַ�","�󶨻���","��η��̵����"};
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	 // TODO Auto-generated method stub
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.review_content);
    
//	 listt=(ListView) findViewById(R.id.list);
	 
     bt1=(Button)findViewById(R.id.rigs_start);
     bt1.setOnClickListener(start);
     error_date=(EditText) findViewById(R.id.radio_year);
     error_time=(EditText) findViewById(R.id.radio_date);
     spnPrefer2=(Spinner)findViewById(R.id.Spinnerfourteen);
	 spnPrefer1=(Spinner)findViewById(R.id.Spinnerthirty);
	 spnPrefer3=(Spinner)findViewById(R.id.Spinnerfifteen);
	 spnPrefer4=(Spinner)findViewById(R.id.Spinnersixteen);
	 
	 rigs_start=(Button) findViewById(R.id.rigs_start);
	 rigs_start.setOnClickListener(this);
	   Text_error myHelper = new Text_error(evalution.this);
		db = myHelper.getWritableDatabase();
	// ����ArrayAdapter
			ArrayAdapter<String> adaptertype = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, type);
		  ArrayAdapter<String> adaptersection = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, section);
		  ArrayAdapter<String> adapterreason = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, reason);
		  ArrayAdapter<String> adapterpoint = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, point);
			// ����Spinner���Ǹ�ʽ
			adaptertype
					.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			adaptersection
		         .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			adapterreason
			.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	       adapterpoint
             .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			// ����Spinner������Դ
			spnPrefer1.setAdapter(adaptertype);
			spnPrefer2.setAdapter(adaptersection);
			spnPrefer3.setAdapter(adapterreason);
			spnPrefer4.setAdapter(adapterpoint);
			// ����listener�¼�
			spnPrefer1.setOnItemSelectedListener(spnPrefer1Listener);
			spnPrefer2.setOnItemSelectedListener(spnPrefer2Listener);
			spnPrefer3.setOnItemSelectedListener(spnPrefer3Listener);
			spnPrefer4.setOnItemSelectedListener(spnPrefer4Listener);

	}
	
	 
	 public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
				case R.id.rigs_start:
					
					Intent intent = new Intent();
					Cuoti cuoti = new Cuoti();
					cuoti.setType(spnPrefer1.getSelectedItem().toString().trim());
					cuoti.setSection(spnPrefer2.getSelectedItem().toString().trim());
					cuoti.setReason(spnPrefer3.getSelectedItem().toString().trim());
					cuoti.setPoint(spnPrefer4.getSelectedItem().toString().trim());
					intent.putExtra("cuoti", cuoti);
			
					intent.setClass(evalution.this, start.class);
					startActivity(intent);
			   
				 	break;
			}
}

		// ѡ��֪ʶ��
		private Spinner.OnItemSelectedListener spnPrefer1Listener = new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int position,
					long id) {

				String sel = parent.getSelectedItem().toString();
				// txtResult.setText(sel);
			}
			

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		};
	private Spinner.OnItemSelectedListener spnPrefer2Listener = new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int position,
					long id) {

				String sel = parent.getSelectedItem().toString();
				// txtResult.setText(sel);
			}
			

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		};
		private Spinner.OnItemSelectedListener spnPrefer3Listener = new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int position,
					long id) {

				String sel = parent.getSelectedItem().toString();
				// txtResult.setText(sel);
			}
			

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		};
		private Spinner.OnItemSelectedListener spnPrefer4Listener = new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int position,
					long id) {

				String sel = parent.getSelectedItem().toString();
				// txtResult.setText(sel);
			}
			

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		};

		private Button.OnClickListener start = new Button.OnClickListener(){
			public void onClick(View v){
				Intent intent=new Intent();
				intent.setClass(evalution.this,start.class);
				startActivity(intent);
			}
		};
}


