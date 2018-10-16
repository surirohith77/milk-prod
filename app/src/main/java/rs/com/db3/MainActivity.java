package rs.com.db3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Regiseer(View view) {
        startActivity(new Intent(this,RegisterActivity.class));
    }

    public void Login(View view) {

      EditText et1 = findViewById(R.id.et1);
      EditText et2 =  findViewById(R.id.et2);
     pb = findViewById(R.id.pb);


      String email = et1.getText().toString().trim();
        String pass = et2.getText().toString().trim();

        if (email.isEmpty()){
            et1.setError("Enter Email-id");
            et1.requestFocus();
            return;
        }
        if( !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            et1.setError("enter valid email-id");
            et1.requestFocus();
            return;
        }
        if (pass.isEmpty()){
            et2.setError("password missing");
            et2.requestFocus();
            return;
        }
        pb.setVisibility(View.VISIBLE);
        Mydatabase my=new Mydatabase(this);

        if (my.validate(email,pass)){
            pb.setVisibility(View.GONE);

    startActivity(new Intent(this,WelcomeActivity.class));
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
        }else {
            pb.setVisibility(View.GONE);

            Toast.makeText(this, "Wrong email or password", Toast.LENGTH_SHORT).show();
        }

    }

    public void Delete(View view) {

        startActivity(new Intent(this,DeleteActivity.class));

    }

    public void viewuser(View view) {
        startActivity(new Intent(this,ViewuserActivity.class));

    }

    public void updateuser(View view) {
        startActivity(new Intent(this,UpdateActivity.class));
    }
}
