package com.example.book;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class class_orderactivity extends Activity {
	//1.����xml�ļ��еĿؼ��ı���
		private Button btnDO;
		private Spinner spnPrefer;
	    private TextView textViewRegister;
	    String[] spots=new String[]{"��������","������","�����ļ�ֵ","�ֲ�����ַ�","�󶨻���","��η��̵����"};
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	 // TODO Auto-generated method stub
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.class_order);
	 
	 spnPrefer=(Spinner)findViewById(R.id.SpinnerOne);
	// ����ArrayAdapter
			ArrayAdapter<String> adapterspots = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, spots);
			// ����Spinner���Ǹ�ʽ
			adapterspots
					.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			// ����Spinner������Դ
			spnPrefer.setAdapter(adapterspots);
			// ����listener�¼�
			spnPrefer.setOnItemSelectedListener(spnPreferListener);
	// 2.ͨ��findViewById�ķ�����ȡ�ؼ����
	 btnDO = (Button) findViewById(R.id.btn_ok);
     textViewRegister = (TextView) findViewById(R.id.Text_ordername);
	
		// 3.Ϊbutton�������click�¼��ļ���������ʱִ�ж��巽��
		btnDO.setOnClickListener(btnDoListener);
	 }
		// ѡ��֪ʶ��
		private Spinner.OnItemSelectedListener spnPreferListener = new Spinner.OnItemSelectedListener() {
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
	// ʵ��button�ļ�������
		private Button.OnClickListener btnDoListener = new Button.OnClickListener() {
			public void onClick(View v) {
				
				
				Toast.makeText(getApplicationContext(),
						"��ѡ���½ڣ�", 0).show();
				}
			};

}
