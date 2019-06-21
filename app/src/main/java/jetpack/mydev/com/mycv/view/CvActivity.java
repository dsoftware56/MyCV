package jetpack.mydev.com.mycv.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import jetpack.mydev.com.mycv.R;
import jetpack.mydev.com.mycv.presenter.CvPresenter;

import static jetpack.mydev.com.mycv.utils.Constantes.LOG_NAME_APP;

public class CvActivity extends Activity {
    private CvPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Quitamos el título de la ventana
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Seleccionamos el activity a mostrar
        setContentView(R.layout.activity_cv);
        //Inicializamos el presentador
        presenter = new CvPresenter(this);
    }


    @Override
    public void onBackPressed() {
        Log.d(LOG_NAME_APP, "----------------------onBackPressed---------------------------");
        presenter.minimizarApp();
    }
}