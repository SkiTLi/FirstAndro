package com.example.user_pc.testsktl.domain.entity;

public class AuthState {

    private boolean isSigned;

    public AuthState(boolean isSigned) {
        this.isSigned = isSigned;
    }

    public boolean isSigned() {
        return isSigned;
    }
}
