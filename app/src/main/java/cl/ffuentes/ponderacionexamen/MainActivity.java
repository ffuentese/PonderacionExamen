package cl.ffuentes.ponderacionexamen;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton = (Button)findViewById(R.id.btnCalcular);

        boton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        TextView mensaje = (TextView)findViewById(R.id.txvResult);


                        EditText pond = (EditText)findViewById(R.id.txtPond);
                        double valpond = Integer.parseInt(pond.getText().toString())*0.01;
                        EditText nota = (EditText)findViewById(R.id.txtPresentacion);
                        double valnota = Double.parseDouble(nota.getText().toString());
                        double result = valnota*valpond;
                        EditText notaMin = (EditText)findViewById(R.id.txtNotaMinima);
                        double notaMinima = Double.parseDouble(notaMin.getText().toString());
                        double notaNecesaria = (notaMinima - result)/(notaMinima/10);
                        DecimalFormat df = new DecimalFormat("#.0");


                        if(notaNecesaria<1){
                            mensaje.setText("Menos de 1 :)");
                        } else if(notaNecesaria>7){
                            mensaje.setText("Imposible pasar :(");
                        }
                        else {
                            mensaje.setText("Necesitas un " + df.format(notaNecesaria));
                        }

                    }
                }



        );




    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
