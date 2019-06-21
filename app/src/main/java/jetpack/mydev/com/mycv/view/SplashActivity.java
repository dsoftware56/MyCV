package jetpack.mydev.com.mycv.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import jetpack.mydev.com.mycv.R;
import jetpack.mydev.com.mycv.presenter.SplashPresenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import static jetpack.mydev.com.mycv.utils.Constantes.LOG_NAME_APP;
import static jetpack.mydev.com.mycv.utils.Constantes.TIME_SPLASH;

/**
 * Description: Clase encargada de tener los eventos y controles de vista para el splash
 */
public class SplashActivity extends Activity {
    private SplashPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(LOG_NAME_APP, "----------------SplashActivity.onCreate----------------------");
        super.onCreate(savedInstanceState);
        //Quitamos el título de la ventana
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Seleccionamos el activity a mostrar
        setContentView(R.layout.activity_splash);
        //Inicializamos el presentador
        presenter = new SplashPresenter(this);
        //iniciamos el hilo
        presenter.iniciarHandler();
    }

    @Override
    public void onBackPressed() {
        Log.d(LOG_NAME_APP, "----------------------onBackPressed---------------------------");
        presenter.minimizarApp();
    }
}
