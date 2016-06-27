package com.example.nrike.modelpresenterviewer1.Presenter;

import com.example.nrike.modelpresenterviewer1.Model.Model;
import com.example.nrike.modelpresenterviewer1.Viewer.MainActivityInterfice;
import com.example.nrike.modelpresenterviewer1.Viewer.MainActivityView;

/**
 * Created by nrike on 27/06/16.
 */
public class Presenter {

    Model model = new Model();
    public void check (MainActivityInterfice mainActivityInterfice,String a, String b, String result){

        try{

            int numa = Integer.parseInt(a);
            int numb = Integer.parseInt(b);
            int numresult = Integer.parseInt(result);

            int sum = model.sum(numa,numb);

            if (sum == numresult){
                mainActivityInterfice.showCorrect();
            }else{
                mainActivityInterfice.showIncorrect();
            }
        }catch (Exception e){
            mainActivityInterfice.showIncorrect();
        }






    }

}