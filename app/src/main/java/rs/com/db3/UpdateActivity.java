package rs.com.db3;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
    }

    public void updates(View view) {

       EditText et1= findViewById(R.id.uet1);
       EditText et2= findViewById(R.id.uet2);
     EditText et3 = findViewById(R.id.uet3);
   String em= et1.getText().toString().trim();
     String pass=  et2.getText().toString().trim();
     String cpass=et3.getText().toString().trim();


     if (em.isEmpty()) {
         et1.setError("enter email-id");
         et1.requestFocus();
         return;
     }
     if (!Patterns.EMAIL_ADDRESS.matcher(em).matches()){
         et1.setError("Enter valid email-id");
         et1.requestFocus();
         return;
     }
     if (pass.isEmpty()){
         et2.setError("enter password");
         et2.requestFocus();
         return;
     }
    if (cpass.isEmpty()){
         et3.setError("enter confirm password");
         et3.requestFocus();
         return;
    }
    if (!pass.equals(cpass)){
         et3.setError("password not matching");
         et3.requestFocus();
         return;
    }


       Mydatabase md=new Mydatabase(this);
        SQLiteDatabase sd=md.getWritableDatabase();

        ContentValues cv=new ContentValues();

        cv.put("password",pass);

      int count=  sd.update("employee_details",cv,"EMAIL=?",
                new String[]{em});

        if (count > 0){

            Toast.makeText(this, "password updated", Toast.LENGTH_SHORT).show();
            et1.setText("");et2.setText("");et3.setText("");
        }
        else {
            Toast.makeText(this, "Update failed", Toast.LENGTH_SHORT).show();
        }

    }

    public void back(View view) {

        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
