package com.example.book;


import com.example.book.utils.text_evalution;

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

public class evalution extends Activity {
	//1.����xml�ļ��еĿؼ��ı���
	    private EditText error_date;
	    private EditText error_time ;
		private Button bt1;
		private Spinner spnPrefer1;
		private Spinner spnPrefer2;
		private Spinner spnPrefer3;
		private Spinner spnPrefer4;
	    private TextView textViewRegister;
	   String[] type=new String[]{"ѡ����","�����","Ӧ����","�ʴ���","�ۺ���"};
	    String[] section=new String[]{"��һ��","�ڶ���","������","������","������","������","������"};
	    String[] reason=new String[]{"������","д����","��ѧ֪ʶ������","δ���յ���˼·","ȱ���κ󹮹���ϰ","�����������","����˼·����"};
	    String[] point=new String[]{"��������","������","�����ļ�ֵ","�ֲ�����ַ�","�󶨻���","��η��̵����"};
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	 // TODO Auto-generated method stub
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.review_content);
    // mySQLite = new MySQLite(this, "managedb", 1);
    
     bt1=(Button)findViewById(R.id.rigs_start);
     bt1.setOnClickListener(start);
     error_date=(EditText) findViewById(R.id.radio_year);
     error_time=(EditText) findViewById(R.id.radio_date);
     spnPrefer2=(Spinner)findViewById(R.id.Spinnerfourteen);
	 spnPrefer1=(Spinner)findViewById(R.id.Spinnerthirty);
	 spnPrefer3=(Spinner)findViewById(R.id.Spinnerfifteen);
	 spnPrefer4=(Spinner)findViewById(R.id.Spinnersixteen);
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
	// 2.ͨ��findViewById�ķ�����ȡ�ؼ����
	 //bt1 = (Button) findViewById(R.id.btn_ok);
     //textViewRegister = (TextView) findViewById(R.id.Text_ordername);
	
		// 3.Ϊbutton�������click�¼��ļ���������ʱִ�ж��巽��
        /*bt1.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				String year=error_date.getText().toString();
				String timestr=error_time.getText().toString();
				Log.i("TAG",year+"_"+timestr);
				text_evalution uService=new text_evalution(evalution.this);
				boolean flag=uService.select(year,timestr );
				if(flag){
					//jumpToMenu();
					Intent intent=new Intent(evalution.this,start.class);
					startActivity(intent);
				}else{
					Log.i("TAG","��ϰʧ��");
					Toast.makeText(evalution.this, "��ѯʧ��", Toast.LENGTH_LONG).show();
				}
			}
		});*/
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


