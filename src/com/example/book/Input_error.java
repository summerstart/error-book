package com.example.book;
  
import java.sql.Date;  
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Calendar;  
import java.util.Locale;  

import com.example.book.Input_error1;
import com.example.book.MainActivity;
import com.example.book.user.In_error;
import com.example.book.user.In_error;
import com.example.book.utils.error_service;
  
import android.os.Bundle;  
import android.app.Activity;  
import android.app.DatePickerDialog;  
import android.app.TimePickerDialog;  
import android.content.Intent;
import android.util.Log;  
import android.view.Menu;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;  
import android.widget.DatePicker;  
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;  
import android.widget.TimePicker;  
import android.widget.Toast;
  
public class Input_error extends Activity {  
	public String date;
	public String time;
	private Button btnDO;
	private Spinner spnPrefer;
	//private TextView txtResult;
	private Spinner spnPreferspots;
	private Spinner spnPreferreason;
	private Spinner spnPreferknowledge;
	//private TextView textResult;
	String[] types=new String[]{"�����","ѡ����","Ӧ����","�ʴ���","�ۺ���"};
    String[] spots=new String[]{"��һ��","�ڶ���","������","������","������","������","������"};
    String[] reason=new String[]{"������","д����","��ѧ֪ʶ������","δ���յ���˼·","ȱ���κ󹮹���ϰ","�����������","����˼·����"};
    String[] knowledge=new String[]{"��������","������","�����ļ�ֵ","��������ַ�","�󶨻���","��η��̵����"}; 
	private Spinner Section;
	private Spinner Reason;	
	private Spinner Knowledge; 
	private Spinner Type;
	Button  bt_ok;
   private final static String TAG="TimeDate";  
       //��ȡ���ڸ�ʽ������  
    DateFormat fmtDate = new java.text.SimpleDateFormat("yyyy-MM-dd");  
      
    DateFormat fmtTime = new java.text.SimpleDateFormat("HH:mm:ss");  
      
