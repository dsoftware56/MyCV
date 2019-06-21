package jetpack.mydev.com.mycv.presenter;

import android.content.Intent;
import android.os.Handler;

import jetpack.mydev.com.mycv.R;
import jetpack.mydev.com.mycv.view.CvActivity;
import jetpack.mydev.com.mycv.view.SplashActivity;

import static jetpack.mydev.com.mycv.utils.Constantes.TIME_SPLASH;

/**
 * Description: Clase encargada de tener la lógica de la vista Splash
 */
public class SplashPresenter {

    private SplashActivity view;

    /**
     * Constructor del presentador
     *
     * @param view: es el actividad al que pertenece
     */
    public SplashPresenter(SplashActivity view) {
        this.view = view;
    }

    /**
     * Función encargada de iniciar un hilo para para después lanzar la actividad CV
     */
    public void iniciarHandler() {
        //Arrancamos un hilo que en conteo regresivo mostrará la vista
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Inicializamos FireBase
                Intent intent = new Intent(view, CvActivity.class);
                view.startActivity(intent);
                //Terminamos la actividad actual
                view.finish();
                //Tener una trancición en el cambio de vista
                view.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        }, TIME_SPLASH);
    }

    /**
     * Función encargada de minimizar la aplicación (realiza la misma función que presionar el botón Home)
     */
    public void minimizarApp() {
        //Cuando se presiona el botón back minimizamos la aplicación
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.startActivity(intent);
    }
}
