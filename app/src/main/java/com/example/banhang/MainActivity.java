package com.example.banhang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtdapan;
    String input, answer; //input kiểu là giá trị mình nhập vô

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtdapan = (TextView) findViewById(R.id.textviewdapan);

    }
    public void ButtonClick (View view){
        Button btn = (Button) view; // Khai báo
        String data = btn.getText().toString(); // lấy dữ liệu trong btn

        switch (data){
            case "AC":
                input = " ";
                break;
            case "DEL":
                if(input.length() > 0){
                    String newinput = input.substring(0,input.length()-1);
                    input = newinput;
                }
                break;
            case "=":
                Solve();
                answer = input;
                break;
            case "x":
                Solve();
                input+= "*";
                break;
            default:
                if(input == null){
                    input = "";
                }
                if(data.equals("+") || data.equals("-") || data.equals("/")){
                    //in kết quả
                    Solve();
                }
                input+=data; // Kiểu nạp dữ liệu mới vô
        }
        txtdapan.setText(input);
    }

    public void Solve() {
        if(input.split("\\*").length==2){
            String number[] = input.split("\\*");
            try{
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = mul + "";
            }catch (Exception e){

            }
        }
        if(input.split("\\/").length==2){
            String number[] = input.split("\\/");
            try{
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div + "";
            }catch (Exception e){

            }
        }
        if(input.split("\\-").length==2){
            String number[] = input.split("\\-");
            try{
                double sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                input = sub + "";
            }catch (Exception e){

            }
        }
        if(input.split("\\+").length==2){
            String number[] = input.split("\\+");
            try{
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = sum + "";
            }catch (Exception e){

            }
        }
        String n[] = input.split("\\.");
        if(n.length > 1){
            if(n[1].equals("0")){
                input = n[0];
            }
        }
    }
}