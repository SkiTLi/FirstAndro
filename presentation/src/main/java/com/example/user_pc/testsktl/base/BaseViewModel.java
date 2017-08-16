package com.example.user_pc.testsktl.base;

/**
 * Created by USER-PC on 09.08.2017.
 */

//по сути baseviewmodellifecycle


public interface BaseViewModel {

    public void init();

    public void release();

    public void resume();

    public void pause();
}
