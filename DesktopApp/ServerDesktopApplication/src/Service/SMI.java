/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ModelLibraries.Account;

/**
 * Server Method Interfaces
 *
 * @author PC
 */
public interface SMI {

    public void openServer();

    public void acceptClient();

    public void openSql();

    public void closeSql();

    public void closeServer();

    public void wrapDataPackage(String query);

    public Account signInQuest(String user,String password,int type);
}
