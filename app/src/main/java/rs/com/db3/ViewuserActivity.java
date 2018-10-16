package rs.com.db3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ViewuserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewuser);
    }

    public void Viewuser(View view) {

       EditText et= findViewById(R.id.vet1);
     TextView tv1= findViewById(R.id.tv1);
        TextView tv2= findViewById(R.id.tv2);
        TextView tv3= findViewById(R.id.tv3);
        TextView tv4= findViewById(R.id.tv4);

        Mydatabase md=new Mydatabase(this);
        SQLiteDatabase sd=md.getReadableDatabase();

      Cursor c= sd.query("employee_details",null,"ID=?",
                new String[]{et.getText().toString().trim()},null,null,null);

        while (c.moveToNext()){
            String id=c.getString(0);
            String Name=c.getString(1);
            String email=c.getString(2);
            String passwords=c.getString(3);

            tv1.setText(String.valueOf(id));
            tv2.setText(Name);
            tv3.setText(email);
            tv4.setText(passwords);



        }

    }

    public void baccc(View view) {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
