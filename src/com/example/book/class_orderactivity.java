package com.example.book;

import com.example.book.user.In_error;
import com.example.book.utils.error_service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class class_orderactivity extends Activity {
	//1.����xml�ļ��еĿؼ��ı���
		private Button btnDO;
		private Spinner spnPrefer1;
		private Spinner spnPrefer2;
	    private TextView textViewRegister;
	    private EditText errortitle;
	    private Spinner Spots;
	    private Spinner Master;
	   String[] master=new String[]{"��ȫ����","���սϲ�","��������","���սϺ�","��ȫ����"};
	    String[] spots=new String[]{"��������","������","�����ļ�ֵ","�ֲ�����ַ�","�󶨻���","��η��̵����"};
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	 // TODO Auto-generated method stub
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.class_order);
	 findViews();
	 }
	private void findViews() {
			// TODO Auto-generated method stub	
		Spots=(Spinner)findViewById(R.id.SpinnerOne);
		Master=(Spinner)findViewById(R.id.SpinnerTwo);
	 spnPrefer2=(Spinner)findViewById(R.id.SpinnerTwo);
	 spnPrefer1=(Spinner)findViewById(R.id.SpinnerOne);
	 errortitle=(EditText) findViewById(R.id.editText1);
	 btnDO=(Button) findViewById(R.id.btn_ok);
	// ����ArrayAdapter
			ArrayAdapter<String> adapterspots = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, spots);
		  ArrayAdapter<String> adaptermaster = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, master);
			// ����Spinner���Ǹ�ʽ
			adapterspots
					.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			adaptermaster
		         .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			// ����Spinner������Դ
			spnPrefer1.setAdapter(adapterspots);
			spnPrefer2.setAdapter(adaptermaster);
			// ����listener�¼�
			spnPrefer1.setOnItemSelectedListener(spnPrefer1Listener1);
			spnPrefer2.setOnItemSelectedListener(spnPrefer1Listener1);
		// 3.Ϊbutton�������click�¼��ļ���������ʱִ�ж��巽��
	
	btnDO.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			 String spots =(Spots).getSelectedItem().toString().trim();
			 String master =(Master).getSelectedItem().toString().trim();
			 Log.i("TAG",spots+"_"+master);
				error_service uService=new error_service(class_orderactivity.this);
				boolean flag=uService.select(spots, master);
				if(flag){
					//jumpToMenu();	
					//����ѯ�����ʾ��edittext����
					 //String name = select.cursor.getString(cursor.getColumnIndex("�е�����"));
					
					Log.i("TAG","��ѯ�ɹ�");
					Toast.makeText(class_orderactivity.this, "��ѯ�ɹ�", Toast.LENGTH_LONG).show();
					Intent intent=new Intent(class_orderactivity.this,classify.class);
					startActivity(intent);
					//MainActivity.this.finish();
				}else{
					Log.i("TAG","��ѯʧ��");
					Toast.makeText(class_orderactivity.this, "��ѯʧ��", Toast.LENGTH_LONG).show();
				}
		}	
	});	
	}
		
		// ѡ��֪ʶ��
		private Spinner.OnItemSelectedListener spnPrefer1Listener1 = new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int position,
					long id) {
            //String sel = parent.getSelectedItem().toString();
            //����In_error���е����ճ̶�        
			}
						@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),
						"��ѡ���½ڣ�", 0).show();

			}
		};
		private Spinner.OnItemSelectedListener spnPrefer1Listener = new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int position,
					long id) {
				String sel = parent.getSelectedItem().toString();
				
			}			

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),
						"��ѡ�����ͣ�", 0).show();
			}
		};
}