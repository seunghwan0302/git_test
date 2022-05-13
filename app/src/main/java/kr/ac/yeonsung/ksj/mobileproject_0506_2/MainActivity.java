package kr.ac.yeonsung.ksj.mobileproject_0506_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button plus_btn, minus_btn, multi_btn, div_btn;
    TextView result_text;
    String num1, num2;
    Integer result;
    int [] btnNumId = {R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,
            R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9};
    Button [] btnNum = new Button[btnNumId.length];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        result_text = findViewById(R.id.result_text);
        plus_btn = findViewById(R.id.plus_btn);
        minus_btn = findViewById(R.id.minus_btn);
        multi_btn = findViewById(R.id.multi_btn);
        div_btn = findViewById(R.id.div_btn);
        plus_btn.setOnClickListener(btnListener);
        minus_btn.setOnClickListener(btnListener);
        multi_btn.setOnClickListener(btnListener);
        div_btn.setOnClickListener(btnListener);
        for(int i=0; i < btnNum.length; i++){
            final int index = i;
            btnNum[i] = findViewById(btnNumId[i]);
            btnNum[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String num = "";
                    if(edit1.isFocused()){
                        num = edit1.getText().toString() + btnNum[index].getText();
                        edit1.setText(num);
                    }else if(edit2.isFocused()){
                        num = edit2.getText().toString() + btnNum[index].getText();
                        edit2.setText(num);
                    }
                }
            });
        }


    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            switch(view.getId()){
                case R.id.plus_btn:
                    result = Integer.parseInt(num1) + Integer.parseInt(num2);
                    result_text.setText("계산 결과 : "+result);
                    break;
                case R.id.minus_btn:
                    result = Integer.parseInt(num1) - Integer.parseInt(num2);
                    result_text.setText("계산 결과 : "+result);
                    break;
                case R.id.multi_btn:
                    result = Integer.parseInt(num1) * Integer.parseInt(num2);
                    result_text.setText("계산 결과 : "+result);
                    break;
                case R.id.div_btn:
                    result = Integer.parseInt(num1) / Integer.parseInt(num2);
                    result_text.setText("계산 결과 : "+result);
                    break;
            }

        }
    };
}