    //����һ��TextView�ؼ�����  
    TextView txtDate = null;  
    TextView txtTime = null;  
    //��ȡһ����������  
    Calendar dateAndTime = Calendar.getInstance(Locale.CHINA);  
      
      
    //�����DatePickerDialog�ؼ������ð�ťʱ�����ø÷���  
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener()  
    {  
        @Override  
        public void onDateSet(DatePicker view, int year, int monthOfYear,  
                int dayOfMonth) {  
            //�޸������ؼ����꣬�£���  
            //�����year,monthOfYear,dayOfMonth��ֵ��DatePickerDialog�ؼ����õ�����ֵһ��  
            dateAndTime.set(Calendar.YEAR, year);  
            dateAndTime.set(Calendar.MONTH, monthOfYear);  
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);      
            //��ҳ��TextView����ʾ����Ϊ����ʱ��  
            upDateDate();     
              
        }          
    };  
      
    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {  
          
        //ͬDatePickerDialog�ؼ�  
        @Override  
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {  
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);  
            dateAndTime.set(Calendar.MINUTE, minute);  
            upDateTime();  
              
        }  
    };   
      
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.input_error);  
        
        
        Type=(Spinner) findViewById(R.id.SpinnerNine);
        Section=(Spinner) findViewById(R.id.SpinnerTen);
        Reason=(Spinner) findViewById(R.id.SpinnerEleven);
        Knowledge=(Spinner) findViewById(R.id.SpinnerTwelve);
        bt_ok=(Button) findViewById(R.id.Text_True);
      
        txtDate=(TextView) findViewById(R.id.Text_Date);
        txtTime=(TextView) findViewById(R.id.Text_Time);
        
    	btnDO=(Button)findViewById(R.id.Text_True);
    	 btnDO.setOnClickListener(new OnClickListener() {
 			
 			@Override
 			public void onClick(View arg0) {
 				// TODO Auto-generated method stub
 				//btndo�������¼�����Щ�Ϳ�����
 				
 				  findViews();
 					bt_ok.setOnClickListener(new OnClickListener() {
 						public void onClick(View v) {
 							//String date=Date.getText().toString().trim();
 							//String time=Time.getText().toString().trim();
 							String type=(Type).getSelectedItem().toString().trim();
 							String section=Section.getSelectedItem().toString().trim();
 							String reason=Reason.getSelectedItem().toString().trim();
 							String knowledge=Knowledge.getSelectedItem().toString().trim();
 							Log.i("TAG",type+"_"+section+"_"+reason+"_"+knowledge+"_");
 							error_service eService=new error_service(Input_error.this);
 							In_error error=new In_error();
 							//error.setDate(date);
 							//error.setTime(time);
 							error.setSection(section);
 							error.setReason(reason);
 							error.setType(type);
 							error.setKnowledge(knowledge);
 							error.setDate(txtDate.getText().toString());
 							error.setTime(txtTime.getText().toString());
 							eService.entering(error);
 							System.out.print("rrrrrr");
 							Toast.makeText(Input_error.this, "����ɹ�", Toast.LENGTH_LONG).show();
 							Intent intent=new Intent();
 		 					intent.setClass(Input_error.this,Input_error1.class);
 		 				    startActivity(intent);
 						}
 					});
 				}
 			});
    	spnPrefer=(Spinner)findViewById(R.id.SpinnerNine);
    	spnPreferspots=(Spinner)findViewById(R.id.SpinnerTen);
    	spnPreferreason=(Spinner)findViewById(R.id.SpinnerEleven);
    	spnPreferknowledge=(Spinner)findViewById(R.id.SpinnerTwelve);
    	 //txtResult=(TextView)findViewById(R.id.Txt_type);
    		// ����ArrayAdapter
 		ArrayAdapter<String> adaptertypes = new ArrayAdapter<String>(this,
 				android.R.layout.simple_spinner_item,types);
 		adaptertypes
		      .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 		ArrayAdapter<String> adapterspots = new ArrayAdapter<String>(this,
 				android.R.layout.simple_spinner_item, spots);
 		adapterspots
		     .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 		ArrayAdapter<String> adapterreasons = new ArrayAdapter<String>(this,
 				android.R.layout.simple_spinner_item, reason);
 		adapterreasons
		     .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 		ArrayAdapter<String> adapterknowledge = new ArrayAdapter<String>(this,
 				android.R.layout.simple_spinner_item, knowledge);
 		adapterknowledge
		     .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       //����Spinner������Դ
        spnPrefer.setAdapter(adaptertypes);
        spnPreferspots.setAdapter(adapterspots);
        spnPreferreason.setAdapter(adapterreasons);
        spnPreferknowledge.setAdapter(adapterknowledge);
          // ����listener�¼�
        spnPrefer.setOnItemSelectedListener(spnPreferenceListener);	
        spnPreferspots.setOnItemSelectedListener(spnPreferencespotsListener);
        spnPreferreason.setOnItemSelectedListener(spnPreferencereasonListener);
        spnPreferknowledge.setOnItemSelectedListener(spnPreferenceknowledgeListener);
    			
        Log.d(TAG,"onCreate");  
        txtDate =(TextView)findViewById(R.id.Text_Date);  
        txtDate.setClickable(true);    
        txtDate.setFocusable(true);  
        txtTime =(TextView)findViewById(R.id.Text_Time);  
        txtTime.setClickable(true);    
        txtTime.setFocusable(true);  
          
        txtDate.setOnClickListener(new OnClickListener(){    
                @Override    
                public void onClick(View v){    
                    Log.d(TAG,"txtDate click start");    
                    DatePickerDialog  dateDlg = new DatePickerDialog(Input_error.this,  
                            d,  
                            dateAndTime.get(Calendar.YEAR),  
                            dateAndTime.get(Calendar.MONTH),  
                            dateAndTime.get(Calendar.DAY_OF_MONTH));  
                   
                    dateDlg.show();  
                      
                    Log.d(TAG,"Date show");  
             }  
           });  
          
        txtTime.setOnClickListener(new OnClickListener(){    
            @Override    
            public void onClick(View v){    
                Log.d(TAG,"txtTime click start");   
                Log.d(TAG,"Date show");  
                TimePickerDialog timeDlg = new TimePickerDialog(Input_error.this,  
                        t,  
                        dateAndTime.get(Calendar.HOUR_OF_DAY),  
                        dateAndTime.get(Calendar.MINUTE),  
                        true);  
                timeDlg.show();  
         }  
       });  
          
        upDateDate();  
        upDateTime();  
    }  
	private void findViews() {
		TextView Date;
		TextView Time;
		TextView Section;
		TextView Reason;	
		TextView Knowledge;
		TextView Type;
		Button  bt_ok;
		Date=(TextView) findViewById(R.id.Text_Date);
		Time=(TextView) findViewById(R.id.Text_Time);
		Section=(TextView) findViewById(R.id.Text_Section);
		Reason=(TextView) findViewById(R.id.Text_Reason);
		Knowledge=(TextView) findViewById(R.id.Text_Knowledge);
		Type=(TextView) findViewById(R.id.Txt_type);
		bt_ok=(Button) findViewById(R.id.Text_True);
	}
    private Button.OnClickListener Input_error1 = new Button.OnClickListener(){
    	
		public void onClick(View v){
	/*	  Log.i("xxxxx", "�ҵ���ѽ");
		            findViews();		
					//String date=Date.getText().toString().trim();
					//String time=Time.getText().toString().trim();
					String type=(Type).getSelectedItem().toString().trim();
					String section=Section.getSelectedItem().toString().trim();
					String reason=Reason.getSelectedItem().toString().trim();
					String knowledge=Knowledge.getSelectedItem().toString().trim();
					Log.i("TAG",type+"_"+section+"_"+reason+"_"+knowledge+"_");
					error_service eService=new error_service(Input_error.this);
					In_error error=new In_error();
					//error.setDate(date);
					//error.setTime(time);
					error.setSection(section);
					error.setReason(reason);
					error.setType(type);
					error.setKnowledge(knowledge);
					error.setDate(txtDate.getText().toString());
					error.setTime(txtTime.getText().toString());
					eService.entering(error);
					System.out.print("rrrrrr");
					Toast.makeText(Input_error.this, "����ɹ�", Toast.LENGTH_LONG).show();
				
			
			Intent intent=new Intent();
			intent.setClass(Input_error.this,Input_error1.class);
			startActivity(intent);
			//MainActivity.this.finish();
*/		}
		
	};
	private Spinner.OnItemSelectedListener spnPreferencespotsListener = new Spinner.OnItemSelectedListener() {
		
		 //����Spinner�ļ����¼�����
		
		@Override
		public void onItemSelected(AdapterView<?> parent, View v, int position,
				long id) {
			//������ѡ��Ķ�Ӧ�½���Ϣ
			String sel=parent.getSelectedItem().toString();
		}
		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
		}
	};
	private Spinner.OnItemSelectedListener spnPreferenceListener = new Spinner.OnItemSelectedListener() {
		
		 //����Spinner�ļ����¼�����
		
		@Override
		public void onItemSelected(AdapterView<?> parent, View v, int position,
				long id) {
			//������ѡ�����Ŀ������Ϣ
			String sel=parent.getSelectedItem().toString();
			//txtResult.setText(sel);
		/*	Toast.makeText(MainActivity.this, types[position], 0).show();
			sel = types[position];
			System.out.println("------>"+sel);*/
		}
		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
		}
	}; 
	private Spinner.OnItemSelectedListener spnPreferencereasonListener = new Spinner.OnItemSelectedListener() {
		
		 //����Spinner�ļ����¼�����
		
		@Override
		public void onItemSelected(AdapterView<?> parent, View v, int position,
				long id) {
			//������ѡ��Ķ�Ӧ�½���Ϣ
			String sel=parent.getSelectedItem().toString();
		}
		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
		}
	};
	private Spinner.OnItemSelectedListener spnPreferenceknowledgeListener = new Spinner.OnItemSelectedListener() {
		
		 //����Spinner�ļ����¼�����
		
		@Override
		public void onItemSelected(AdapterView<?> parent, View v, int position,
				long id) {
			//������ѡ��Ķ�Ӧ�½���Ϣ
			String sel=parent.getSelectedItem().toString();
		}
		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
		}
	};
    private void upDateDate() {  
        txtDate.setText(fmtDate.format(dateAndTime.getTime()));
         date=txtDate.getText().toString();
        }  
     
    private void upDateTime() {  
        txtTime.setText(fmtTime.format(dateAndTime.getTime())); 
        time=txtTime.getText().toString();
        }  
  
  
    @Override  
   public boolean onCreateOptionsMenu(Menu menu) {  
        // Inflate the menu; this adds items to the action bar if it is present.  
        getMenuInflater().inflate(R.menu.main, menu);  
        return true;  
    } 
  
} 