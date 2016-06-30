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
	String[] types=new String[]{"填空题","选择题","应用题","问答题","综合题"};
    String[] spots=new String[]{"第一章","第二章","第三章","第四章","第五章","第六章","第七章"};
    String[] reason=new String[]{"看错了","写错了","已学知识的遗忘","未掌握典型思路","缺乏课后巩固练习","理解能力不够","解题思路狭隘"};
    String[] knowledge=new String[]{"函数求极限","函数求导","函数的极值","部分求积分法","求定积分","齐次方程的求解"}; 
	private Spinner Section;
	private Spinner Reason;	
	private Spinner Knowledge; 
	private Spinner Type;
	Button  bt_ok;
   private final static String TAG="TimeDate";  
       //获取日期格式器对象  
    DateFormat fmtDate = new java.text.SimpleDateFormat("yyyy-MM-dd");  
      
    DateFormat fmtTime = new java.text.SimpleDateFormat("HH:mm:ss");  
      
    //定义一个TextView控件对象  
    TextView txtDate = null;  
    TextView txtTime = null;  
    //获取一个日历对象  
    Calendar dateAndTime = Calendar.getInstance(Locale.CHINA);  
      
      
    //当点击DatePickerDialog控件的设置按钮时，调用该方法  
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener()  
    {  
        @Override  
        public void onDateSet(DatePicker view, int year, int monthOfYear,  
                int dayOfMonth) {  
            //修改日历控件的年，月，日  
            //这里的year,monthOfYear,dayOfMonth的值与DatePickerDialog控件设置的最新值一致  
            dateAndTime.set(Calendar.YEAR, year);  
            dateAndTime.set(Calendar.MONTH, monthOfYear);  
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);      
            //将页面TextView的显示更新为最新时间  
            upDateDate();     
              
        }          
    };  
      
    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {  
          
        //同DatePickerDialog控件  
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
 				//btndo出发的事件在这些就可以了
 				
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
 							Toast.makeText(Input_error.this, "保存成功", Toast.LENGTH_LONG).show();
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
    		// 创建ArrayAdapter
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
       //设置Spinner的数据源
        spnPrefer.setAdapter(adaptertypes);
        spnPreferspots.setAdapter(adapterspots);
        spnPreferreason.setAdapter(adapterreasons);
        spnPreferknowledge.setAdapter(adapterknowledge);
          // 设置listener事件
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
	/*	  Log.i("xxxxx", "我滴天呀");
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
					Toast.makeText(Input_error.this, "保存成功", Toast.LENGTH_LONG).show();
				
			
			Intent intent=new Intent();
			intent.setClass(Input_error.this,Input_error1.class);
			startActivity(intent);
			//MainActivity.this.finish();
*/		}
		
	};
	private Spinner.OnItemSelectedListener spnPreferencespotsListener = new Spinner.OnItemSelectedListener() {
		
		 //定义Spinner的监听事件函数
		
		@Override
		public void onItemSelected(AdapterView<?> parent, View v, int position,
				long id) {
			//弹出所选择的对应章节信息
			String sel=parent.getSelectedItem().toString();
		}
		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
		}
	};
	private Spinner.OnItemSelectedListener spnPreferenceListener = new Spinner.OnItemSelectedListener() {
		
		 //定义Spinner的监听事件函数
		
		@Override
		public void onItemSelected(AdapterView<?> parent, View v, int position,
				long id) {
			//弹出所选择的题目类型信息
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
		
		 //定义Spinner的监听事件函数
		
		@Override
		public void onItemSelected(AdapterView<?> parent, View v, int position,
				long id) {
			//弹出所选择的对应章节信息
			String sel=parent.getSelectedItem().toString();
		}
		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
		}
	};
	private Spinner.OnItemSelectedListener spnPreferenceknowledgeListener = new Spinner.OnItemSelectedListener() {
		
		 //定义Spinner的监听事件函数
		
		@Override
		public void onItemSelected(AdapterView<?> parent, View v, int position,
				long id) {
			//弹出所选择的对应章节信息
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