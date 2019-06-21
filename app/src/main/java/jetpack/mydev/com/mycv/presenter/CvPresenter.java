package jetpack.mydev.com.mycv.presenter;

import android.content.Intent;

import jetpack.mydev.com.mycv.view.CvActivity;

/**
 * Description:
 * Created by EX383473 on 20/06/2019.
 */
public class CvPresenter {
    private CvActivity view;

    /**
     * Constructor del presentador
     * @param view: es el actividad al que pertenece
     */
    public CvPresenter(CvActivity view) {
        this.view = view;
    }

    /**
     * Función encargada de minimizar la aplicación (realiza la misma función que presionar el botón Home)
     */
    public void minimizarApp(){
        //Cuando se presiona el botón back minimizamos la aplicación
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.startActivity(intent);
    }
}
