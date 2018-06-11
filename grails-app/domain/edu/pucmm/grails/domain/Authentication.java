package edu.pucmm.grails.domain;

public class Authentication {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public Authentication() {
        setUsername("franco");
        setPassword("rfranco");
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Authentication(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public Boolean authenticate(String username, String password){

        if(username.equals(getUsername()) && password.equals(getPassword())){
            return true;
        }
        return false;
    }
}
